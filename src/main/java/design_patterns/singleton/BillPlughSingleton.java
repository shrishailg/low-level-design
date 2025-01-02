package main.java.design_patterns.singleton;

public class BillPlughSingleton {

    private BillPlughSingleton() {

    }

    //nested classes variables are not initialized during class loading but during usage or when used
    private static class SingletonHelper{
        private static final BillPlughSingleton INSTANCE_OBJECT = new BillPlughSingleton();
    }

    public static BillPlughSingleton getInstance() {
        return SingletonHelper.INSTANCE_OBJECT;
    }
}
