//Written by bello067

public class Passenger {

    int arrivalTime;
    int timeGotOn = 0;//time passenger got on a bus
    int maxWaitTime = 0; //longest time passenger had to wait at a bus stop

    String destination;
    String direction;

    //constructor
    public Passenger(int t, String stop, String bound){
        int arrivalTime = t;
        String destination = stop;
        String direction = bound;

    }

    public void setMaxWaitTime(int t){
        if(t > maxWaitTime){
            maxWaitTime = t;
        }
    }

    public void setTimeGotOn(int t){
        timeGotOn = t;
    }


}
