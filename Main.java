import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Creates the instance variables for all the players
    Players allPlayers = new Players();
    // Stores the names of the players and creates their symbols by asking for their names
    allPlayers.createAllPlayers();
    // Ask the user for the desired size for the board and the strike amount
    allPlayers.setupBoard();
    // Amount of symbols in a row for a win
    int strikeToWin = allPlayers.getStrikeAmount();
    // Creates the tic-tac-toe board by using the rows and cols the user wants
    Board ticTacToe = new Board(allPlayers.getDesiredRows(), allPlayers.getDesiredCols());
    // Prints out the entire board
    ticTacToe.displayBoard();
    // The amount of rows and cols the user asked for
    int maxRowLoc = allPlayers.getDesiredRows();
    int maxColLoc = allPlayers.getDesiredCols();

    // While there's not a winner do all of this
    while (!ticTacToe.isWinner()) {
      // Tells the players who's turn it is
      System.out.println(allPlayers.getCurrentPlayer().getName() + "'s turn! " + allPlayers.getCurrentPlayer().getSymbol());
      // Gets the current player
      Player currentPlayer = allPlayers.getCurrentPlayer();
      // Gets the symbol of the current player Ex: "X"
      String playerSymbol = currentPlayer.getSymbol();
      // Ask the current player where they want to place and considers the size of the board Ex: you can't place on row 4 if the board is a 3 X 3
      // amount
      currentPlayer.askLocation(maxRowLoc, maxColLoc);
      // Gets the real row index of the placement
      int currentPlayerRowLoc = currentPlayer.getRow();
      // Gets the real column index of the placement
      int currentPlayerColLoc = currentPlayer.getCol();
      // While loop that ensures the user places a symbol in the correct spot that's not full
        // If the placement worked
        boolean successfulPlacement = ticTacToe.placeSymbol(currentPlayerRowLoc, currentPlayerColLoc, playerSymbol);
      while (true) {
        // If the placement failed the user is asked to try another placement
        if (!successfulPlacement) {
          System.out.println("Incorrect placement try again!");
          // Ask the user another location to place
          currentPlayer.askLocation(maxRowLoc, maxColLoc);
          successfulPlacement = ticTacToe.placeSymbol(currentPlayer.getRow(), currentPlayer.getCol(), playerSymbol);
        } else {
          // The user correctly placed their symbol so the program leaves the while loop
          break;
        }
      }
      // Represents if the user's placement resulted in a win
      boolean placedWinningPosition = SearchAlg.isThereAWinner(ticTacToe.getBoard(), strikeToWin, playerSymbol,
          currentPlayerRowLoc, currentPlayerColLoc);
      // Represents if the board is full
      boolean fullBoard = ticTacToe.boardIsFull();
      // If there's there's a tie then print out "no one wins" and stop the game
      if (!placedWinningPosition && fullBoard) {
        System.out.println("No one wins!");
        // Stops the game
        break;
      }
      // Prints out the board
      ticTacToe.displayBoard();
      // If there's a winner, print the name of the current player and tell them they won
      if (placedWinningPosition) {
        System.out.print(currentPlayer.getName() + " you are the winner!");
        // Ends the game
        ticTacToe.setIsWinner(true);
      }
      // Swaps the player if there's no tie or a winner
      allPlayers.swapCurrentPlayer();
    }
  }

}