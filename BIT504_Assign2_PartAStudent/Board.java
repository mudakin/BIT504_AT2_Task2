import java.awt.*;

public class Board {
	// grid line width
	public static final int GRID_WIDTH = 8;
	// grid line half width
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;
	
	//2D array of ROWS-by-COLS Cell instances
	Cell [][] cells;
	
	/** Constructor to create the game board */
	public Board() {
		
	 //TODO: initialise the cells array using ROWS and COLS constants 

		cells = new Cell[GameMain.ROWS][GameMain.COLS]; // Initialize the cells array
		for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				cells[row][col] = new Cell(row, col);// Create new Cell objects
				
		/**
		 * This code sets up the game board by creating a grid of cells. It first initializes the cells array, which 
		 * 2D array of Cell objects. It iterates over each row and column of the array and creates a new Cell 
		 * object at each position, passing the row and column indices to the Cell constructor. This effectively 
		 * creates a grid of cells for the Tic Tac Toe game, where each cell is represented by a Cell object.
		  */
			}
		}
	}
	

	 /** Return true if it is a draw (i.e., no more EMPTY cells) */ 
	public boolean isDraw() {
		 
		// TODO: Check whether the game has ended in a draw. 
		// Hint: Use a nested loop (see the constructor for an example). Check whether any of the cells content in the board grid are Player.Empty. If they are, it is not a draw.
		// Hint: Return false if it is not a draw, return true if there are no empty positions left
		 
		for (int row = 0; row < GameMain.ROWS; ++row) {
            for (int col = 0; col < GameMain.COLS; ++col) {
                if (cells[row][col].content == Player.Empty) {
                    return false; // If any cell is empty, it's not a draw
                    
                    /**
                     *  This loop was used to iterate through each cell in the game board and check if it's empty
                     *  which is need to see if the game has ended in a draw by checking whether there are
                     *  any more empty cells or not. if none then the game is a draw.
                     * 
                     * */
                    
                }
                
            }
                    
         }
		 return true; // All cells are occupied, it's a draw
		 
	}
	
	
	
	/** Return true if the current player "thePlayer" has won after making their move  */
	public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
		 // check if player has 3-in-that-row
		if(cells[playerRow][0].content == thePlayer && cells[playerRow][1].content == thePlayer && cells[playerRow][2].content == thePlayer )
			return true; 
		
		/**
		 * This part of the code checks if a player has won by having three consecutive symbols in a row.
		 * If the symbols of the specified player (thePlayer) are the same in the cells of the same row (playerRow) and
		 * consecutive columns (0, 1, 2), it means that player has won. This condition checks for a win condition horizontally.
		 * If this condition is met, the method returns true, indicating that the player has won. 
		 */
		
		 // TODO: Check if the player has 3 in the playerCol.
		 // Hint: Use the row code above as a starting point, remember that it goes cells[row][column] 
		if (cells[0][playerCol].content == thePlayer && cells[1][playerCol].content == thePlayer && cells[2][playerCol].content == thePlayer)
			return true;
		
		/**Similar to the above comment this does the same but checks if the player symbols 
		 * are in the same cells of the same column*/
		
		
		 // 3-in-the-diagonal
		if( cells[0][0].content == thePlayer && cells[1][1].content == thePlayer && cells[2][2].content == thePlayer)
			return true;
		 
		
		// TODO: Check the diagonal in the other direction
		if (cells[0][2].content == thePlayer && cells[1][1].content == thePlayer && cells[2][0].content == thePlayer)
            return true;
		
		/**Similar to the above comment this does the same but checks if the player symbols 
		 * are in the same cells at position (0, 2), (1, 1), and (2, 0)  which is diagonally from the top right to the bottom left */
		
		

		
		//no winner, keep playing
		return false;
	}
	
	/**
	 * Draws the grid (rows then columns) using constant sizes, then call on the
	 * Cells to paint themselves into the grid
	 */
	public void paint(Graphics g) {
		//draw the grid
		g.setColor(Color.gray);
		for (int row = 1; row < GameMain.ROWS; ++row) {          
			g.fillRoundRect(0, GameMain.CELL_SIZE * row - GRID_WIDHT_HALF,                
					GameMain.CANVAS_WIDTH - 1, GRID_WIDTH,                
					GRID_WIDTH, GRID_WIDTH);       
			}
		for (int col = 1; col < GameMain.COLS; ++col) {          
			g.fillRoundRect(GameMain.CELL_SIZE * col - GRID_WIDHT_HALF, 0,                
					GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,                
					GRID_WIDTH, GRID_WIDTH);
		}
		
		//Draw the cells
		for (int row = 0; row < GameMain.ROWS; ++row) {          
			for (int col = 0; col < GameMain.COLS; ++col) {  
				cells[row][col].paint(g);
			}
		}
	}
	

}
