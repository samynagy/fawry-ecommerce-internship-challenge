class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Customer name cannot be empty.");
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative.");
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() { return balance; }

    public void deduct(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Deduction cannot be negative.");
        if (amount > balance)
            throw new IllegalStateException("Insufficient balance.");
        balance -= amount;
    }
}
