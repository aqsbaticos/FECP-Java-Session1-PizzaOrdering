package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		//	PSEUDO-DB
		ArrayList<String> pizzas = new ArrayList<String>();
		ArrayList<Integer> quantities = new ArrayList<Integer>();

		//	PROGRAM START
		String option = "";
		System.out.println("1. Add Order");
		System.out.println("2. Update Order");
		System.out.println("3. Remove Order");
		System.out.println("4. View Orders");
		System.out.println("5. Exit");
		while (!option.equals("5")) {
			System.out.print("Choose option: ");
				option = in.next();

			switch(option) {
				case "1":
					System.out.print("Pizza type: ");
						String newPizza = in.next();
					System.out.print("Quantity: ");
						int newQuantity= in.nextInt();
					addOrder(pizzas, quantities, newPizza, newQuantity);
					System.out.println("");
					break;
				case "2":
					System.out.print("Order number to update: ");
						int orderNumber = in.nextInt();
					System.out.print("New quantity: ");
						newQuantity = in.nextInt();
					updateOrder(quantities, orderNumber, newQuantity);
					System.out.println("");
					break;
				case "3":
					System.out.print("Order number to remove: ");
						orderNumber = in.nextInt();
					removeOrder(pizzas, quantities, orderNumber);
					System.out.println("");
					break;
				case "4":
					printOrders(pizzas, quantities);
					break;
				default:
					break;
			}
		}

		System.out.println("---Thank You!---");
		in.close();
	}

	//  -- METHODS
	static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
		if (quantity > 0) {
			pizzas.add(pizzaType);
			quantities.add(quantity);
		} else System.out.println("[ERROR] Please enter a valid quantity.");
	}

	static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
		if (newQuantity > 0) {
			try {
				quantities.set(index-1, newQuantity);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Order to be updated doesn't exist. [ERROR] " + e.getMessage() + ".");
			}
		} else System.out.println("[ERROR] Please enter a valid quantity.");
	}

	static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
		try {
			pizzas.remove(index-1);
			quantities.remove(index-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Order to be removed doesn't exist. [ERROR] "+ e.getMessage() + ".");
		}
	}

	static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
		System.out.println("");
		System.out.println("--- Current Orders ---");
		for (int i=0; i<pizzas.size(); i++) {
			System.out.printf("%d. %s x %d\n", i+1, pizzas.get(i), quantities.get(i));
		}
		System.out.println("");
	}
}