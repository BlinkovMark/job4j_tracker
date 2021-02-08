package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " driving on the autobahn");
    }

    @Override
    public void brand() {
        System.out.println(getClass().getSimpleName() + " Volvo");
    }
}
