package main.java;


//immutable classes

import java.util.ArrayList;
import java.util.List;

//we cannot change the value of the object once created
// Declare class as final so that it cannot be extended
// Class variables are initialized only once using constructor
// There should not be any setter methods which generally changes the value of object
// Just getter method and urns the copy of the member variable
// Ex: String and Wrapper Classes
public final class MyImmutableClass {
    private final String name;
    private final List<String> departments;

    public MyImmutableClass(String name, List<String> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getDepartments() {
        return new ArrayList<>(departments);
    }
}
