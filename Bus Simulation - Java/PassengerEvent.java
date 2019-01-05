//Written by bello067

import java.util.Random;

public class PassengerEvent implements Event {

    Stop currentStop;

    public PassengerEvent(Stop currentStop){
        this.currentStop = currentStop;
    }

    public void run(){

        int destinationNum = 0; //stop passengers will be going to

        //makes sure the destination and currentStop are not the same so passenger does not go to the island it is currently on
        String destination = currentStop.stop;
        while(currentStop.equals(destination)) {
            Random rand1 = new Random();
            int x = rand1.nextInt(13);

            //chooses destination based on probability, downtown stops have 2/13 probability and normal stops have 1/13 probability of being chosen as the next destination
            if (0 <= x && x < 2) {//downtown stop
                destination = BusSim.stops[7].stop;
                destinationNum = 7;
            } else if (2 <= x && x < 4) {//downtown stop
                destination = BusSim.stops[8].stop;
                destinationNum = 8;
            } else if (4 <= x && x < 6) {//downtown stop
                destination = BusSim.stops[9].stop;
                destinationNum = 9;
            } else if (6 <= x && x < 7) {//normal stops begin
                destination = BusSim.stops[0].stop;
                destinationNum = 0;
            } else if (7 <= x && x < 8) {
                destination = BusSim.stops[1].stop;
                destinationNum = 1;
            } else if (8 <= x && x < 9) {
                destination = BusSim.stops[2].stop;
                destinationNum = 2;
            } else if (9 <= x && x < 10) {
                destination = BusSim.stops[3].stop;
                destinationNum = 3;
            } else if (10 <= x && x < 11) {
                destination = BusSim.stops[4].stop;
                destinationNum = 4;
            } else if (11 <= x && x < 12) {
                destination = BusSim.stops[5].stop;
                destinationNum = 5;
            } else {
                destination = BusSim.stops[6].stop;
                destinationNum = 6;
            }
            //normal stops end
        }
        String bound = "";
        if(currentStop.getLocation() < destinationNum ){//determines direction passenger will be going in
            bound = "east";
        }else{
            bound = "west";
        }

        int t = (int) BusSim.agenda.getCurrentTime();

        Passenger p1 = new Passenger(t,destination,bound);

        //add passenger to queue
        currentStop.addPassenger(p1);

        BusSim.totalNumOfPass += 1;

        if(p1.direction.equals("east")){//changes max Q length out of all stops
            if(BusSim.maxQLength[currentStop.getLocation()] < currentStop.east.length()){
                BusSim.maxQLength[currentStop.getLocation()] = currentStop.east.length();
                currentStop.summationOfQLength += currentStop.east.length();
                currentStop.divisor +=1;
            }
        }else{
            if(BusSim.maxQLength[currentStop.getLocation()] < currentStop.west.length()){
                BusSim.maxQLength[currentStop.getLocation()] = currentStop.west.length();
                currentStop.summationOfQLength += currentStop.west.length();
                currentStop.divisor +=1;
            }
        }

        Random rand3 = new Random();
        int z = rand3.nextInt(100);

        double time;

        //based on probability, the arrival time of the passenger will be determined
        int load = BusSim.load;
        if(0 <= z && z < 10){
            time = (load + 0.75) * load;
        }else if(10 <= z && z <25){
            time = (load + 0.50) * load;
        }else if(25 <= z && z < 45){
            time = (load + 0.20) * load;
        }else if(45 <= z && z < 55){
            time = load;
        }else if(55 <= z && z < 75){
            time = (load - 0.20)*load;
        }else if(75 <= z && z < 90){
            time = (load - 0.50)*load;
        }else{
            time = (load - 0.75)*load;
        }
        //reschedule
        PassengerEvent p0 = new PassengerEvent(currentStop);
        BusSim.agenda.add(p0,time);
    }
}
