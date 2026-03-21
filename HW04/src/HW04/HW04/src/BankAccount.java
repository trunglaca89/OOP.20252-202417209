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
