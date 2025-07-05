abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative.");
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative.");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative.");
        this.quantity = quantity;
    }
}
