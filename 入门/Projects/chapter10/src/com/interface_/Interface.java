package com.interface_;

public interface Interface {
    public void start();
    public void stop();
}
class Phone implements Interface{
    @Override
    public void start() {
        System.out.println("phone start");
    }

    @Override
    public void stop() {
        System.out.println("phone stop");
    }
}
class Camera implements Interface {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

class Computer{
    public void work(Interface tmp){
        tmp.start();
        tmp.stop();
    }
}
class Test{
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();
        Computer computer = new Computer();
        computer.work(phone);

        computer.work(camera);
    }
}