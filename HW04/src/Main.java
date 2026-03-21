public class Main{
    public static void main(String[] args){
        
        // 1. CREATE BANK ACCOUNTS (Create 2 valid accounts and 1 invalid)
        BankAccount acc1 = new BankAccount("TK01", "Linh", 500000.0);
        BankAccount acc2 = new BankAccount("TK02", "Binh", 100000.0);
        BankAccount accFail = new BankAccount("TK03", "Chau", 20000.0);

        // 2. PERFORM OPERATIONS (Perform valid and invalid transactions)
        
        // 2.1. Deposit (Valid / Invalid)
        acc1.deposit(200000.0); 
        acc1.deposit(-5000.0);  

        // 2.2. Withdraw (Valid / Invalid)
        acc2.withdraw(30000.0); 
        acc2.withdraw(50000.0); 

        // 2.3. Transfer (Valid / Invalid)
        acc1.transfer(acc2, 100000.0); 
        acc2.transfer(acc1, 500000.0); 

        // 2.4. Pay Bill
        acc1.payBill("Electric Bill", 50000.0); 

        // 3. SHOW RESULTS (Handled automatically by BankAccount class)

        // 4. PRINT THE FINAL BALANCE
        System.out.println("\n--- FINAL BALANCE SUMMARY ---");
        System.out.println("Account " + acc1.getAccountNumber() + " - Owner: " + acc1.getOwnerName() + " - Balance: " + acc1.getBalance());
        System.out.println("Account " + acc2.getAccountNumber() + " - Owner: " + acc2.getOwnerName() + " - Balance: " + acc2.getBalance());
    }
}
