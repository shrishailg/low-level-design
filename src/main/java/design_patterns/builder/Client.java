package main.java.design_patterns.builder;

public class Client {

    public static void main(String[] args){

        Student student = new StudentBuilder().setRollNumber(1).setAge(12).setName("Shrishail")
                .setFatherName("Srhis")
                .setMotherName("Ganga")
                .setRollNumber(1)
                .build();

        System.out.println(student);

    }
}
