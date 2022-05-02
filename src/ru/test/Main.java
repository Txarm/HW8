package ru.test;

import java.time.LocalDate;

public class Main {
    private static void checkLeapYear(int currentYear) {
        if ((currentYear % 400 == 0) || (currentYear % 4 == 0 && currentYear % 100 != 0)) {
            System.out.println(currentYear + " - високостный год");
        } else {
            System.out.println(currentYear + " - не високостный год");
        }
    }

    private static String checkSystem(String system) {
        if (system.contains("iOs")) {
            return "iOs";
        } else {
            if (system.contains("Android")) {
                return "Android";
            } else {
                return "Error";
            }
        }
    }

    private static int checkYear(int year) {
        int currentYear = LocalDate.now().getYear();
        if (year == currentYear) {
            return 0;
        }
        return 1;
    }

    private static int countDeliveryDays(int distance) {
        int deliveryDays = 0;
        if (distance <= 20) {
            return deliveryDays + 1;
        } else {
            for (distance = 21; distance < 200; distance = distance + 40) {
               deliveryDays = deliveryDays + 1;
            }
            return deliveryDays;
        }
    }

    private static void ptintApp(String system, int year) {
        String printSystem = checkSystem(system);
        int printYear = checkYear(year);
        if (system.contains("iOs") && year == 1) {
            System.out.println("Install iOS app's light version");
        } else if (system.contains("Android") && year == 1) {
            System.out.println("Install Android app's light version");
        } else if (system.contains("iOs") && year == 0) {
            System.out.println("Install standard iOS app");
        } else if (system.contains("Android") && year == 0) {
            System.out.println("Install standard Android app");
        }else if (system.contains("Error")) {
            throw new RuntimeException("Неизвестная операционная система");
        }
    }

    public static void main(String[] args) {
//        Task 1
        int year = 1916;
        checkLeapYear(year);

//        Task 2
        String phoneSystem = "Android";
        int deviceYear = 2021;
        String deviceSystem = checkSystem(phoneSystem);
        int yearCheckPhone = checkYear(deviceYear);
        ptintApp(checkSystem(phoneSystem), checkYear(deviceYear));

//        Task 3
        int deliveryDistance = 95;
        int deliveryDays = countDeliveryDays(deliveryDistance);
        System.out.println("Доставка займет " + deliveryDays + " дней.");
    }
}
