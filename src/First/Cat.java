package First;

abstract class Animal {
    private String nazwa;
    public Animal(String nazwa) {
        this.nazwa = nazwa;
    }

    public abstract void dajGlos();
}

class Dog extends Animal {
    public Dog(String nazwa) {
        super(nazwa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Szczeka");
    }
}

public class Cat extends Animal {
    public Cat(String nazwa) {
        super(nazwa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Miauczy");
    }
}