package service;

import model.Transaction;
import dao.DataManager;
import java.util.*;

public class ExpenseService {
    private List<Transaction> transactions;
    private double salary;
    private double budget;

    public ExpenseService() {
        this.transactions = DataManager.loadTransactions();
        double[] config = DataManager.loadConfig();
        this.salary = config[0];
        this.budget = config[1];
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        DataManager.saveTransactions(transactions);
        if (t.getType().equalsIgnoreCase("Expense") && getTotalExpenses() > budget) {
            System.out.println("[ALERT] You have exceeded your monthly budget!");
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
        saveConfig();
    }

    public void setBudget(double budget) {
        this.budget = budget;
        saveConfig();
    }

    public double getBalance() {
        return salary - getTotalExpenses();
    }

    public double getTotalExpenses() {
        return transactions.stream().filter(t -> t.getType().equalsIgnoreCase("Expense")).mapToDouble(Transaction::getAmount).sum();
    }

    public void showSummary() {
        System.out.println("--- Category-wise Summary ---");
        Map<String, Double> summary = new HashMap<>();
        for (Transaction t : transactions) {
            summary.put(t.getCategory(), summary.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
        }
        summary.forEach((k, v) -> System.out.println(k + ": Rs. " + v));
        System.out.println("Current Balance: Rs. " + getBalance());
    }

    public void searchByCategory(String category) {
        transactions.stream().filter(t -> t.getCategory().equalsIgnoreCase(category)).forEach(System.out::println);
    }

    public void searchByDate(String date) {
        transactions.stream().filter(t -> t.getDate().equalsIgnoreCase(date)).forEach(System.out::println);
    }

    public void showMonthlyReport(String month) {
        System.out.println("--- Transactions for " + month + " ---");
        transactions.stream().filter(t -> t.getDate().contains("-" + month + "-")).forEach(System.out::println);
    }

    private void saveConfig() {
        DataManager.saveConfig(salary, budget);
    }
}
