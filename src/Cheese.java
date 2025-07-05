import java.time.LocalDate;

class Cheese extends Product implements Shippable, Expirable {
    private double weight;
    private LocalDate expiryDate;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        if (weight <= 0)
            throw new IllegalArgumentException("Weight must be positive.");
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Expiry date cannot be in the past.");
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public double getWeight() {
        return weight;
    }
}
