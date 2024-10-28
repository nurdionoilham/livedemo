import java.util.Scanner;

public class PemesananTiket {
// Harga tiket berdasarkan kategori
private static final double VIP_PRICE = 100000.0;
private static final double REGULAR_PRICE = 50000.0;
private static final double ECONOMY_PRICE = 30000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("== Pemesanan Tiket Sepak Bola ===");
        System.out.println("Pilih jenis tiket:");
        System.out.println("1. VIP (Rp" + VIP_PRICE + ")");
        System.out.println("2. Regular (Rp" + REGULAR_PRICE + ")");
        System.out.println("3. Economy (Rp" + ECONOMY_PRICE + ")");
        System.out.print("Masukkan pilihan Anda (1-3): ");

        int ticketType = scanner.nextInt();
        double ticketPrice;

        // Memilih harga tiket berdasarkan input
        switch (ticketType) {
            case 1:
                ticketPrice = VIP_PRICE;
                break;
            case 2:
                ticketPrice = REGULAR_PRICE;
                break;
            case 3:
                ticketPrice = ECONOMY_PRICE;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
        int ticketQuantity = scanner.nextInt();

        if (ticketQuantity <= 0) {
            System.out.println("Jumlah tiket harus lebih dari 0!");
            return;
        }

        // Menghitung total harga
        double totalPrice = ticketPrice * ticketQuantity;

        // Menampilkan ringkasan pesanan
        System.out.println("\n=== Ringkasan Pemesanan ===");
        String ticketCategory = ticketType == 1 ? "VIP" : ticketType == 2 ? "Regular" : "Economy";
        System.out.println("Kategori Tiket: " + ticketCategory);
        System.out.println("Jumlah Tiket: " + ticketQuantity);
        System.out.println("Harga per Tiket: Rp" + ticketPrice);
        System.out.println("Total Harga: Rp" + totalPrice);

        scanner.close();
    }
}


