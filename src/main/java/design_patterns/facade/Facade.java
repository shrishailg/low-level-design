package main.java.design_patterns.facade;

//This pattern is used to hide the system complexity from the client
public class Facade {
    public static void main(String... args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();

        employeeFacade.insert();
    }
}

//exposing only the functions that client needs
class EmployeeFacade {
    EmployeeDao employeeDao;

    public EmployeeFacade() {
        this.employeeDao = new EmployeeDao();
    }

    public void insert() {
        employeeDao.insert();
    }
}


class EmployeeDao {

    public void insert() {
        System.out.println("inserting the values");
    }

    public void delete() {
        System.out.println("deleting the values");
    }

    public void get() {
        System.out.println("getting the values");
    }

    public void getById() {
        System.out.println("getting the values by id");
    }
}


