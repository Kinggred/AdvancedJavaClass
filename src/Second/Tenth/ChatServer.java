package Second.Tenth;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(8888));
            serverChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Serwer czatu uruchomiony na porcie 8888.");

            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        acceptClient(selector, serverChannel);
                    }

                    if (key.isReadable()) {
                        try {
                            handleClientInput(key, selector);
                        } catch (IOException e) {
                            // Obsługa wyjątku w przypadku błędu odczytu
                            System.out.println("Błąd odczytu od klienta: " + e.getMessage());
                            key.channel().close();
                            key.cancel();
                        }
                    }

                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptClient(Selector selector, ServerSocketChannel serverChannel) throws IOException {
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);

        System.out.println("Nowy klient dołączył: " + clientChannel.getRemoteAddress());
    }

    private static void handleClientInput(SelectionKey key, Selector selector) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientChannel.read(buffer);

        if (bytesRead == -1) {
            // Klient zamknął połączenie
            System.out.println("Klient opuścił czat: " + clientChannel.getRemoteAddress());
            clientChannel.close();
            key.cancel();
        } else {
            // Odczytaj wiadomość i przekaż ją do innych klientów
            buffer.flip();
            byte[] messageBytes = new byte[buffer.remaining()];
            buffer.get(messageBytes);
            String message = new String(messageBytes);

            System.out.println("Klient (" + clientChannel.getRemoteAddress() + "): " + message);

            // Przekaż wiadomość do innych klientów
            broadcastMessage(selector, clientChannel, message);
        }
    }

    private static void broadcastMessage(Selector selector, SocketChannel sender, String message) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            if (key.isValid() && key.channel() instanceof SocketChannel && key.channel() != sender) {
                SocketChannel clientChannel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                clientChannel.write(buffer);
            }
        }
    }
}