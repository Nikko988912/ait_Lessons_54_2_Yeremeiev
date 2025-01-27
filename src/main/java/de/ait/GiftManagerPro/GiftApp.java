package de.ait.GiftManagerPro;

import java.util.Scanner;

public class GiftApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GiftManager manager = new GiftManager();
        System.out.println("Welcome to the Gift Management System!");
        boolean running = true;

        while (running) {
            System.out.println("Choose an action:");
            System.out.println("1 - Add Gift");
            System.out.println("2 - Show All Gifts");
            System.out.println("3 - Filter Gifts by Category");
            System.out.println("4 - Update Gift Status");
            System.out.println("5 - Exit");
            System.out.print("Choose an action: ");

            // Проверяем ввод на корректность
            String choiceInput = scanner.nextLine();
            if (!choiceInput.matches("\\d")) { // Проверяем, является ли ввод цифрой от 1 до 9
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue; // Возвращаемся в начало цикла
            }

            int choice = Integer.parseInt(choiceInput);

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter gift name: ");
                    String name = scanner.nextLine();

                    System.out.print("Choose category (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
                    String categoryInput = scanner.nextLine().toUpperCase();

                    GiftCategory category = null;
                    if (categoryInput.equals("ELECTRONICS") || categoryInput.equals("TOYS") ||
                            categoryInput.equals("BOOKS") || categoryInput.equals("CLOTHING") ||
                            categoryInput.equals("HOME_APPLIANCES")) {
                        category = GiftCategory.valueOf(categoryInput);
                    } else {
                        System.out.println("Invalid category. Please try again.");
                        break;
                    }

                    System.out.print("Choose status (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");
                    String statusInput = scanner.nextLine().toUpperCase();

                    GiftStatus status = null;
                    if (statusInput.equals("AVAILABLE") || statusInput.equals("OUT_OF_STOCK") ||
                            statusInput.equals("RESERVED") || statusInput.equals("DELIVERED")) {
                        status = GiftStatus.valueOf(statusInput);
                    } else {
                        System.out.println("Invalid status. Please try again.");
                        break;
                    }

                    manager.addGift(new Gift(name, category, status));
                    System.out.println("Gift added successfully!");
                    break;

                case 2:
                    System.out.println("List of all gifts:");
                    for (Gift gift : manager.getAllGifts()) {
                        System.out.println(gift);
                    }
                    break;

                case 3:
                    System.out.print("Choose category to filter by (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
                    String filterCategoryInput = scanner.nextLine().toUpperCase();

                    GiftCategory filterCategory = null;
                    if (filterCategoryInput.equals("ELECTRONICS") || filterCategoryInput.equals("TOYS") ||
                            filterCategoryInput.equals("BOOKS") || filterCategoryInput.equals("CLOTHING") ||
                            filterCategoryInput.equals("HOME_APPLIANCES")) {
                        filterCategory = GiftCategory.valueOf(filterCategoryInput);
                    } else {
                        System.out.println("Invalid category. Please try again.");
                        break;
                    }

                    System.out.println("Filtered gifts:");
                    for (Gift gift : manager.filterByCategory(filterCategory)) {
                        System.out.println(gift);
                    }
                    break;

                case 4:
                    System.out.print("Enter gift name to update status: ");
                    name = scanner.nextLine();

                    System.out.print("Choose new status (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");
                    String newStatusInput = scanner.nextLine().toUpperCase();

                    GiftStatus newStatus = null;
                    if (newStatusInput.equals("AVAILABLE") || newStatusInput.equals("OUT_OF_STOCK") ||
                            newStatusInput.equals("RESERVED") || newStatusInput.equals("DELIVERED")) {
                        newStatus = GiftStatus.valueOf(newStatusInput);
                    } else {
                        System.out.println("Invalid status. Please try again.");
                        break;
                    }

                    manager.updateGiftStatus(name, newStatus);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the program. Thank you for using the Gift Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
