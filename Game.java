import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public Game() {
        scanner = new Scanner(System.in);
        player1Score = 0;
        player2Score = 0;
    }

    public void play() {
        System.out.println("Welcome to Snake Water Gun Game!");
        System.out.println("Game Rules:");
        System.out.println("- Snake drinks Water");
        System.out.println("- Water dampens Gun");
        System.out.println("- Gun shoots Snake");
        
        System.out.print("\nEnter Player 1's name: ");
        player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        player2Name = scanner.nextLine();
        
        while (true) {
            System.out.println("\nMake your choice:");
            System.out.println("1. Snake");
            System.out.println("2. Water");
            System.out.println("3. Gun");
            System.out.println("4. Quit");
            System.out.println("\n" + player1Name + "'s turn (Player 2, please look away!)");
            int player1Choice = scanner.nextInt();
            
            if (player1Choice == 4) {
                break;
            }
            
            if (player1Choice < 1 || player1Choice > 3) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }
            System.out.println(player2Name + "'s turn");
            int player2Choice = scanner.nextInt();
            
            if (player2Choice == 4) {
                break;
            }
            
            if (player2Choice < 1 || player2Choice > 3) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }
            
            String player1Move = convertChoice(player1Choice);
            String player2Move = convertChoice(player2Choice);
            
            System.out.println("\n" + player1Name + " chose: " + player1Move);
            System.out.println(player2Name + " chose: " + player2Move);
            
            determineWinner(player1Move, player2Move);
            displayScore();
        }
        
        System.out.println("\nFinal Score:");
        displayScore();
        scanner.close();
    }
    
    private String convertChoice(int choice) {
        switch (choice) {
            case 1: return "Snake";
            case 2: return "Water";
            case 3: return "Gun";
            default: return "";
        }
    }
    
    private void determineWinner(String player1Move, String player2Move) {
        if (player1Move.equals(player2Move)) {
            System.out.println("It's a tie!");
            return;
        }
        
        boolean player1Wins = 
            (player1Move.contains("Snake") && player2Move.contains("Water")) ||
            (player1Move.contains("Water") && player2Move.contains("Gun")) ||
            (player1Move.contains("Gun") && player2Move.contains("Snake"));
            
        if (player1Wins) {
            System.out.println(player1Name + " wins!");
            if (player1Move.contains("Snake")) {
                System.out.println("Snake drinks the Water!");
            } else if (player1Move.contains("Water")) {
                System.out.println("Water dampens the Gun!");
            } else {
                System.out.println("Gun shoots the Snake!");
            }
            player1Score++;
        } else {
            System.out.println(player2Name + " wins!");
            if (player2Move.contains("Snake")) {
                System.out.println("\n Snake drinks the Water!");
            } else if (player2Move.contains("Water")) {
                System.out.println("\n Water dampens the Gun!");
            } else {
                System.out.println("\n Gun shoots the Snake!");
            }
            player2Score++;
        }
    }
    
    private void displayScore() {
        System.out.println(player1Name + ": " + player1Score + " | " + player2Name + ": " + player2Score);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
