//Written by bello067

public class BusEvent implements Event {

    private Stop currentStop;
    private Bus bus;
    int nextStopLocation = 0;

    public BusEvent(Stop currentStop, Bus bus) {
        this.currentStop = currentStop;
        this.bus = bus;
    }

    public void maxWaitTime(Passenger p){//longest any passenger had to wait at a bus stop
        int waitTime = (int) BusSim.agenda.getCurrentTime() - p.arrivalTime;
        if(BusSim.maxWaitTime < waitTime){
            BusSim.maxWaitTime = waitTime;
        }
    }

    public void avgWaitTime(Passenger p){//function will be called every time a passenger is added
        //sets max wait time for each passenger
        //adds to total wait time for passengers that got on a bus
        int waitTime = (int) BusSim.agenda.getCurrentTime() - p.arrivalTime;
        BusSim.totalWaitTime += waitTime;
        p.setMaxWaitTime(waitTime);
    }

    public int findDirection() {//changes bound of bus depending on what stop it is at and gets next stop location based on what stop it is currently at

        if (currentStop.getLocation() == 0) {
            bus.setBound("east");
            nextStopLocation = currentStop.getLocation() + 1;

        } else if (1 <= currentStop.getLocation() || currentStop.getLocation() <= 8) {
            if (bus.bound.equals("west")) {
                nextStopLocation = currentStop.getLocation() - 1;
            } else {
                nextStopLocation = currentStop.getLocation() + 1;
            }
        } else {
            bus.setBound("west");
            nextStopLocation = currentStop.getLocation() - 1;
        }
        return nextStopLocation;
    }
    //checks to see if buses are clumping together and if they are it slows them down
    public boolean checkForClumping(){
        boolean stay = false;//bus should go to next stop
        if(BusSim.numBus < 9){
            //check if clumping is happening
            if(bus.bound.equals("east")){//if it is going east only look two stops ahead for stops 0 through 7
                if(0 <= this.findDirection() || this.findDirection() <= 7){
                    //check if there is bus at +2 stops ahead
                    if(BusSim.stops[findDirection()+1].getIsHereEast() > 0 ||
                            BusSim.stops[findDirection()+2].getIsHereEast() > 0){//if there is more than zero buses at the next stop wait at current stop
                        stay = true;
                    }
                }else if(this.findDirection() == 8){
                    if(BusSim.stops[9].getIsHereEast() > 0 ||
                            BusSim.stops[8].getIsHereWest() > 0){
                        stay = true;
                    }
                }else{
                    if(BusSim.stops[findDirection()-1].getIsHereWest() > 0 ||
                            BusSim.stops[findDirection()-2].getIsHereWest() > 0){
                        stay = true;
                    }
                }
            }else{//if it is going west only look two stops ahead for stops 2 through 9
                if(2 <= this.findDirection() || this.findDirection() <= 9){
                    //check if there is a bus at -2 stops ahead
                    if(BusSim.stops[findDirection()-1].getIsHereWest() > 0 ||
                            BusSim.stops[this.findDirection()-2].getIsHereWest() > 0){//if there is more than zero buses at the next stop wait at current stop
                        stay = true;
                    }else if(this.findDirection() == 1){
                        if(BusSim.stops[0].getIsHereWest() > 0 ||
                                BusSim.stops[1].getIsHereEast() > 0){
                            stay = true;
                        }
                    }else{
                        if(BusSim.stops[1].getIsHereEast() > 0 ||
                                BusSim.stops[2].getIsHereEast() > 0){
                            stay = true;
                        }
                    }
                }
            }
        }
        return stay;
    }

    public void run() {
        //number of people that want to be dropped off
        int numP = 0;

        Passenger[] dropoffs = bus.dropOffs(currentStop.getStop());
        for (int i = 0; i < 60; i++) {
            if (dropoffs[i] != null) {
                numP += 1;
                BusSim.totalTravelTime += BusSim.agenda.getCurrentTime() - dropoffs[i].timeGotOn;//add to total travel time of passengers getting of the bus

            }
        }
        //sets bus arrival time to the time at which dropoffs get of the bus
        //the arrival time is used to check how long people have been waiting after dropoffs have gotten off the bus
        if (bus.arrivalTime < 0) {
            if (numP != 0) {
                bus.setArrivalTime((int) BusSim.agenda.getCurrentTime() + (numP * 2));
            } else {
                bus.setArrivalTime((int) BusSim.agenda.getCurrentTime());
            }
        }

        int countOn = 0;//time it took passengers to get on the bus

        if (numP == 0) {
            if (bus.bound.equals("east")) {
                bus.isFull();
                while (bus.isFull == false && currentStop.east.length() != 0) {//keeps loading passengers until bus is full
                    Passenger p = (Passenger) currentStop.east.remove();
                    bus.addPassengers(p);

                    bus.totalNumOfPplThatGotOnBus +=1;
                    BusSim.totalNumOfPassTraveled +=1;
                    currentStop.divisor +=1;
                    currentStop.summationOfQLength += currentStop.east.length();

                    p.setTimeGotOn((int) BusSim.agenda.getCurrentTime());
                    this.maxWaitTime(p);
                    this.avgWaitTime(p);
                    countOn += 3;
                }
            } else {
                bus.isFull();
                while (bus.isFull == false && currentStop.west.length() != 0) {//keeps loading passengers until bus is full
                    Passenger p = (Passenger) currentStop.west.remove();
                    bus.addPassengers(p);

                    bus.totalNumOfPplThatGotOnBus +=1;
                    BusSim.totalNumOfPassTraveled +=1;
                    currentStop.divisor +=1;
                    currentStop.summationOfQLength += currentStop.west.length();

                    p.setTimeGotOn((int) BusSim.agenda.getCurrentTime());
                    this.maxWaitTime(p);
                    this.avgWaitTime(p);
                    countOn += 3;
                }
            }
            bus.isFull();
            if (bus.isFull == true) {
                //check for clumping once
                if(bus.clumped == false) {
                    if (this.checkForClumping() == true ) {
                        bus.clumped = true;
                        BusSim.agenda.add(new BusEvent(currentStop, bus), countOn + 5);//wait at stop for an extra five seconds
                        BusSim.timesClumped += 1;//the amount of times a bus had to wait so buses would not clump together
                    }
                }
                bus.setArrivalTime(-8);//sets arrival time to an impossible time and shows that bus is going to be arriving to a new location
                BusSim.agenda.add(new BusEvent(BusSim.stops[findDirection()], bus), countOn + 180);//reschedules bus to next stop
                bus.timesLeft +=1;//amount of times a bus left a stop

                if (bus.bound.equals("east")) {
                    BusSim.stops[findDirection()].setIsHereEast();//number or buses at a stop
                    BusSim.timesNotClumped += 1;//times bus didn't have to wait at stop so buses would not clump together
                } else {
                    BusSim.stops[findDirection()].setIsHereWest();
                    BusSim.timesNotClumped += 1;
                }
            } else if (countOn + (BusSim.agenda.getCurrentTime() - bus.arrivalTime) < 15) {//if bus has been at stop for less than 15 seconds reschedule it for a second later
                BusSim.agenda.add(new BusEvent(currentStop, bus), countOn + 1);//reschedules bus for one second later
            } else {
                //check for clumping
                if (bus.clumped == false) {
                    if (this.checkForClumping() == true) {
                        bus.clumped = true;
                        BusSim.agenda.add(new BusEvent(currentStop, bus), countOn + 5);
                        BusSim.timesClumped += 1;
                    }
                }
                bus.setArrivalTime(-8);//sets arrival time to an impossible time and shows that bus is going to be arriving to a new location
                BusSim.agenda.add(new BusEvent(BusSim.stops[findDirection()], bus), countOn + 180);
                bus.timesLeft +=1;

                if (bus.bound.equals("east")) {
                    BusSim.stops[findDirection()].setIsHereEast();
                    BusSim.timesNotClumped += 1;
                } else {
                    BusSim.stops[findDirection()].setIsHereWest();
                    BusSim.timesNotClumped += 1;
                }
            }
        } else {//there are people that want to get dropped off
            //reschedule to allow for other people who may have not been at bus to run to the bus stop
            BusSim.agenda.add(new BusEvent(currentStop, bus), numP * 2);


        }

    }
}
