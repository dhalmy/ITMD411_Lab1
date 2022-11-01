public class AccountHolder {

    private double balance;
    private static double annualInterestRate = 0.04;

    public AccountHolder() { //custom default constructor
        balance = 0;
    }

    public AccountHolder(double b) { //main constructor
        balance = b;
    }

    public void deposit(double d){ //method not used
        balance += d;
    }

    public void withdrawal(double w){ //method not used
        if(balance - w < 50){
            balance -= w;
        }
        else {
            System.out.println("Error, the balance must hold at least to $50. This withdrawal amount would take the account balance below $50");
        }
    }

    //    methods
    public void monthlyInterest(){
        balance += balance * (annualInterestRate / 12.0);
    }


    //      getters and setters
    public void setBalance(double b) {
        balance = b;
    }
    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double i){
        annualInterestRate = i;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }


    //    tostring
    public String toString() {
        monthlyInterest();
        return String.format("This is your balance with interest applied: $%.2f", getBalance());
    }
}
