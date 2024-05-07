package First;

import java.util.ArrayList;

import java.util.List;



public class DziedziczenieINadpisywanieMetod {

    public static void main(String[] args) {
        Pies pies = new Pies("Reksio");
        Kot kot = new Kot("Mruczek");

        pies.dajGlos();
        kot.dajGlos();

        List<Zwierze> zwierzeta = new ArrayList<>();
        zwierzeta.add(new Kot("Kicia"));
        zwierzeta.add(new Pies("Burek"));
        zwierzeta.add(new Pies("Tofik"));
        zwierzeta.add(new Kot("Mruczek"));
        zwierzeta.add(new Kot("Filemon"));
        for (Zwierze zwierze : zwierzeta) {
            zwierze.dajGlos();
            zwierze.biegnij();
        }
    }
}
class Zwierze {
    String imie;

    Zwierze(String imie) {
        this.imie = imie;
    }

    void biegnij() {
        System.out.println(imie + " biegnie");
    }

    void dajGlos() {
        System.out.println("Dźwięk zwierzęcia");
    }
}

class Pies extends Zwierze {

    Pies(String imie) {
        super(imie);
    }

    @Override
    void dajGlos() {
        System.out.println(imie + " szczeka");
    }
}

class Kot extends Zwierze {
    Kot(String imie) {
        super(imie);
    }

    @Override
    void dajGlos() {
        System.out.println(imie + " miauczy");
    }
}