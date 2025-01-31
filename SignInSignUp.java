// import java.io.*;
// import java.util.Scanner;

// public class SignInSignUp {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         File file = new File("users.txt");

//         while (true) {
//             System.out.println("1. Sign Up\n2. Sign In\n3. Exit");
//             System.out.print("Choose an option: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine(); 

//             if (choice == 1) {
//                 System.out.print("Enter username: ");
//                 String username = scanner.nextLine();
//                 System.out.print("Enter password: ");
//                 String password = scanner.nextLine();

//                 try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
//                     writer.write(username + "," + password);
//                     writer.newLine();
//                     System.out.println("Sign-up successful!");
//                 } catch (IOException e) {
//                     System.out.println("Error: " + e.getMessage());
//                 }
//             } else if (choice == 2) {
//                 System.out.print("Enter username: ");
//                 String username = scanner.nextLine();
//                 System.out.print("Enter password: ");
//                 String password = scanner.nextLine();

//                 boolean success = false;
//                 try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                     String line;
//                     while ((line = reader.readLine()) != null) {
//                         String[] parts = line.split(",");
//                         if (parts[0].equals(username) && parts[1].equals(password)) {
//                             success = true;
//                             break;
//                         }
//                     }
//                 } catch (IOException e) {
//                     System.out.println("Error: " + e.getMessage());
//                 }

//                 if (success) {
//                     System.out.println("Sign-in successful!");
//                 } else {
//                     System.out.println("Invalid username or password.");
//                 }
//             } else if (choice == 3) {
//                 System.out.println("Exiting...");
//                 break;
//             } else {
//                 System.out.println("Invalid choice. Try again.");
//             }
//         }

//         scanner.close();
//     }
// }
import java.util.Scanner;

public class SignInSignUp {
    private static String[][] users = new String[100][2];
    private static int[] rollNumbers = new int[100];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Sign Up\n2. Sign In\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                signUp(scanner);
            } else if (choice == 2) {
                signIn(scanner);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void signUp(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(username)) {
                System.out.println("Username already exists. Please choose another username.");
                return;
            }
        }

        users[userCount][0] = username;
        users[userCount][1] = password;
        rollNumbers[userCount] = rollNum;
        userCount++;

        System.out.println("Sign-up successful!");
    }

    private static void signIn(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                System.out.println("Sign-in successful!");
                displayUserDetails(i);
                return;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
    }

    private static void displayUserDetails(int userIndex) {
        System.out.println("\n----- User Details -----");
        System.out.println("Username: " + users[userIndex][0]);
        System.out.println("Roll Number: " + rollNumbers[userIndex]);
        System.out.println("---------------------\n");
    }
}