package modelo;

public class Fish extends Animal implements Pet {
    private String name;

    public Fish() {
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
        System.out.println("Fish named " + getName() + " is playing.");
    }

    @Override
    public void eat() {
        System.out.println("Fish named " + getName() + " is eating.");
    }

    @Override
    public void walk() {
        System.out.println("Swimming like a good boi");
    }
}
