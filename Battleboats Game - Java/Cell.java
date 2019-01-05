//Written by bello067
public class Cell {

    private int row;
    private int col;
    private char status; // ' ': Empty, 'B': Boat, 'H': Hit; 'M': Miss


    public char get_status(){
        return status;
    } //returns cell status

    public void set_status(char c){
        status = c;
    } //sets status of cell

    public Cell(int row, int col, char status){ //constructor for cell
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public int get_R(){ //returns row
        return row;
    }

    public int get_C(){ //returns column
        return col;
    }

}
