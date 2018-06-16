package Lesson11;

public class Person {
    private String name;
    private String surname;
    private String profession;
    private int age;

    @Override
    public String toString() {
        return (this.name + " " + this.surname+ " " + this.profession);
    }
}
