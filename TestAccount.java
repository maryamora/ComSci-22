/*
 * A Test Driver for the Account class.
 */
public class TestAccount {
   public static void main(String[] args) {
      
      Account ac1 = new Account(13131313);
      System.out.println(ac1);  
 
      ac1.setBalance(25000.35);
      System.out.println(ac1);  
      System.out.println("Account number is: " + ac1.getAccountNumber());
      System.out.println("Balance is: " + ac1.getBalance());
       
      ac1.credit(25000.2);
      System.out.println(ac1);
      ac1.debit(25000.0);
      System.out.println(ac1);
   }
}
