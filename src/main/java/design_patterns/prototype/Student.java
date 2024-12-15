package main.java.design_patterns.prototype;

public class Student implements ProtoType {
    private int rollNumber;
    private int age;
    private String name;

    public Student(int rollNumber, int age, String name) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ProtoType clone() {
        return new Student(rollNumber, age, name);
    }
}
