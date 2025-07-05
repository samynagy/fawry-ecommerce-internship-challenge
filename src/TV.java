class TV extends Product implements Shippable {
    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        if (weight <= 0)
            throw new IllegalArgumentException("Weight must be positive.");
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
