import java.util.Scanner;

public class MiniChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ChatBot! Type 'quit' to exit.");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            processInput(input);
        }

        scanner.close();
    }

    public static void processInput(String input) {
        switch (input.toLowerCase()) {
            case "hello":
                System.out.println("Hi! How can I help you today?");
                break;
            case "hi":
                System.out.println("Hey! What's on your mind?");
                break;
            case "thanks":
                System.out.println("You're welcome!");
                break;
            default:
                System.out.println("I didn't quite catch that. Try again!");
        }
    }
}