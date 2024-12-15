package main.java.design_patterns.proxy;

//This pattern helps to provide control access to original object
public class Proxy {
}

interface EmployeeDao {
    void create();
}


class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create() {

    }
}

class EmployeeDaoProxy implements EmployeeDao {
    EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create() {
        if (true) { // some condition
            employeeDao.create();
        } else {
            throw new RuntimeException("");
        }
    }
}
