package util;

public class InputValidator {
    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    public static boolean isValidAmount(double amt) {
        return amt >= 0;
    }
}
