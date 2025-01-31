import java.util.Scanner;
import java.util.Stack;

public class WebBrowser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> forwardStack = new Stack<>();
        Stack<String> backwardStack = new Stack<>();
        String currentUrl = "";

        while (true) {
            System.out.println("1. Open website");
            System.out.println("2. Go back");
            System.out.println("3. Go forward");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter website URL: ");
                    String url = scanner.nextLine();
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url+".com";
                    }
                    if (!currentUrl.isEmpty()) {
                        backwardStack.push(currentUrl);
                    }
                    currentUrl = url;
                    forwardStack.clear();
                    System.out.println("You are now at: " + currentUrl);
                    break;
                case 2:
                    if (!backwardStack.isEmpty()) {
                        forwardStack.push(currentUrl);
                        currentUrl = backwardStack.pop();
                        System.out.println("You are now at: " + currentUrl);
                    } else {
                        System.out.println("No previous websites to go back to.");
                    }
                    break;
                case 3:
                    if (!forwardStack.isEmpty()) {
                        backwardStack.push(currentUrl);
                        currentUrl = forwardStack.pop();
                        System.out.println("You are now at: " + currentUrl);
                    } else {
                        System.out.println("No next websites to go forward to.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}