import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<String> menuItems;
    private ArrayList<Double> prices;
    private ArrayList<Integer> quantities;
    private double taxRate;
    private double discount;

    public Order(double taxRate, double discount) {
        menuItems = new ArrayList<>();
        prices = new ArrayList<>();
        quantities = new ArrayList<>();
        this.taxRate = taxRate;
        this.discount = discount;
        initializeMenu();
    }

    private void initializeMenu() {
        menuItems.add("Nasi Goreng");
        prices.add(25000.0);
        menuItems.add("Mie Goreng");
        prices.add(20000.0);
        menuItems.add("Ayam Bakar");
        prices.add(30000.0);
    }

    /**
     *
     * @param menuIndex
     * @param quantity
     */

    public void addOrder(int menuIndex, int quantity) {
            quantities.add(quantity);
            System.out.println("Added " + quantity + " x " + menuItems.get(menuIndex));
        }

    /**
     *
     * @return
     */
    public double calculateSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < quantities.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * taxRate / 100;
    }

    public double calculateDiscount() {
        return calculateSubtotal() * discount / 100;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax() - calculateDiscount();
    }

    public void printReceipt() {
        System.out.println("\n=== Nota Pemesanan ===");
        for (int i = 0; i < quantities.size(); i++) {
            System.out.println(menuItems.get(i) + " x" + quantities.get(i) + " = " + prices.get(i) * quantities.get(i));
        }
        System.out.println("Subtotal: " + calculateSubtotal());
        System.out.println("Pajak (" + taxRate + "%): " + calculateTax());
        System.out.println("Diskon (" + discount + "%): -" + calculateDiscount());
        System.out.println("Total: " + calculateTotal());
    }

    public void displayMenu() {
        System.out.println("=== Daftar Menu ===");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i) + " - " + prices.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order(10, 5); // Pajak 10% dan diskon 5%

        order.displayMenu();
        System.out.println("\nMasukkan nomor menu dan jumlah (0 untuk selesai):");

        while (true) {
            System.out.print("Nomor Menu: ");
            int menuIndex = scanner.nextInt() - 1;
            if (menuIndex < 0 || menuIndex >= order.menuItems.size()) break;

            System.out.print("Jumlah: ");
            int quantity = scanner.nextInt();

            order.addOrder(menuIndex, quantity);
        }

        order.printReceipt();
        scanner.close();
    }
}
