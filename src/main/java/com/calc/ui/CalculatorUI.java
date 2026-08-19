package com.calc.ui;

import com.calc.calculator.Calculator;
import com.calc.history.HistoryManager;
import com.calc.storage.FileStorage;

import java.util.Scanner;

public class CalculatorUI {
    private final Scanner scanner = new Scanner(System.in);
    private final Calculator calculator = new Calculator();
    private final HistoryManager historyManager = new HistoryManager();
    private final FileStorage fileStorage = new FileStorage("calculator_history.txt");

    public void start() {
        boolean running = true;

        while (running) {
            clearScreen();
            showHeader();

            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. View History");
            System.out.println("6. Exit");
            System.out.print("\nChoose an option: ");

            int choice = readInt();

            switch (choice) {
            case 1 -> performCalculation("sum");
            case 2 -> performCalculation("difference");
            case 3 -> performCalculation("product");
            case 4 -> performCalculation("fraction");
            case 5 -> showHistory();
            case 6 -> running = false;
            default -> pause("Invalid option. Press Enter to continue...");
            }
        }

        System.out.println("Calculator closed.");
    }

    private void performCalculation(String operation) {
        clearScreen();
        showHeader();

        System.out.print("Enter first number: ");
        int a = readInt();

        System.out.print("Enter second number: ");
        int b = readInt();

        String record;

        try {
            switch (operation) {
            case "sum" -> {
                int result = calculator.sum(a, b);
                record = a + " + " + b + " = " + result;
            }
            case "difference" -> {
                int result = calculator.difference(a, b);
                record = a + " - " + b + " = " + result;
            }
            case "product" -> {
                int result = calculator.product(a, b);
                record = a + " * " + b + " = " + result;
            }
            case "fraction" -> {
                String result = calculator.fraction(a, b);
                record = a + " / " + b + " = " + result;
            }
            default -> {
                pause("Unknown operation. Press Enter to continue...");
                return;
            }
            }

            System.out.println("\nResult: " + record);

            historyManager.addRecord(record);
            fileStorage.saveRecord(record);

        } catch (ArithmeticException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        pause("\nPress Enter to continue...");
    }

    private void showHistory() {
        clearScreen();
        showHeader();

        System.out.println("Calculation History");
        System.out.println("-------------------");

        if (historyManager.getHistory().isEmpty()) {
            System.out.println("No calculations yet.");
        } else {
            for (String record : historyManager.getHistory()) {
                System.out.println(record);
            }
        }

        pause("\nPress Enter to continue...");
    }

    private void showHeader() {
        System.out.println("==============================");
        System.out.println("       SIMPLE CALCULATOR       ");
        System.out.println("==============================\n");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void pause(String message) {
        System.out.print(message);
        scanner.nextLine();
        scanner.nextLine();
    }
}
