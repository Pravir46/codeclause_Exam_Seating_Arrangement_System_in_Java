import java.util.Scanner;

public class Seating {
    static Scanner sc = new Scanner(System.in);
    static String adminUsername = "pravir";
    static String adminPassword = "123";
    static String studentUsername = "harry";
    static String studentPassword = "345";
    static int totalStudents;
    static int totalClasses;
    static int seatsPerClass;
    static int[][] seatingArrangement;
    static int[] seatsTaken;

    static boolean login(String username, String password) {
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        } else if (username.equals(studentUsername) && password.equals(studentPassword)) {
            return true;
        }
        System.out.println("Incorrect username or password.");
        return false;
    }

    static void adminMenu() {
        System.out.println("Welcome, Admin.");
        System.out.println("1. Enter exam details");
        System.out.println("2. Generate seating arrangement");
        System.out.println("4. View seating arrangement");
        System.out.println("3. Log out");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                enterExamDetails();
                break;
            case 2:
                generateSeatingArrangement();
                break;
            case 3:
                System.out.println("You have successfully logged out.");
                break;
            case 4:
                viewSeatingArrangement();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    static void studentMenu() {
        System.out.println("Welcome, Student.");
        System.out.println("1. View seating arrangement");
        System.out.println("2. Log out");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                viewSeatingArrangement();
                break;
            case 2:
                System.out.println("You have successfully logged out.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    static void enterExamDetails() {
        System.out.print("Enter total number of students: ");
        totalStudents = sc.nextInt();
        System.out.print("Enter total number of classes: ");
        totalClasses = sc.nextInt();
        System.out.print("Enter number of seats per class: ");
        seatsPerClass = sc.nextInt();
        seatingArrangement = new int[totalClasses][seatsPerClass];
        seatsTaken = new int[totalClasses];
        System.out.println("Exam details have been successfully entered.");
    }

    static void generateSeatingArrangement() {
        int studentCount = 1;
        for (int i = 0; i < totalClasses; i++) {
            for (int j = 0; j < seatsPerClass; j++) {
                if (studentCount > totalStudents) {
                    break;
                }
                seatingArrangement[i][j] = studentCount;
                seatsTaken[i]++;
                studentCount++;
            }
        }
        System.out.println("Seating arrangement has been generated successfully.");
    }



    static void viewSeatingArrangement() {
        System.out.println("Seating Arrangement:");
        System.out.print("Class\t");
        for (int i = 1; i <= seatsPerClass; i++) {
            System.out.print("Seat " + i + "\t");
        }
        System.out.println();
        for (int i = 0; i < totalClasses; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < seatsPerClass; j++) {
                System.out.print(seatingArrangement[i][j] + "\t");
            }
            System.out.println();
        }
        return;
    }



    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Exam Seating Arrangement System.");
            System.out.println("1. Log in as Admin");
            System.out.println("2. Log in as Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();
                    if (login(username, password)) {
                        adminMenu();
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = sc.next();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    if (login(username, password)) {
                        studentMenu();
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
