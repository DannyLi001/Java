package com.enum_;

/**
 * @author
 */
public class Test3 {
    public static void main(String[] args) {
        Person tang = new Person("唐", new Horse());
        tang.common();
        tang.passRiver();
        tang.common();
        tang.passRiver();
        tang.common();
        tang.passRiver();
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("horse");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("boat");
    }
}

class Factory {
    private static Horse horse = new Horse();

    public static Boat boat() {
        return new Boat();
    }

    public static Horse horse() {
        return horse;
    }
}

class Person {
    private String name;
    private Vehicles vehicle;

    public Person(String name, Vehicles vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public void passRiver() {
        if(!(vehicle instanceof Boat)){
            vehicle = Factory.boat();
        }
        vehicle.work();
    }

    public void common() {
        if(!(vehicle instanceof Horse)){
            vehicle = Factory.horse();
        }
        vehicle.work();
    }

}