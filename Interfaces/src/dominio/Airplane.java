package dominio;

public class Airplane extends Vehicle implements Flyer {

    @Override
    public void takeOff() {
        System.out.println("accelerate until lift-off");
        System.out.println("raise landing gear");
    }

    @Override
    public void land() {
        System.out.println("lower landing gear");
        System.out.println("decelerate and lower flaps until touch-down");
        System.out.println("apply brakes");
    }

    @Override
    public void fly() {
        System.out.println("keep those engines running");
    }
}
