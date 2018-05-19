package com.jamiecoe;

public class Main {

    // final is a like const - you cannot reassign the value
    private static final String INVALID_VAUE = "Invalid value";

    public static void main(String[] args) {
        String duration = getDurationString(3945);
        System.out.println("duration = " + duration);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || (seconds < 0 || seconds > 59)) {
            return INVALID_VAUE;
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        String stringHours = addZeroIfLowerThan10(hours);
        String stringMinutes = addZeroIfLowerThan10(remainingMinutes);
        String stringSeconds = addZeroIfLowerThan10(seconds);

        return stringHours + "h " + stringMinutes + "m " + stringSeconds + "s";
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return INVALID_VAUE;
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }

    public static String addZeroIfLowerThan10(int number) {
        return number >= 10 ? String.valueOf(number) : "0" + number;
    }
}
