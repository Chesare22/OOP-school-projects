package modelo;

public class Cat extends Animal implements Pet {
    private String name;

    public Cat(String name) {
        this();
        setName(name);
    }

    public Cat() {
        super(4);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Cat named " + getName() + " is playing.");
    }

    @Override
    public void eat() {
        System.out.println("Cat named " + getName() + " is eating.");
    }
}
