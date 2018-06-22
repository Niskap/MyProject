package Lesson11;

import Lesson9.Car;

public class Person {
    private String name = "nm";
    private String surname = "sn";
    private String profession = "pro";
    private int age = 4;

    Car car = new Car();

    int [] arrays = {3,4,5,6};


    public String toString() {
        return (this.name + " " + this.surname+ " " + this.profession);
    }
}
