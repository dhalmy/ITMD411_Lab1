import java.util.Scanner;
public class AccountHolderTest {

    public static void main(String args[]){

        AccountHolder  obj1 = new AccountHolder (); //creates the account object

        System.out.println("Please enter a balance"); //sets initial (positive) balance
        double balanceVal = enterNum();
        obj1.setBalance(balanceVal);

        System.out.println("Please enter a deposit"); //takes a deposit and applies the deposit to the balance of the account
        double depositVal = enterNum();
        obj1.setBalance(obj1.getBalance() + depositVal);

        double withdrawVal; //instantiates variable to use in the do-while below
        int cnt = 0; //using basic counter to differentiate first loop through the do-while to tell the user error message if they need to pass through the while loop more than just once
        do{
            if(cnt == 0){
                System.out.println("Please enter a withdraw");
                cnt++;
            }
            else{
                System.out.println("Error, the balance must hold at least to $50. This withdrawal amount would take the account balance below $50.");
                System.out.println("Please enter a valid withdrawal amount or enter '0' to cancel your withdraw");
            }

            withdrawVal = enterNum();
        }
        while((obj1.getBalance() - withdrawVal < 50)); //exits the do-while once a value is intered that won't drop the balance below $50
        obj1.setBalance(obj1.getBalance() - withdrawVal); //subtracts the acceptable withdrawVal from the balance


        System.out.println(obj1.toString()); //calls tostring which outputs balance after applied interest


    }


    public static double enterNum(){ //method created to catch any invalid inputs like negative numbers or non-numbers
        Scanner n = new Scanner(System.in);
        boolean cont = true; //probably redundant now after making this a method with a return inside, but no point in messing with it
        do{
            if(n.hasNextDouble()){ //checks if the scanner can parse through the input before actually doing so in order to prevent error
                double val = n.nextDouble();
                if(val >= 0){ //checks if it's a positive number
                    return val; //returns the val back to method call
                }
                else{
                    System.out.println("Negative value error. Please enter a number again.");
                    cont = true; //probably redundant
                }
            }
            else{
                System.out.println("Error, invalid character. Please enter a number again.");
                n.nextLine(); //have to make scanner parse through invalid input or else the scanner won't work as intended
                cont = true; //probably redundant
            }
        }
        while(cont);
        n.close();
        return 0.0; //need a default return statement, won't ever get executed
    }
}