public class SearchAlg {
  // Returns if there's a tic tac toe going vertical
  public static boolean vertical(String[][] board, int strikeAmount, String sym, int row, int col) {
    // Variable used to keep track of total same symbols
    int totalSameSym = 0;
    // Goes through the board horizontally.
    for (int r = 0; r < board.length; r += 2) {
        String currentPiece = board[r][col];
        if (currentPiece.equals(sym)) {
          totalSameSym++;
        } else {
          totalSameSym = 0;
        }
    }
    
  // Returns if there a tic tac toe vertically
  return totalSameSym>=strikeAmount;
  }

  // Returns if the palced symbol is a tic-tac-toe horizontally
  public static boolean horizontal(String[][] board, int strikeAmount, String sym, int row, int col) {
    // Counter used to keep track of number of same symbols
    int totalSameSym = 0;
    // Goes through the board horizontally
    for (int c = 0; c < board[row].length; c += 2) {
      String currentPiece = board[row][c];
      // If the slot is equal to the symbol Ex "X"
      if (currentPiece.equals(sym)) {
        totalSameSym++;
      } else {
        // Resets the counter because I want to track a streak
        totalSameSym = 0;
      }
    }
    // Returns if there's a tic tac toe horizontally
    return totalSameSym >= strikeAmount;
  }

  // Returns the number of same symbols going top right to bottom left
  public static int topRightToBottomLeft(String[][] board, String sym, int row, int col) {
    int totalSameSym = 0;
    // New row and column indexs becaause I don't want to check the placed symbol only others spots
    int newRow = row + 2;
    int newCol = col - 2;
    // Goes through 2d array going top right to bottom left
    while (newRow < board.length && newCol >= 0) {
      String currentPiece = board[newRow][newCol];
      if (currentPiece.equals(sym)) {
        totalSameSym++;
      } else {
        return 0;
      }
      newRow += 2;
      newCol -= 2;
    }
    // Returns the number of length of the streak 
    return totalSameSym;
  }

  // Returns the number of same symbosl going from bottom left to top right
  public static int bottomLeftTopRight(String[][] board, String sym, int row, int col) {
    int totalSameSym = 0;
    // Update the row and columns becasue I don't want to include the placed coin
    int newRow = row - 2;
    int newCol = col + 2;
    //Goes through board bottom left to top right
    while (newRow >= 0 && newCol < board[row].length) {
      String currentPiece = board[newRow][newCol];
      if (currentPiece.equals(sym)) {
        totalSameSym++;
      } else {
        //Immeditaly returns becasue streak is broken 
        return totalSameSym;
      }
      newRow -= 2;
      newCol += 2;
    }
    // Returns the streak going bottom left to top right
    return totalSameSym;
  }

  // Retursn if there's a tic tac toe going left to right diagonally
  public static boolean leftToRightDiagonal(String[][] board, int strikeAmount, String sym, int row, int col){
    //Variable is 1 because I include the placed coin
    int totalSameSymbols = 1;
    // Streak of same symbols going top right to bottom left
    int symbolsGoingRightToLeftDiagonal = SearchAlg.topRightToBottomLeft(board, sym, row, col);
    totalSameSymbols += symbolsGoingRightToLeftDiagonal;
    // Streak of same symbols going bottom left to top right
    int symbolsGoingLeftToRightDiagonal = SearchAlg.bottomLeftTopRight(board, sym, row, col); 
    totalSameSymbols += symbolsGoingLeftToRightDiagonal;
    // Returns if the total strike is a tic tac toe
    return totalSameSymbols >= strikeAmount;
  }

  // Returns the length of the streak going bottom right to top left
  public static int bottomRightTopLeft(String[][] board, int strikeAmount, String sym, int row, int col) {
    int totalSameSym = 0;
    //Create new row and column index to not include the placed coin in streak
    int newRow = row - 2;
    int newCol =  col - 2;
    //Goes through the board going bottom right to top left
    while (newRow >= 0 && newCol >= 0) {
      String currentPiece = board[newRow][newCol];
      if (currentPiece.equals(sym)) {
        totalSameSym++;
      } else {
        // Returns because the streak is broken
        return totalSameSym;
      }
      newRow -= 2;
      newCol -= 2;
    }
    // Returns the length of the streak
    return totalSameSym;
  }

  // Returns the length of the streak going top left to bottom right
  public static int topLeftBottomRight(String[][] board, int strikeAmount, String sym, int row, int col) {
    int totalSameSym = 0;
    //New index because I don't want to include the placed coin in the streak
    int newRow = row + 2;
    int newCol = col + 2;
    // Goes through to board from top left to bottom right
    while (newRow < board.length && newCol < board[row].length) {
      String currentPiece = board[newRow][newCol];
      if (currentPiece.equals(sym)) {
        totalSameSym++;
      } else {
        // Returns because the streak is broken
        return totalSameSym;
      }
      newRow += 2;
      newCol += 2;
    }
    // Returns the length of the streak
    return totalSameSym;
  }

  // Returns if there's a tic tac toe going left to right diagonally
  public static boolean rightToLeftDiagonal(String[][] board, int strikeAmount, String sym, int row, int col){
    // Variable is 1 because I include the placed coin
    int totalSameSymbols = 1;
    // Streak of same symbols going bottom right to top left
    int symbolsGoingRightToLeftDiagonal = SearchAlg.bottomRightTopLeft(board, strikeAmount, sym, row, col);
    // SearchAlg.printInt(symbolsGoingRightToLeftDiagonal);
    totalSameSymbols += symbolsGoingRightToLeftDiagonal;
    // Streak of same symbols going top left to bottom right 
    int symbolsGoingLeftToRightDiagonal = SearchAlg.topLeftBottomRight(board, strikeAmount, sym, row, col); 
    totalSameSymbols += symbolsGoingLeftToRightDiagonal;
       // SearchAlg.printInt(symbolsGoingLeftToRightDiagonal);
    // Returns if the total streak is a tic tac toe
    return totalSameSymbols >= strikeAmount;
  }

  // Checks the board for EVERY possible scenario to win to determine a winner
  public static boolean isThereAWinner(String[][] board, int strikeAmount, String sym, int row, int col) {
    // Represents if there's a winner vertically 
    boolean win1 = SearchAlg.vertical(board, strikeAmount, sym, row, col);
    // SearchAlg.printBoolean(win1, 1);
    // Represents if there's a winner horizontally
    boolean win2 = SearchAlg.horizontal(board, strikeAmount, sym, row, col);
        // SearchAlg.printBoolean(win2, 2);
    // Represents if there's a winner going left to right diagonally
    boolean win3 = SearchAlg.leftToRightDiagonal(board, strikeAmount, sym, row,
        col);
        // SearchAlg.printBoolean(win3, 3);
    // Represents if there's a winner going right to left diagonally
    boolean win4 = SearchAlg.rightToLeftDiagonal(board, strikeAmount, sym, row, col);
        // SearchAlg.printBoolean(win4, 4);
    //Returns if there's at least 1 scenario when the player wins 
    return win1 || win2 || win3 || win4;
  }

}