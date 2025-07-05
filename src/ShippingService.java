import java.util.*;

interface Shippable {
    String getName();
    double getWeight();
}

class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> weights = new LinkedHashMap<>();

        for (Shippable s : items) {
            counts.put(s.getName(), counts.getOrDefault(s.getName(), 0) + 1);
            weights.put(s.getName(), s.getWeight());
            totalWeight += s.getWeight();
        }

        for (String name : counts.keySet()) {
            int count = counts.get(name);
            double weight = weights.get(name);
            System.out.printf("%dx %s\t%.0fg\n", count, name, weight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }
}
