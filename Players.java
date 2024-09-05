import java.util.ArrayList;
import java.util.Scanner;
class Players {
  // Contains all the players in the game
  private ArrayList<Player> playerList;
  // The player that's currently their turn
  private Player currentPlayer;
  // The row amount the players want their board to be
  private int desiredRows;
  // The columns the players want their board to be
  private int desiredCols; 
  // The strike amount the number of symbols in a row for a winner
  private int strikeAmount;
  // Scanner object used to ask the users their desired size
  private Scanner inputReader;

  // Gets the rows the players want their board to be
  public int getDesiredRows(){
    return this.desiredRows;
  }

  // Gets the columns the players want their board to be
  public int getDesiredCols(){
    return this.desiredCols;
  }

  // Creates the players object
  public Players(){
    this.playerList = new ArrayList<Player>();
    this.currentPlayer = null;
    this.inputReader = new Scanner(System.in);
  }

  // Returns the player that can place an X as "player one"
  public Player getPlayerOne() {
    for (Player hi : playerList) {
      if (hi.isX()) {
        return hi;
      }
    }
    return null;
  }

  // Returns the play that can't place an X as "player two"
  public Player getPlayerTwo() {
    for (Player hi : this.playerList) {
      if (!hi.isX()) {
        return hi;
      }
    }
    return null;
  }

  // Gets the current player that their turn
  public Player getCurrentPlayer(){
    return this.currentPlayer;
  }

  // Sets the current player for another
  public void setCurrentPlayer(Player water){
    this.currentPlayer = water;
  }

  // Swaps the current player for the other player
  public void swapCurrentPlayer(){
    if(this.currentPlayer == this.getPlayerOne()){
      this.currentPlayer = this.getPlayerTwo();
    } else {
      this.currentPlayer= this.getPlayerOne();
    }
  }

  // Creates the first player by asking player one for input
  public void createPlayerOne(){
    Player PlayerOne = new Player();
    PlayerOne.askName(true);
    PlayerOne.setIsX(true);
    PlayerOne.setSymbol("❌");
    playerList.add(PlayerOne);
    this.currentPlayer = PlayerOne;
  }

  // Creates the second player by asking the player two for input
  public void createPlayerTwo(){
    Player PlayerTwo = new Player();
    PlayerTwo.askName(false);
    PlayerTwo.setIsX(false);
    PlayerTwo.setSymbol("⭕");
    playerList.add(PlayerTwo);
  }

  // Creates all the players in the game by asking for their names
  public void createAllPlayers(){
    this.createPlayerOne();
    this.createPlayerTwo();
  }

  //  Uses a while loop to get a number and a row that's within range
  public void askRows(){
    while(true){
      if(inputReader.hasNextInt()){
        this.desiredRows = inputReader.nextInt();
        if(this.desiredRows >= 3 && this.desiredRows <= 9 ){
          break;
        } else {
          System.out.println("Try another input");
        }
      } else {
        String invalidInput = inputReader.next();
        System.out.println("Try another input");
      }
    }
  }
  
  // Ask the user how many rows they want
  public void askPlayersSizeRows(){
    System.out.println("How many rows do you want? (min 3, max 9)");
    this.askRows();
  }

  // Uses a while loop to get a number and a column that's within range
  public void askForCols(){
    while(true){
      if(inputReader.hasNextInt()){
        this.desiredCols = inputReader.nextInt();
        if(this.desiredCols >= 3 && this.desiredCols <= 9 ){
          break;
        } else {
          System.out.println("Try another input");
        }
      } else {
        String invalidInput = inputReader.next();
        System.out.println("Try another input");
      }
    }
  }
  // Ask the user how many cols they want
  public void askPlayersSizeCols(){
    System.out.print("How many columns do you want? (min 3, max 9)");
    this.askForCols();
  }

  // Uses a while loop to a integer and a proper strike amount
  public void askStrike(){
        while(true){
      if(inputReader.hasNextInt()){
        this.strikeAmount = inputReader.nextInt();
        if(this.strikeAmount >= 3 && this.strikeAmount <= 9 && this.strikeAmount <= this.desiredRows && this.strikeAmount <= this.desiredCols ){
          break;
        } else {
          System.out.println("Try another input");
        }
      } else {
        String invalidInput = inputReader.next();
        System.out.println("Try another input");
      }
    }
  }
  
  // Ask the user for how many symbols in a row for a winner
  public void askStrikeAmount(){
    System.out.print("What's the strike amount you want?");
    this.askStrike();
  }
  // Ask the users for size of the board
  public void setupBoard(){
    this.askPlayersSizeRows();
    this.askPlayersSizeCols();
    this.askStrikeAmount();
  }

  // Gets the amount to of repeated symbols for a win
  public int getStrikeAmount(){
    return this.strikeAmount;
  }

  

  
  
  

}