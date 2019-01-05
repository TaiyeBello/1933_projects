//Written by bello067
public class Battleboat {

    private int size = 3;
    private boolean orientation; // false <-> horizontal, true <-> vertical
    private Cell[] spaces;
    private char status;


    public Battleboat(){ //constructor for boat
        spaces = new Cell[size];
        if(Math.random() < 0.5 ){ //randomly makes boat horizontal or vertical
            orientation = true;
            for(int i =0; i < size;i++){
                spaces[i] = new Cell(0,i,'B'); //makes boat vertical
            }
        }
        else{
            orientation = false;
            for(int i =0; i < size;i++){
                spaces[i] = new Cell(i,0,'B'); // makes boat horizontal
            }
        }
    }

    public boolean get_orientation(){ //returns orientation of boat
        return orientation;
    }

    public int get_size(){ //returns size of the boat
        return size;
    }

    public Cell[] get_spaces(){ //returns spaces that make up boat
       return spaces;
    }

    public char get_status(){ //returns status of boat
        return status;
    }

    public void set_spaces(int i, int row, int col,char c){ //sets spaces of boat
        spaces[i] = new Cell(row, col, c);
    }

}
