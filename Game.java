import java.util.Random;
import java.util.Scanner;

public class Game {
  private Player player1;
  private Player player2;
  private Player currentPlayer;
  private int pieces;
  private Scanner scanner;

  public Game() {
    scanner = new Scanner(System.in);
    populate();
    player1 = new Player(getPlayerName(1));
    player2 = new Player(getPlayerName(2));
    currentPlayer = player1;
  }

  private void populate() {
    this.pieces = (int) (Math.random() * 41) + 10;
  }

  private String getPlayerName(int playerNumber) {
    System.out.print("Enter name for Player " + playerNumber + ": ");
    return scanner.nextLine();
  }

  public void play() {
    while (pieces > 0) {
      System.out.println(currentPlayer.getName() + " 's turn. There are " + pieces + " pieces remaining.");
      int move = getPlayerMove();
      removePieces(move);
      if (pieces <= 0) {
        System.out.println(currentPlayer.getName() + " wins!");
        break;
      }
      switchPlayer();
    }
  }
  
  private int getPlayerMove() {
    int move;
    do {
      System.out.println("How many pieces would you like to take?");
      while (!scanner.hasNextInt()) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.next();
      }
      move = scanner.nextInt();
      if (move < 1 || move > 3) {
        System.out.println("Invalid input. Please enter a number between 1 and 3.");
      }
    } while (move < 1 || move > 3);
    
    return move;  
   }
  
  private void removePieces(int number) {
    this.pieces -= number;
  }

  private void switchPlayer() {
    if (currentPlayer == player1) {
      currentPlayer = player2;
    } else {
      currentPlayer = player1;
    }
  }
}