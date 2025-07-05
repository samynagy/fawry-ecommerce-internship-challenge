import java.util.*;

class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty())
            throw new IllegalArgumentException("Cart is empty.");

        double subtotal = 0.0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;

            if (p instanceof Expirable && ((Expirable)p).isExpired())
                throw new IllegalStateException(p.getName() + " is expired.");

            if (item.quantity > p.getQuantity())
                throw new IllegalStateException(p.getName() + " is out of stock.");

            subtotal += item.quantity * p.getPrice();

            if (p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    toShip.add((Shippable)p);
                }
            }
        }

        double shippingFee = toShip.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total)
            throw new IllegalStateException("Insufficient balance.");

        customer.deduct(total);

        for (CartItem item : cart.getItems()) {
            item.product.setQuantity(item.product.getQuantity() - item.quantity);
        }

        if (!toShip.isEmpty())
            ShippingService.ship(toShip);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFee);
        System.out.printf("Amount\t%.0f\n", total);
    }
}
