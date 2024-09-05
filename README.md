! IMPORTANT !
I built most of the game in this link because the link for project submission was posted late
https://replit.com/join/loiafgfqoh-isaacestrella

HI! 
This is a tic tac toe project that I built and finish 5/25/2023 and here's how it works 

Board Class:
The board class is used to create a 2d array that represents the board. The board class allows the program to place a coin. The class includes error handling by preventing the user to place a coin in a slot that doesn't exist or a slot that already full. The class has many methods to display the board. There's the displayRows() method that prints out the rows that help the row visually see each row. There's the diplayColumns() method that allows the user to visually see each column. Also, I have the method isFull() to determine if the board is full. The isFull() method helps me determine if there's a tie. 

Player Class:
The player class is a class I created in order to store data on the user. I store the player's name, symbol, and the row and column they want to place.

Players Class:
The players class is used to create all the players. I create player one by asking a user for their name. I then set their symbol to "X".
I create player two by asking a user for their name and I set their symbol to "O". I have other methods to help run the game. For example, I have the getCurrentPlayer() method that returns the current player. I have the swapPlayers() which changes the current player. Finally, I have getPlayerOne() and getPlayerTwo()

SearchAlg Class:
I created the SearchAlg class in order to determine a tic tac toe. I have the vertical method which checks if there's a tic tac toe vertically. I have the horizontal method that checks if there's a winner horizontally. I then have various method to help me determine if there's a winner diagonally. For the diagonal methods, I used helper methods to determien the strike of same symbols. I then check if the streak is greater than or equal the required strike amount. If the statement is true, then there's a winner. 