public class Board {
  // Represents the board 
  private String[][] board;
  // Represents if there's a winner or not
  private boolean isWinner;
  // The exact amount of rows in the 2d array
  private int rowAmount;
  // The excact amount of columsn in the 2d array
  private int colAmount;
  // The amount of rows stated by the user
  private int userStatedRowAmount;
  // The amount of columns stated by the user
  private int userStatedColAmount;
  // The amount needed of a symbol in a row for a winner
  private int strikeAmount; 

  // Creates the board object
  public Board(int row, int col) {
    // Boolean that represents a winner
    this.isWinner = false;
    // The row the user stated
    this.userStatedRowAmount = row;
    // The columns the user stated 
    this.userStatedColAmount = col;
    // The amount of actual rows in the 2d array
    this.rowAmount = row + (row - 1);
    // The amount of actual columns in the 2d array
    this.colAmount = col + (col - 1);
    this.board = new String[rowAmount][colAmount];
    // Fills the board with strings
    this.fillBoard();
  }

  // Returns the 2d array that represents the board
  public String[][] getBoard(){
    return this.board;
  }

  // Returns if there's a winner in the game
  public boolean isWinner() {
    return this.isWinner;
  }

  // Sets if there's a winner in the game
  public void setIsWinner(boolean winner){
    this.isWinner = winner;
  }

  // Fills slot of with string dependent on the row and column index
  public void fillSlot(int r, int c) {
    // Row varient #1
    if (r % 2 == 0 && c % 2 == 0) {
      this.board[r][c] = "  ";
      return;
    }

    if (r % 2 == 0 && c % 2 != 0) {
      this.board[r][c] = "|";
      return;
    }
    // Row varient #2
    if (r % 2 != 0 && c % 2 == 0) {
      this.board[r][c] = "--";
      return;
    }

    if (r % 2 != 0 && c % 2 != 0) {
      this.board[r][c] = "|";
      return;
    }
  }

  // Fills out every single string of the board
  public void fillBoard() {
    for (int r = 0; r < this.rowAmount; r++) {
      for (int c = 0; c < this.colAmount; c++) {
        // Fills slot of with string dependent on the row and column index
        this.fillSlot(r, c);
      }
    }
  }

  // Displays and updates the row count in the console to help the user place their symbol
  public void displayRowNumber(int index, int rowCount) {
    if (index < this.rowAmount) {
      if (index % 2 != 0) {
        System.out.print(" ");
      } else {
        System.out.print(rowCount);
      }
    }
  }

  // Displays and updates the column count in the console to help the user place their symbol
  public void displayColumnNumber(int rowIndex) {
    if (rowIndex == this.rowAmount - 1) {
      for (int i = 1; i <= this.userStatedColAmount; i++) {
        System.out.print(" " + i + " ");
      }
      System.out.println(" ");
    }
  }

  // Prints out the entire tic-tac-toe board
  public void displayBoard() {
    // Variable used to mark the rows in the board
    int rowCount = 1;
    for (int r = 0; r < this.rowAmount; r++) {
      // Displays and updates the row count in the console
      this.displayRowNumber(r, rowCount);
      if (r % 2 == 0) {
        rowCount++;
      }

      // Prints out the value of the board
      for (int c = 0; c < this.colAmount; c++) {
        System.out.print(this.board[r][c]);
      }

      // Starts a new line to print the columns markings
      System.out.println(" ");

      // Displays and updates the column count in the console
      this.displayColumnNumber(r);
    }
  }

  // Places the symbol on the board by changing the value in 2d array
  public boolean placeSymbol(int row, int col, String sym) {
    // The row and col are already converted into the real indices at this point
    // If the slot they want to place is empty, allow the user to place their symbol there and return true. 
    if(this.board[row][col] == "  "){
    this.board[row][col] = sym;
      return true; //Placement was a success
    }
    return false; //Placement was a failure
  }

    // Returns if the board is full. Method is used to help determine a tie
    public boolean boardIsFull(){
      for(int r = 0; r < this.rowAmount; r++){
        for(int c = 0; c < this.colAmount; c++){
          if(this.board[r][c] == "  "){
            return false; //Found an empty string so the board is automically not empty
          }
        }
      }
      return true; //Not a single empty space was found so board is full
    }

}