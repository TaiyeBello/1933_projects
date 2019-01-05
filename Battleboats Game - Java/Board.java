//Written by bello067
public class Board {

    private int num_rows;
    private int num_columns;
    private int num_boats;
    private Battleboat[] boats;
    private Cell[][] board;
    private boolean debugMode;


    public Board(int m, int n, boolean debugMode) { //constructor for board
        num_rows = m;
        num_columns = n;
        boatCount(); // sets the num_boats variable to appropriate number based on size of board

        //initializes the board
        board = new Cell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new Cell(i, j, ' ');
            }
        }
        //initializes the boats
        boats = new Battleboat[num_boats];
        for (int i = 0; i < num_boats; i++) {
            boats[i] = new Battleboat();

        }
        this.debugMode = debugMode;
        placeBoats();

    }


    public void placeBoats() { //places boats on board
        boolean boatplaced = false;
        double x;
        double y;
        int a;
        int b;
        for (int i = 0; i < num_boats; i++) { //for each boat
            boatplaced = false;
            while (boatplaced == false) {//while the boat has not been placed
                //randomly generates a point within range of board
                x = (Math.random() * num_rows) / 1;
                a = (int) x;
                y = (Math.random() * num_columns) / 1;
                b = (int) y;
                if (board[a][b].get_status() == (' ')) {//if status of randomly generated point is empty
                    if (boats[i].get_orientation() == true) {//if boat is vertical
                        //if the cell above the randomly generated point is in range of the board and it is empty
                        if (((0 <= (b + 1) && (b + 1) <= (num_rows - 1))) && ((0 <= (b + 1) && (b + 1) <= (num_columns - 1)))
                                && (board[a][b + 1].get_status() == (' '))) {
                            //if the cell above the previous cell is in range and empty
                            if (((0 <= (b + 2) && (b + 2) <= (num_rows - 1))) && ((0 <= (b + 2) && (b + 2) <= (num_columns - 1)))
                                    && (board[a][b + 2]).get_status() == (' ')) {
                                //place boat on board and set the status of boards cell to B(boat) and the status of the boats cell to B(boat)
                                board[a][b].set_status('B');
                                board[a][b + 1].set_status('B');
                                board[a][b + 2].set_status('B');
                                boats[i].set_spaces(0, a, b,'B');
                                boats[i].set_spaces(1, a, (b + 1),'B');
                                boats[i].set_spaces(2, a, (b + 2),'B');
                                boatplaced = true;//breaks while loop
                            //if the cell above the previous cell is not in range and not empty
                            } else {
                                //if cell below randomly generated point is in range of the board and empty
                                if (((0 <= (b - 1) && (b - 1) <= (num_rows - 1))) && ((0 <= (b - 1) && (b - 1) <= (num_columns - 1))) && (board[a][b - 1].get_status() == (' '))) {
                                    //place boat on board and set the status of boards cell to B(boat) and the status of the boats cell to B(boat)
                                    board[a][b].set_status('B');
                                    board[a][b + 1].set_status('B');
                                    board[a][b - 1].set_status('B');
                                    boats[i].set_spaces(0, a, b,'B');
                                    boats[i].set_spaces(1, a, (b + 1),'B');
                                    boats[i].set_spaces(2, a, (b - 1),'B');
                                    boatplaced = true;//breaks while loop
                                }
                            }
                        //if both cells above randomly generated point is out of range and not empty
                        } else {
                            //if two cells below randomly generated point is in range and empty
                            if (((0 <= (b - 1) && (b - 1) <= (num_rows - 1))) && ((0 <= (b - 1) && (b - 1) <= (num_columns - 1))) && (board[a][b - 1].get_status() == (' '))) { //&& (board[a][b+2]).get_status() == (' ')){z
                                if (((0 <= (b - 2) && (b - 2) <= (num_rows - 1))) && ((0 <= (b - 2) && (b - 2) <= (num_columns - 1))) && ((board[a][b - 2]).get_status() == (' '))) {
                                    //place boat on board and set the status of boards cell to B(boat) and the status of the boats cell to B(boat)
                                    board[a][b].set_status('B');
                                    board[a][b - 1].set_status('B');
                                    board[a][b - 2].set_status('B');
                                    boats[i].set_spaces(0, a, b,'B');
                                    boats[i].set_spaces(1, a, (b - 1),'B');
                                    boats[i].set_spaces(2, a, (b - 2),'B');
                                    boatplaced = true;//breaks while loop

                                }

                            }
                        }
                    }
                    if (boats[i].get_orientation() == false) {//if boat is horizontal
                        //if the cell to the right of the randomly point is in range of the board and it is empty
                        if (((0 <= (a + 1) && (a + 1) <= (num_rows - 1))) && ((0 <= (a + 1) && (a + 1) <= (num_columns - 1)))
                                && (board[a + 1][b].get_status() == (' '))) {
                            //if the cell to the right of the previous cell is in range of the board and it is empty
                            if (((0 <= (a + 2) && (a + 2) <= (num_rows - 1))) && ((0 <= (a + 2) && (a + 2) <= (num_columns - 1)))
                                    && ((board[a + 2][b]).get_status() == (' '))) {
                                //place boat on board and set the status of boards cell to B(boat) and the status of the boats cell to B(boat)
                                board[a][b].set_status('B');
                                board[a + 1][b].set_status('B');
                                board[a + 2][b].set_status('B');
                                boats[i].set_spaces(0, a, b,'B');
                                boats[i].set_spaces(1, (a + 1), b,'B');
                                boats[i].set_spaces(2, (a + 2), b,'B');
                                boatplaced = true;//breaks while loop
                            //if cell to the right of the previous cell is not in range and not empty
                            } else {
                                //if cell to the left of randomly generated point is in range and empty
                                if (((0 <= (a - 1) && (a - 1) <= (num_rows - 1))) && ((0 <= (a - 1) && (a - 1) <= (num_columns - 1)))
                                        && (board[a - 1][b].get_status() == (' '))) {
                                    //place boat on board and set the status of boards cell to B(boat) and the status of the boats cell to B(boat)
                                    board[a][b].set_status('B');
                                    board[a + 1][b].set_status('B');
                                    board[a - 1][b].set_status('B');
                                    boats[i].set_spaces(0, a, b,'B');
                                    boats[i].set_spaces(1, (a + 1), b,'B');
                                    boats[i].set_spaces(2, (a - 1), b,'B');
                                    boatplaced = true;//breaks while loop
                                }
                            }
                        //if two cells to the right of randomly generated point are not in range and not empty
                        } else {
                            //if two cells to the left of randomly generated point are in range and empty
                            if (((0 <= (a - 1) && (a - 1) <= (num_rows - 1))) && ((0 <= (a - 1) && (a - 1) <= (num_columns - 1)))
                                    && (board[a - 1][b].get_status() == (' '))) {
                                if (((0 <= (a - 2) && (a - 2) <= (num_rows - 1))) && ((0 <= (a - 2) && (a - 2) <= (num_columns - 1)))
                                        && ((board[a - 2][b]).get_status() == (' '))) {
                                    //place boat on board and set the status of boards cell to B(boat) and the status of the boats cell to B(boat)
                                    board[a][b].set_status('B');
                                    board[a - 1][b].set_status('B');
                                    board[a - 2][b].set_status('B');
                                    boats[i].set_spaces(0, a, b,'B');
                                    boats[i].set_spaces(1, (a - 1), b,'B');
                                    boats[i].set_spaces(2, (a - 2), b,'B');
                                    boatplaced = true;//breaks while loop

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void boatCount(){ //counts the number of boats that will be placed on board based of the size of the board
        if ((num_rows == 3) && (num_columns == 3)) {
            num_boats = 1;
        }
        if ((3 < num_rows && num_rows <= 5) || (3 < num_columns && num_columns <= 5)) {
            num_boats = 2;
        }
        if ((5 < num_rows && num_rows <= 7) || (5 < num_columns && num_columns <= 7)) {
            num_boats = 3;
        }
        if ((7 < num_rows && num_rows <= 9) || (7 < num_columns && num_columns <= 9)) {
            num_boats = 4;
        }
        if ((9 < num_rows && num_rows <= 12) || (9 < num_columns && num_columns <= 12)) {
            num_boats = 6;
        }
    }

    //Obscures a character if the game is not being played in debug mode
    private char debug ( boolean debugMode, char c){
        if (debugMode) {
            return c;
        } else {
            switch (c) {
                case 'H':
                    c = 'H';
                    break;
                case 'M':
                    c = 'M';
                    break;
                default:
                    c = ' ';
                    break;
            }
            return c;
        }
    }

    //Prints a Board object in a way that makes sense to the player
    public String toString () {

        String boardString = "\t";
        for (int j = 0; j < num_columns - 1; j++) {
            boardString += j + " |" + "\t";
        }

        boardString += num_columns - 1;

        for (int i = 0; i < num_rows; i++) {
            boardString += "\n" + i + "\t";
            for (int j = 0; j < num_columns; j++) {
                boardString += debug(debugMode, board[i][j].get_status()) + "\t";
            }
        }

        boardString += "\n";
        return boardString;
    }

    public int guess ( int r, int c){ //returns an int based on the guess for the cell/its status, also changes statuses of the cell if need be
        if (((0 > r || r >= (num_rows))) || ((0 > c || c >= (num_columns)))) { //if guess is out of bounds
            return 0;
            //"Penalty: Out of Bounds";
        } else if (board[r][c].get_status() == (' ')) { //if player guessed a spot that was empty
            board[r][c].set_status('M'); //change status of board to miss
            return 1;
            //"Miss";
        } else if (board[r][c].get_status() == ('B')) { //if player guessed a spot that had a boat
            setBoat(r,c); //change status of boat to hit
            board[r][c].set_status('H'); //change status of board to hit
            return 2;
            //"Hit";
        } else {
            return 3;
            //"Penalty: Redundant Guess";
        }
    }

    public void setBoat(int r, int c){ //changes status of boat cells, helper function for guess
        Cell [] spaces;
        for(int i =0;i<num_boats;i++){
            spaces = boats[i].get_spaces();
            for(int j =0;j<spaces.length;j++){
                //if boats cell is equal to board's cell
                if((spaces[j].get_R() == board[r][c].get_R()) && (spaces[j].get_C() == board[r][c].get_C())){
                    boats[i].set_spaces(j,r,c,'H'); //set the space of the boat to hit
                }
            }
        }
    }

    public int unsunkBoats () { //function that calculates the number of boats that have not sunk
        int count = 0;
        boolean sunk;
        for(int i = 0; i < num_boats; i++){
            Cell[] spaces = boats[i].get_spaces();
            sunk = true;
            for (int j = 0; j < spaces.length; j++) {
                if (spaces[j].get_status() != 'H') { //if the cell of the boat is not hit
                    sunk = false;
                }
            }if(sunk == false) {
                count++;
            }
        }
        return count;
    }
}
