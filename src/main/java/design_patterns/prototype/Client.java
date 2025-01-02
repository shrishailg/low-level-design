package main.java.design_patterns.prototype;

public class Client {

    public static void main(String... args){
        Student student = new Student(1,12,"Shrishail");

        Student clonedObj = (Student) student.clone();
        clonedObj.setName("Sharath");

        System.out.println(clonedObj.getName());
    }
}
