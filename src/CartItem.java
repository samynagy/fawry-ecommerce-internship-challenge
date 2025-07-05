class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null.");
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive.");
        this.product = product;
        this.quantity = quantity;
    }
}
