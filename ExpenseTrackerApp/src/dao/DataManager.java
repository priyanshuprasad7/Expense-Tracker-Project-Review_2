package dao;

import model.Transaction;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_NAME = "transactions.dat";
    private static final String CONFIG_FILE = "config.dat";

    public static void saveTransactions(List<Transaction> transactions) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(transactions);
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }

    public static List<Transaction> loadTransactions() {
        List<Transaction> list = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = (List<Transaction>) in.readObject();
        } catch (Exception e) {
            // Ignore if file doesn't exist yet
        }
        return list;
    }

    public static void saveConfig(double salary, double budget) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(CONFIG_FILE))) {
            dos.writeDouble(salary);
            dos.writeDouble(budget);
        } catch (IOException e) {
            System.out.println("Error saving config: " + e.getMessage());
        }
    }

    public static double[] loadConfig() {
        double[] config = {0.0, 0.0};
        try (DataInputStream dis = new DataInputStream(new FileInputStream(CONFIG_FILE))) {
            config[0] = dis.readDouble();
            config[1] = dis.readDouble();
        } catch (IOException e) {
            // default values
        }
        return config;
    }
}