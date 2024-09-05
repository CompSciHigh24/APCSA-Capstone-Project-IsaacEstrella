import java.util.Scanner;

class Player {
  // Represents if the player is able to place an X
  private boolean isX;
  // Represents the row the player wants to place
  private int row;
  // Represents the column the player wants to place
  private int col;
  // Represents the name of the user
  private String name;
  // The symbol that represents what the user is placing
  private String symbol;
  // The scanner object used to ask the user for input on the row, col, and name
  private Scanner inputReader;

  // Constructs the player object with all properites
  // public Player(boolean isX, String name, String symbol) {
  //   this.isX = isX;
  //   this.name = name;
  //   this.symbol = symbol;
  //   this.inputReader = new Scanner(System.in);
  // }

  // Creates a player and the variables are filled out by asking the user later
  public Player() {
    this.isX = false;
    this.name = null;
    this.symbol = null;
    this.inputReader = new Scanner(System.in);
  }

  // Returns the name of the user
  public String getName() {
    return this.name;
  }

  // Sets if the user can place an X
  public void setIsX(boolean isX) {
    this.isX = isX;
  }

  // Returns the symbol the user uses to place in the board
  public String getSymbol() {
    return this.symbol;
  }

  // Sets the symbol used to place on the board
  public void setSymbol(String sym) {
    this.symbol = sym;
  }

  // Ask the user a name and sets the name variable
  public void askName(boolean isPlayerOne) {
    if (isPlayerOne) {
      // If player one then set the name of player one
      System.out.println("Enter username player one");
      this.name = this.inputReader.nextLine();
    } else {
      // If player two then set the name of player two
      System.out.println("Enter username player two");
      this.name = this.inputReader.nextLine();
    }
  }

  // Ask and sets the user's row
  public void askRow(int maxRows) {
    System.out.println("Enter row location");
    // The user is put in a loop until they state a valid row
    while (true) {
      if (inputReader.hasNextInt()) {
        this.row = inputReader.nextInt();
        //If the user stated a int and meets the requires stop asking for row
        if (this.row >= 1 && this.row <= maxRows) {
          return;
        } else {
          // User stated input that wasn't within bounds of the board
          System.out.println("Try another input");
        }
      } else {
        //User stated a string not a int
        String invalidInput = inputReader.next();
        System.out.println("Try another input");
      }
    }
  }

  // Ask and sets the user's column
  public void askCol(int maxCols) {
    System.out.println("Enter column location");
    // User is put in a loop unitl they state a valid column
    while (true) {
      if (inputReader.hasNextInt()) {
        this.col = inputReader.nextInt();
        //Column user stated is a int and within bounds so stop asking for location
        if (this.col >= 1 && this.col <= maxCols) {
          return;
        } else {
          //User stated a column that wasn't within bounds but was a st
          System.out.println("Try another input");
        }
      } else {
        // User stated a string not an int
        String invalidInput = inputReader.next();
        System.out.println("Try another input");
      }
    }
  }

  // Returns the real row index Ex: "Place X in row 1" isn't row 1 in 2d array
  public int getRealRowOrColIndex(int rc) {
    // Math required to convert the user's row and col into the real indices
    return rc + (rc - 2);
  }

  //Converts the rows and cols the user put into the real indices
  public void convertRowCol(){
    this.row = this.getRealRowOrColIndex(this.row);
    this.col = this.getRealRowOrColIndex(this.col);
  }

  // Ask player location and takes error handling into consideration
  public void askLocation(int maxRows, int maxCols) {
    this.askRow(maxRows);
    this.askCol(maxCols);
    // After the user was asked where they want to place, the row and column location are converted to the actuall indexs on the board
    this.convertRowCol();
  }

  // Gets the row the user wants to place a symbol
  public int getRow() {
    return this.row;
  }

  // Gets the column the user wants to place a symbol
  public int getCol() {
    return this.col;
  }

  // Returns if the player is X
  public boolean isX() {
    return this.isX;
  }


}