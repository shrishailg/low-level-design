package main.java;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cse");
        list.add("ece");

        MyImmutableClass myImmutableClass = new MyImmutableClass("Shrishail", list);

        System.out.println(myImmutableClass);

        myImmutableClass.getDepartments().add("me");

        System.out.println(myImmutableClass);
    }
}
