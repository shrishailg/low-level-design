package main.java.design_patterns.template;

//Template method: when you want all classes to follow specific steps to process
// the tasks but provide flexibility that each class can have their own logic in that specific step

public class Template {

    public static void main(String... args) {
        PaymentFlow paymentFlow = new PayToFriend();

        paymentFlow.sendMoney();
    }
}

abstract class PaymentFlow {
    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void debitAmount();
    public abstract void creditAmount();

    //this is the Template method: which defines the order of steps to execute the task
    public final void sendMoney() {
        //step 1
        validateRequest();

        //step 2
        calculateFees();

        //step 3
        debitAmount();

        //step 4
        creditAmount();
    }
}

class PayToFriend extends PaymentFlow {

    @Override
    public void validateRequest() {

    }

    @Override
    public void calculateFees() {

    }

    @Override
    public void debitAmount() {

    }

    @Override
    public void creditAmount() {

    }
}

class PayToMerchant extends PaymentFlow {

    @Override
    public void validateRequest() {

    }

    @Override
    public void calculateFees() {

    }

    @Override
    public void debitAmount() {

    }

    @Override
    public void creditAmount() {

    }
}


