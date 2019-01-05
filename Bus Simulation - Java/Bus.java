//Written by bello067

import java.util.ArrayList;

public class Bus {

    public boolean clumped = false; //true once bus has waited after seeing a bus a stop or two ahead of it
    boolean isFull;

    private ArrayList<Passenger> busLoad;

    int arrivalTime =-8; //an impossible time that shows that the bus is going to be arriving to a new location
    int milesPerGallon;
    int occupancy;//max occupancy for bus
    int numel = 0;//number of passengers on the bus
    int totalNumOfPplThatGotOnBus;
    int timesLeft; //amount of times a bus has left a stop
    int PMPG = milesPerGallon * (totalNumOfPplThatGotOnBus/timesLeft);

    String bound;

    //constructor
    public Bus(String size, String bound){
        busLoad = new ArrayList<>();
        this.bound = bound;
        if(size.equals("small")){
            occupancy = 40;
            milesPerGallon = 6;
        }
        if(size.equals("large")){
            occupancy = 60;
            milesPerGallon =4;
        }
        BusSim.numBus+=1;
    }

    public void setMilesPerGallon(int i){//adds PMPG to bus sim class
        BusSim.passMilesPerGallon[i] = PMPG;
    }

    public boolean addPassengers(Passenger p){//add passengers to bus
        if(isFull == false){
            busLoad.add(p);
            numel +=1;
            return true;
        }
        return false;
    }

    public Passenger[] dropOffs(String currentStop){//removes passengers from bus that need to get off
        int count = 0;
        Passenger[] dropOffs = new Passenger[60];
        for(int i =0;i <numel;i++){
            if(busLoad.get(i).destination.equals(currentStop)){
                dropOffs[count] = busLoad.get(i);//i is pointing to the right spot in the list but not the arrayList
                count+=1;
                busLoad.remove(i);
                numel-=1;
                i--;
            }
        }
        return dropOffs;
    }

    public void isFull(){//checks if bus is full
        if(numel == occupancy){
            isFull = true;
        }else{
            isFull = false;
        }
    }

    public void setBound(String bound){
        this.bound = bound;
    }

    public void setArrivalTime(int time){
        this.arrivalTime = time;
    }
}
