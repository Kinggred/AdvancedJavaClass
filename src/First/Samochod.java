package First;

interface Pojazd {
    void przyspiesz(int predkosc);
    void zwolnij(int predkosc);
}

public class Samochod implements Pojazd {
    public int getAktualnaPredkosc() {
        return aktualnaPredkosc;
    }

    private int aktualnaPredkosc = 0;

    @Override
    public void przyspiesz(int predkosc) {
        aktualnaPredkosc += predkosc;
    }

    @Override
    public void zwolnij(int predkosc) {
        aktualnaPredkosc -= predkosc;
    }
}