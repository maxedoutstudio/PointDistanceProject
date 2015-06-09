// ------------------------------------------------------------ 
 // Assignment # 3
 // File name: assignment3_7391587
 // Written by: Maksym Perepichka ID# 7391587
 // For Comp 248 Section EE /Fall 2014 
 // ------------------------------------------------------------ 

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class OgnibGame {
	
	//Since these are constants, no point in making them private
	public final int ROWS = 5;
    public final int COLUMNS = 5;
    public final int LENGTH = ROWS*COLUMNS;
    public final int MIN_VALUE = 1; // represents the minimum value in the board
    public final int MAX_VALUE = 100; // represents the maximun value in the board
 
    
    private int[] playerBoard = new int[LENGTH]; // represents the player's board as a 1-D array
    private int[] computerBoard = new int[LENGTH]; // represents the player's board as a 1-D array
    
    private final int computerAdvantage = 3; //Controls how many turns the computer gets for each turn the player gets. Defaults at 3.
    private boolean gameOngoing = false;
    
    private String playerName = "Daniel";
    
    private Scanner keyboard  = new Scanner(System.in);
    
    public OgnibGame(){
    	playerBoard = generateBoard(playerBoard);
    	computerBoard = generateBoard(computerBoard);
    }
    
    //For printing the board in one line
    public void printBoardSimple(){	
    	for (int c : playerBoard) {
    	    System.out.print(c + " ");
    	}
    }
    
    //The method that starts the game
    public void startGame(){
    	System.out.println("Welcome to the game of Ognib. Let's play!");
    	gameOngoing = true;
    	do{	
    		printBoardComplex(playerBoard);
    		//Computer's turn
    		compTurn();
    		
    		//Graphs the computer's board for debugging. Leave commented out
    		//printBoardComplex(computerBoard);
    		
    		//Just to make sure that the game ends after someone has won/tied.
    		if(!gameOngoing)
    			break;
    		
    		//Player's turn
    		playerTurn();
    		
    	}while(gameOngoing);
    }
    
    //The computer's turn
    private void compTurn(){
    	int counter = 0;
    	do{
        	boolean generating = true;
    		int chosenToken = -1; //Start it at -1 just in case errors (since we are using 0 to signify flipped token)
    		
    		//Generates a random token for the comp to choose and replaces it with a zero
	    	while(generating){
	    		int randomint = new Random().nextInt(computerBoard.length);
	    		if(computerBoard[randomint] != 0){
	    			chosenToken = computerBoard[randomint];
	    			computerBoard[randomint] = 0;
	    			generating = false;
	    		}
	    	}
	    	
	    	//Tells the player what number the computer chose
	    	System.out.println("Computer's value: " + chosenToken);
	    	
	    	//Flips the token for the player's board
	    	
	    	for(int i = 0;i<playerBoard.length;i++){
	    		if(playerBoard[i] == chosenToken ){
	    			playerBoard[i] = 0;
	    		}
	    	}
	    	
	    	counter++;
	    	isWinner();
    	}while((counter<computerAdvantage) && gameOngoing);
    }
    
    
    //The player's turn
    private void playerTurn(){
    	boolean playerTurnActive = true;
    	do{
	    	System.out.print(playerName + "'s value: ");
	    	int playerChosenToken = keyboard.nextInt();
	    	
	    	
	    	//I do some checks here so player can't mess up a game or accidentally skip a turn by entering token value of 0
	    	
	    	if(playerChosenToken > 0 && playerChosenToken <= 100 && tokenChecker(playerChosenToken,playerBoard)){
	    		//Flips the token for the player
	    		for(int i = 0;i<LENGTH;i++){
	    			if(playerChosenToken == playerBoard[i]){
	    				playerBoard[i] = 0;
	    			}
	    		}
	    		//Flips the token for the Computer
	    		for(int i = 0;i<LENGTH;i++){
	    			if(playerChosenToken == computerBoard[i]){
	    				computerBoard[i] = 0;
	    			}
	    		}
	    		playerTurnActive = false;
	    	} else {
	    		System.out.println("ERROR: Please enter a token value between 1-100 that is found on your board! ");
	    	}
	    	
    	} while (playerTurnActive);
    	
    	isWinner();
    	
    }
    
    //Checks if token is on the board
    
    private boolean tokenChecker(int token,int[] board){
    	for(int i = 0;i< LENGTH;i++){
    		if(board[i] == token){
    			return true;
    		}
    	}
    	return false;
    }
    
    
    //Checks if there is a winner at the end of a turn
    private void isWinner(){
    	
    	boolean compWin = false;
    	boolean playerWin = false;
    	
    	if(rowCheck(playerBoard)){
    		playerWin = true;
    		System.out.println("Player row win detected");
    	}
    	else if(columnCheck(playerBoard)){
    		playerWin = true;
    		System.out.println("Player column win detected");
    	}
    	else if(diagonalCheck(playerBoard)){
    		playerWin = true;
    		System.out.println("Player diagonal win detected");
    	}
    	
    	if(rowCheck(computerBoard)){
    		compWin = true;
    		System.out.println("Computer row win detected");
    	}
    	else if(columnCheck(computerBoard)){
    		compWin = true;
    		System.out.println("Computer column win detected");
    	}
    	else if(diagonalCheck(computerBoard)){
    		compWin = true;
    		System.out.println("Computer diagonal win detected");
    	}
    	
    	if(compWin && playerWin){
    		gameOngoing = false;
    		System.out.println("Tie detected");
    		System.out.println("Final results:");
    		printBoardComplex(playerBoard);
    		System.out.println(playerName + " has a winning card");
    		printBoardComplex(computerBoard);
    		System.out.println("Computer has a winning card");
    	}
    	else if(compWin){
    		gameOngoing = false;
    		System.out.println("Final results:");
    		printBoardComplex(playerBoard);
    		printBoardComplex(computerBoard);
    		System.out.println("Computer has a winning card");
    	}
    	else if(playerWin){
    		gameOngoing = false;
    		System.out.println("Final results:");
    		printBoardComplex(playerBoard);
    		System.out.println(playerName + " has a winning card");
    		printBoardComplex(computerBoard);
    	}
    	
    	
    	
    }
    
    //I separated the different win checks to shorten the code
    
    private boolean rowCheck(int[] board){
    	for(int r = 0;r < ROWS;r++){
    		int startingIndex = (r*ROWS);
    		int counter = 0;
    		int zeroCounter = 0; //Counts the amount of zeroes in the row. If its equal to COLUMNS - 1, detects the win.
    		while(counter < COLUMNS){
        		if(board[startingIndex + counter] == 0){
        			zeroCounter++;
        		}
        		counter++;
    		}
    		if(zeroCounter == COLUMNS)
    			return true;
    	}
    	
    	return false;
    }
    
    private boolean columnCheck(int[] board){
    	for(int c = 0;c < COLUMNS;c++){
    		int counter = 0;
    		int zeroCounter = 0; //Counts the amount of zeroes in the row. If its equal to COLUMNS - 1, detects the win.
    		while(counter < ROWS){
        		if(board[((counter*ROWS) + c)] == 0){
        			zeroCounter++;
        		}
        		counter++; //Since the next value in the same column is 5 indexes away
    		}
    		if(zeroCounter == ROWS)
    			return true;
    	}
    	
    	return false;
    }
    
    private boolean diagonalCheck(int[] board){
    	int zeroCounter = 0;
    	
    	//Checks left-to-right diagonal
    	for(int d = 0;d<ROWS;d++){
    		if(board[(d*ROWS + d)] == 0){
    			zeroCounter++;
    		}
    	}
    	
    	if(zeroCounter == COLUMNS){
    		return true;
    	} else {
    		zeroCounter = 0;
    	}
    		
    	//Checks right-to-left diagonal
    	for(int d = 1;d<=ROWS;d++){
    		if(board[((ROWS-1)*d)] == 0){
    			zeroCounter++;
    		}
    	}
    	
    	if(zeroCounter == COLUMNS){
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
  //For printing the board as it should look like in a real game
    private void printBoardComplex(int[] board){
    	if(Arrays.equals(board,playerBoard)){
    		System.out.println("Player name: " + playerName);
    	}
    	else if(Arrays.equals(board,computerBoard)){
    		System.out.println("Player name: Computer");
    	}
    	System.out.println("=================================================================================");
    	int arrayIndex = 0; //Used to make things simpler for printing
    	for (int r = 0;r<ROWS;r++){
			System.out.print("|");
    		for (int c = 0;c<COLUMNS;c++){
    			System.out.print("	" + String.format("%1$3s", board[arrayIndex]) + "	|");
    			arrayIndex++;
    		}
    		System.out.println();
    	}
    	System.out.println("=================================================================================");
    }
    
	//For generating the board.  
	private int[] generateBoard(int[] board){
		//Generation code taken from SampleBoardInitialisation.java
		
		Random rand = new Random();
		int randomNumber;    // an integer to be chosen at random
		boolean isDuplicate; // to indicate is randomNumber has already been picked or not
		
		// for every cell i in the board
		for (int i = 0; i < board.length; ++i){
	        do
	        {     // Generate a random number between MAX_VALUE and MIN_VALUE inclusive
	              randomNumber = rand.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
	
	              isDuplicate = false; // initially, let's assume this is not a duplicate
	
	              // check if this random value has already been inserted in the array in a previous cell
	              for (int j = 0; j < i; ++j) {
	                    if (board[j] == randomNumber) {
	                          isDuplicate = true;
	                    }
	              }
	        } while (isDuplicate); // pick a new random number until we pick a non-duplicate
	        
	        board[i] = randomNumber;  // this random number is not a duplicate, assign it to the ith cell
		}
		
		//This part sorts the board using bubble sort
		
		int counter = board.length;
		boolean swapped = false;
	
		do{
			swapped = false;
			for(int i = 1;i <= counter-1;i++){
				if (board[i-1] > board[i]){
					int temp = board[i];
					board[i] = board[i-1];
					board[i-1] = temp;
					swapped = true;
				}
			}
			counter -=1;
		} while(swapped);
		
		//Returns the final generated and sorted board for further use
		return board;		 
	 }
	
}
