package main;

import model.Transaction;
import service.ExpenseService;
import util.InputValidator;

import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
          ExpenseService service = new ExpenseService();
          int choice;

          do {
              System.out.println("\n--- Expense Tracker Menu ---");
              System.out.println("1. Add Transaction");
              System.out.println("2. Show Summary");
              System.out.println("3. Set Salary");
              System.out.println("4. Set Budget");
              System.out.println("5. Show Monthly Report");
              System.out.println("6. Search by Category");
              System.out.println("7. Search by Date");
              System.out.println("0. Exit");
              System.out.print("Enter choice: ");
              choice = sc.nextInt();
              sc.nextLine();

              switch (choice) {
                  case 1:
                      System.out.print("Type (Income/Expense): ");
                      String type = sc.nextLine();
                      System.out.print("Category: ");
                      String cat = sc.nextLine();
                      System.out.print("Date (dd-mm-yyyy): ");
                      String date = sc.nextLine();
                      if (!InputValidator.isValidDate(date)) {
                          System.out.println("Invalid date format!");
                          break;
                      }
                      System.out.print("Amount: ");
                      double amt = sc.nextDouble();
                      if (!InputValidator.isValidAmount(amt)) {
                          System.out.println("Amount must be positive!");
                          break;
                      }
                      sc.nextLine();
                      System.out.print("Recurring (true/false): ");
                      boolean recur = sc.nextBoolean();
                      sc.nextLine();
                      service.addTransaction(new Transaction(type, cat, date, amt, recur));
                      break;
                  case 2:
                      service.showSummary();
                      break;
                  case 3:
                      System.out.print("Enter Monthly Salary: ");
                      service.setSalary(sc.nextDouble());
                      break;
                  case 4:
                      System.out.print("Enter Monthly Budget: ");
                      service.setBudget(sc.nextDouble());
                      break;
                  case 5:
                      System.out.print("Enter Month (MM): ");
                      service.showMonthlyReport(sc.next());
                      break;
                  case 6:
                      System.out.print("Enter Category to search: ");
                      service.searchByCategory(sc.nextLine());
                      break;
                  case 7:
                      System.out.print("Enter Date to search (dd-mm-yyyy): ");
                      service.searchByDate(sc.nextLine());
                      break;
                  case 0:
                      System.out.println("Exiting...");
                      break;
                  default:
                      System.out.println("Invalid option!");
              }
          } while (choice != 0);
        }
    }
}

