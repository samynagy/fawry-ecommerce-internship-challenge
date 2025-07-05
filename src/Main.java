import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100, 5, 0.2, LocalDate.now().plusDays(5)); // 200g each
        Biscuits biscuits = new Biscuits("Biscuits", 150, 2, 0.7, LocalDate.now().plusDays(3)); // 700g each
        TV tv = new TV("TV", 5000, 3, 10);
        MobileScratchCard scratchCard = new MobileScratchCard("Scratch Card", 50, 10);

        Customer customer = new Customer("Ali", 1000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        CheckoutService.checkout(customer, cart);
    }
}
