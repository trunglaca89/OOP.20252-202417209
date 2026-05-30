public class BankAccount{
    
    public static final double MIN_BALANCE = 50000.0;
    public static final double TRANSFER_FEE_RATE = 0.02;

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance){
        if(ownerName.equals("")){
            System.out.println("Error: Name cannot be empty.");
        }else if(initialBalance < MIN_BALANCE){
            System.out.println("Error: Initial balance must be >= " + MIN_BALANCE);
        }else{
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = initialBalance;
            System.out.println("Account created: " + this.accountNumber);
        }
    }

    public String getAccountNumber(){ return this.accountNumber; }
    public String getOwnerName(){ return this.ownerName; }
    public double getBalance(){ return this.balance; }

    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
            System.out.println("Deposit successful.");
        }else{
            System.out.println("Deposit failed: Amount must be > 0.");
        }
    }

    public void withdraw(double amount){
        if(amount > 0){
            if(this.balance - amount >= MIN_BALANCE){
                this.balance -= amount;
                System.out.println("Withdraw successful.");
            }else{
                System.out.println("Withdraw failed: Insufficient balance.");
            }
        }else{
            System.out.println("Withdraw failed: Amount must be > 0.");
        }
    }

    public void transfer(BankAccount receiver, double amount){
        if(amount > 0){
            double totalDeduction = amount + (amount * TRANSFER_FEE_RATE);
            if(this.balance - totalDeduction >= MIN_BALANCE){
                this.balance -= totalDeduction;
                receiver.balance += amount;
                System.out.println("Transfer successful.");
            }else{
                System.out.println("Transfer failed: Insufficient balance.");
            }
        }else{
            System.out.println("Transfer failed: Amount must be > 0.");
        }
    }

    public void payBill(String billName, double amount){
        if(amount > 0){
            if(this.balance - amount >= MIN_BALANCE){
                this.balance -= amount;
                System.out.println("Pay bill successful.");
            }else{
                System.out.println("Pay bill failed: Insufficient balance.");
            }
        }else{
            System.out.println("Pay bill failed: Amount must be > 0.");
        }
    }
}
