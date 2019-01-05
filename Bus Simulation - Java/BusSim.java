//Written by bello067
//Main Bus Simulator

public class BusSim {


    public static int timesClumped = 0; //number of times a bus rescheduled at current stop - stayed
    public static int timesNotClumped = 0; //number of times a bus rescheduled to go to the next stop - left
    public static int totalNumOfPass = 0;//total number of passengers
    public static int totalWaitTime = 0; //total wait time of all passengers
    public static int totalTravelTime; //total travel time of all passengers
    public static int avgWaitTimeOfPass = totalWaitTime/totalNumOfPass; //average wait time of all passengers
    public static int avgTravelTime = totalTravelTime + totalWaitTime/totalNumOfPass; //average travel time of all passenger
    public static int totalNumOfPassTraveled; //total number of passengers that traveled
    public static int avgNumOfPassAtAStop[] = {0,0,0,0,0,0,0,0,0,0}; //average number of passengers at each stop
    public static int load = 120; // passenger will be made on average 1/load time intervals
    public static int maxQLength[] = {0,0,0,0,0,0,0,0,0,0}; //longest length a queue has gotten at each stop
    public static int maxWaitTime = 0; //longest time a passenger had to wait to get on a bus
    public static int passMilesPerGallon[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};// passenger miles per gallon of each bus

    static int numBus = 0; // total number of buses

    static PQ agenda = new PQ();

    //stops
    static Stop zero = new Stop("University Ave and 27th Street SE",0);
    static Stop one = new Stop("Raymond Ave Station",1);
    static Stop two = new Stop("University Ave and Fairview Ave",2);
    static Stop three = new Stop( "University Ave and Snelling Ave",3);
    static Stop four = new Stop("University Ave and Lexington Parkway",4);
    static Stop five = new Stop("University Ave and Dale Street",5);
    static Stop six = new Stop("University Ave and Marion Street",6);
    static Stop seven = new Stop("Cedar Street and 5th Street",7);
    static Stop eight = new Stop("Minnesota Street and 4th Street",8);
    static Stop nine = new Stop("Union Depot",9);

    public static Stop[] stops = {zero,one,two,three,four,five,six,seven,eight,nine};

    public static void main (String[] args){
        //make passenger events
        PassengerEvent zeroPE = new PassengerEvent(zero);
        PassengerEvent onePE = new PassengerEvent(one);
        PassengerEvent twoPE = new PassengerEvent(two);
        PassengerEvent threePE = new PassengerEvent(three);
        PassengerEvent fourPE = new PassengerEvent(four);
        PassengerEvent fivePE = new PassengerEvent(five);
        PassengerEvent sixPE = new PassengerEvent(six);
        PassengerEvent sevenPE = new PassengerEvent(seven);
        PassengerEvent eightPE = new PassengerEvent(eight);
        PassengerEvent ninePE = new PassengerEvent(nine);

        //make buses
        Bus bus1 = new Bus("small","east");
        Bus bus2 = new Bus("large","east");
        Bus bus3 = new Bus("small","west");
        Bus bus4 = new Bus("large","east");
        Bus bus5 = new Bus("small","west");
        Bus bus6 = new Bus("large","east");
        Bus bus7 = new Bus("small","west");
        Bus bus8 = new Bus("large","east");
        Bus bus9 = new Bus("small","west");
        Bus bus10 = new Bus("large","east");
        Bus bus11 = new Bus("small","west");
        Bus bus12 = new Bus("large","east");
        Bus bus13 = new Bus("small","west");
        Bus bus14 = new Bus("large","east");
        Bus bus15 = new Bus("small","west");
        Bus bus16 = new Bus("large","east");
        Bus bus17 = new Bus("small","west");
        Bus bus18 = new Bus("large","west");

        //add miles per gallon to list
        bus1.setMilesPerGallon(0);
        bus1.setMilesPerGallon(1);
        bus1.setMilesPerGallon(2);
        bus1.setMilesPerGallon(3);
        bus1.setMilesPerGallon(4);
        bus1.setMilesPerGallon(5);
        bus1.setMilesPerGallon(6);
        bus1.setMilesPerGallon(7);
        bus1.setMilesPerGallon(8);
        bus1.setMilesPerGallon(9);
        bus1.setMilesPerGallon(10);
        bus1.setMilesPerGallon(11);
        bus1.setMilesPerGallon(12);
        bus1.setMilesPerGallon(13);
        bus1.setMilesPerGallon(14);
        bus1.setMilesPerGallon(15);
        bus1.setMilesPerGallon(16);
        bus1.setMilesPerGallon(17);

        //makes bus events
        BusEvent busE1 = new BusEvent(zero,bus1);
        BusEvent busE2 = new BusEvent(one,bus2);
        BusEvent busE3 = new BusEvent(one,bus3);
        BusEvent busE4 = new BusEvent(two,bus4);
        BusEvent busE5 = new BusEvent(two,bus5);
        BusEvent busE6 = new BusEvent(three,bus6);
        BusEvent busE7 = new BusEvent(three,bus7);
        BusEvent busE8 = new BusEvent(four,bus8);
        BusEvent busE9 = new BusEvent(four,bus9);
        BusEvent busE10 = new BusEvent(five,bus10);
        BusEvent busE11 = new BusEvent(five,bus11);
        BusEvent busE12 = new BusEvent(six,bus12);
        BusEvent busE13 = new BusEvent(six,bus13);
        BusEvent busE14 = new BusEvent(seven,bus14);
        BusEvent busE15 = new BusEvent(seven,bus15);
        BusEvent busE16 = new BusEvent(eight,bus16);
        BusEvent busE17 = new BusEvent(eight,bus17);
        BusEvent busE18 = new BusEvent(nine,bus18);

        //adds passenger event to agenda queue
        agenda.add(zeroPE,0);
        agenda.add(onePE,0);
        agenda.add(twoPE,0);
        agenda.add(threePE,0);
        agenda.add(fourPE,0);
        agenda.add(fivePE,0);
        agenda.add(sixPE,0);
        agenda.add(sevenPE,0);
        agenda.add(eightPE,0);
        agenda.add(ninePE,0);

        //adds bus events to agenda queue
        agenda.add(busE1,0);
        agenda.add(busE2,0);
        agenda.add(busE3,0);
        agenda.add(busE4,0);
        agenda.add(busE5,0);
        agenda.add(busE6,0);
        agenda.add(busE7,0);
        agenda.add(busE8,0);
        agenda.add(busE9,0);
        agenda.add(busE10,0);
        agenda.add(busE11,0);
        agenda.add(busE12,0);
        agenda.add(busE13,0);
        agenda.add(busE14,0);
        agenda.add(busE15,0);
        agenda.add(busE16,0);
        agenda.add(busE17,0);
        agenda.add(busE18,0);

        while(agenda.getCurrentTime() <= 5000) {
            agenda.remove().run();
        }

        //adds wait time of passengers that didn't get on a bus
        for(int i =0; i < stops.length;i++ ){
            stops[i].totalWaitTime();
        }

        for(int i =0; i < stops.length;i++ ){//adds average number of passengers at each stop to list
            avgNumOfPassAtAStop[i] = stops[i].summationOfQLength/stops[i].divisor;
        }

        //Printed Stats
        System.out.println("The total wait time is " + totalWaitTime + "and the total travel time is " + totalTravelTime);
        System.out.println("The average wait time is " + avgWaitTimeOfPass + "and the avergae travel time is " + avgTravelTime);
        System.out.println("The total number of passengers are " + totalNumOfPass);
        System.out.println("The total number of passengers that traveled are " + totalNumOfPassTraveled);
        System.out.println(maxWaitTime);
        for(int i =0; i < avgNumOfPassAtAStop.length;i++){
            System.out.println("The average number of passengers at stop " + i + "is " + avgNumOfPassAtAStop[i]);
        }
        for(int i =0; i < maxQLength.length;i++){
            System.out.println("The max queue length at stop " + i + "is " + maxQLength[i]);
        }
        for(int i =0; i < passMilesPerGallon.length;i++){
            System.out.println("The passenger miles per gallon for bus " + i + "is " + passMilesPerGallon[i]);
        }
        System.out.println("The buses clump" + timesClumped + "out of" + timesNotClumped + "times its reschedule to go to the next stop");
    }



}
