package main.java.design_patterns.builder;

public class Student {
    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;

    public Student(StudentBuilder builder){
        this.rollNumber = builder.rollNumber;
        this.age = builder.age;
        this.name = builder.name;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
    }

    public String toString(){
        return " roll number: " + this.rollNumber +
                " age: " + this.age +
                " name: " + this.name +
                " father name: " + this.fatherName +
                " mother name: " + this.motherName;
    }

//    public int hashCode() {
//        return 1;
//    }
}
