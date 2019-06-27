package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        String ans = "";
        System.out.println("Enter the instructor's name:");
        String name = read.nextLine();
        System.out.println("Enter their address:");
        String address = read.nextLine();
        System.out.println("Enter the date:");
        String date = read.nextLine();
        System.out.println("Enter the account number:");
        int number = read.nextInt();
        int maxLength = 0;
        read.nextLine();
        ans = "yes";
        while (!ans.equals("no")) {
            if (ans.equals("yes")) {
                System.out.println("Enter the item name:");
                String itemName = read.nextLine();
                if (itemName.length() > maxLength) {
                    maxLength = itemName.length();
                }
                System.out.println("Enter the price:");
                double price = read.nextDouble();
                read.nextLine();
                System.out.println("Enter the quantity:");
                int amount = read.nextInt();
                read.nextLine();
                System.out.println("Is this item taxable? (true/false)");
                boolean tax = read.nextBoolean();
                String state = "";
                if (tax) {
                    read.nextLine();
                    System.out.println("Enter your state: ");
                    state = read.nextLine();
                } else {
                    read.nextLine();
                }
                Item order = new Item(itemName, price, amount, tax);
                if (tax) {
                    order.setState(state);
                }
                items.add(order);
            }
            System.out.println("Enter in another item? Type yes/no");
            ans = read.nextLine();
        }
        int tabs = (maxLength / 4) + 1;
        System.out.println("-----------------------------------------------------");
        System.out.println("Customer Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Date: " + date);
        System.out.println("Account number: " + number);
        System.out.println("-----------------------------------------------------\n");
        System.out.println("Item Name" + FormatHelper.getTabs("Item Name", tabs) + "Quantity\t\tPrice\t\t\tCost\t\t\tTaxable");
        System.out.println("=========================================================================");
        double subtotal = 0;
        double total = 0;
        for (Item i : items) {
            System.out.println(i.getName() + FormatHelper.getTabs(i.getName(), tabs) + i.getQuantity() + "\t\t\t\t" + Item.round(i.getPrice()) + "\t\t\t"
                    + Item.round(i.getPrice() * i.getQuantity()) + "\t\t\t" + i.isTaxable());
            subtotal += i.getTotal();
            total += i.getTotalWithTax();
        }
        System.out.println();
        System.out.println("Subtotal: $" + Item.round(subtotal));
        System.out.println("Sales Tax: $" + Item.round(total - subtotal));
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Total: $" + Item.round(total));
    }
}
