//Written by bello067

public class Stop {

    Q2 east;
    Q2 west;

    String stop;

    int location;
    int isHereEast = 0; //number of buses at stop going east
    int isHereWest = 0; //number of buses at stop going west
    int summationOfQLength; //every time passenger is added or removed the queue length at that time is added to this variable
    int divisor; //increments by one every time passenger is added or removed from a queue at a stop

    public Stop(String stop, int location){
        if(location == 0){//first stop can only go west
            west = new Q2();
        }else if(location == 9){//last stop can only go east
            east = new Q2();
        }else{
            east = new Q2();
            west = new Q2();
        }
        this.stop = stop;
        this.location = location;
    }

    public void addPassenger(Passenger p){
        if(p.direction.equals("east")){
            east.add(p);
        }else{
            west.add(p);
        }
    }

    public void totalWaitTime() {//adds wait time of passengers that didn't get on a bus and are still in line
        for (int i = 0; i < east.length(); i++) {
            Passenger p1 = (Passenger) east.remove();
            BusSim.totalWaitTime += BusSim.agenda.getCurrentTime() - p1.arrivalTime;
        }
        for(int i =0; i < west.length();i++ ){
            Passenger p2 = (Passenger) west.remove();
            BusSim.totalWaitTime += BusSim.agenda.getCurrentTime() - p2.arrivalTime;
        }
    }
    public String getStop(){
        return stop;
    }

    public int getLocation(){
        return location;
    }

    public int getIsHereEast(){
        return isHereEast;
    }

    public int getIsHereWest(){
        return isHereWest;
    }

    public void setIsHereEast(){
        isHereEast +=1;
    }

    public void setIsHereWest(){
        isHereWest +=1;
    }


}
