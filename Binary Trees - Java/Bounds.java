//Written by bello067
import java.awt.*;

public class Bounds {

    // The extrema of our rectangle
    private Vec2 min;
    private Vec2 max;

    // Getters, no setters. Use extend instead.
    public Vec2 getMin(){ return min; }
    public Vec2 getMax(){ return max; }

    // Default min and max to null, so that they are
    // initialized on the first call to extend.
    public Bounds(){
        min = null;
        max = null;
    }

    // TODO
    // Check if a point is outside the bounds of the box
    // Ignore z axis for this function
    public boolean isOutside(double x, double y){
        if(min.x > x ||  x > max.x || min.y > y || y > max.y){
            return true;
        }
        return false;
    }

    // TODO
    // Extend the size of the box to include a new point
    public void extend(double x, double y){
        // If we haven't set min or max yet, do so now.
        if(min == null || max == null){
            min = new Vec2();
            max = new Vec2();
        }
        if(this.isOutside(x,y) == true){//if the point is outside the shape extend it to include the given point
            if(x > max.x){
                max.x = x;
            }
            if(x < min.x){
                min.x = x;
            }
            if( y > max.y){
                max.y =y;
            }
            if( y < min.y){
                min.y = y;
            }
        }

    }

    // TODO
    // Returns the distance from the box surface to a point
    // Return 0 if the point is inside the box!
    public double exteriorDistance(double x, double y){//uses distance formula
        double distance;
        if(min.x <= x && x <= max.x && min.y <= y && y <= max.y){//if it is on the edge it is considered in the box
            return 0;
        }else{//check which quadrant point it is in and find the distance from box using the distance formula
            if(y < min.y && x <= max.x && x >= min.x){
                double firstNum = x - x;
                double secondNum = y - min.y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else if(y > max.y && x <= max.x && x >= min.x){
                double firstNum = x - x;
                double secondNum = y - max.y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else if(x > max.x && y <= max.y && y >= min.y){
                double firstNum = x - max.x;
                double secondNum = y - y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else if(x < min.x && y <= max.y && y >= min.y){
                double firstNum = x - min.x;
                double secondNum = y - y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else if(y > max.y && x < min.x){
                double firstNum = x - min.x;
                double secondNum = y - max.y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else if(y > max.y && x > min.y){
                double firstNum = x - max.x;
                double secondNum = y - max.y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else if(y < min.y && x < min.x){
                double firstNum = x - min.x;
                double secondNum = y - min.y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }else{// y < min.y && x > max.x
                double firstNum = x - max.x;
                double secondNum = y - min.y;
                Math.abs(firstNum);
                Math.abs(secondNum);
                double newNumber = Math.pow(firstNum,2) + Math.pow(secondNum,2);
                Math.sqrt(newNumber);
                distance =  Math.sqrt(newNumber);
            }
        }
        return distance;
    }

    // TODO
    // Extend the size of the box to include a new bounds
    public void extend(Bounds b){
        if (min == null && max == null) {
            min = b.min;
            max = b.max;
        }
        if(this.isOutside(b.getMin().x,b.getMin().y) == true || this.isOutside(b.getMax().x,b.getMax().y) == true){
            if(min.x >= b.min.x){
                min.x = b.min.x ;
            }
            if(max.x <= b.max.x){
                max.x = b.max.x ;
            }
            if(min.y >= b.min.y){
                min.y = b.min.y ;
            }
            if(max.y <= b.max.y){
                max.y = b.max.y ;
            }
        }
    }

    // Draw a black opaque rectangle
    public void paint(Graphics2D g){
        g.setColor(Color.black);
        g.drawRect((int)min.x, (int)min.y, (int)(max.x-min.x), (int)(max.y-min.y));
    }

} // end class Bounds
