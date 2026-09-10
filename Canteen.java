import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] food = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] price = {80, 120, 100, 70, 90};

        int totalQuantity = 0;
        double totalAmount = 0;
        double totalDiscount = 0;

        char again = 'Y';

        System.out.println("===== CANTEEN MENU =====");

        for (int i = 0; i < food.length; i++) {
            System.out.printf("%d. %-10s - $%.2f%n", i + 1, food[i], price[i]);
        }

        while (again == 'Y') {

            System.out.print("\nEnter item number: ");
            int item = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (item < 1 || item > 5 || quantity < 1 || quantity > 10) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");

                System.out.print("Do you want to order again? (Y/N): ");
                again = input.next().toUpperCase().charAt(0);

                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().toUpperCase().charAt(0);

            double subtotal = price[item - 1] * quantity;
            double discountRate = 0;

            if (student == 'Y' && subtotal >= 500) {
                discountRate = 0.15;
            } 
            else if (student == 'Y') {
                discountRate = 0.10;
            } 
            else if (subtotal >= 500) {
                discountRate = 0.05;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            totalQuantity += quantity;
            totalAmount += subtotal;
            totalDiscount += discount;

            System.out.printf("\nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = input.next().toUpperCase().charAt(0);
        }

        double finalAmount = totalAmount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalAmount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount to pay: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        input.close();
    }
}