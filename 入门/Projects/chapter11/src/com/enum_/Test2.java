package com.enum_;

/**
 * @author
 */
public class Test2 {
    public static void main(String[] args) {
        new Cellphone().testWork();
    }
}
interface Computer{
    public void work();
}
class Cellphone{
    public void testWork(){
        Computer computer = new Computer(){
            @Override
            public void work() {
                System.out.println("cellphone compute");

            }
        };
        computer.work();
    }
}