package com.innerclass;

public class Exercise {
    public static void main(String[] args) {
        new Cellphone().test();
        new Cellphone().test1();
    }
}

interface Bell{
    public void ring();
}
class Cellphone {
    public void alarmClock(Bell bell){
        bell.ring();
    }
    public void test(){
        alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("pig wake up");
            }
        });
    }
    public void test1(){
        alarmClock(new Clock(){
            @Override
            public void ring() {
                System.out.println("go to class");
            }
        });
    }
}
class Clock implements Bell{
    @Override
    public void ring() {

    }
}