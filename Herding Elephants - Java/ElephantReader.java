//Written by bello067
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class ElephantReader {

    public static boolean readElephants(ElephantHerd e, String fileName){//deletes elephants from e and replaces them with elephants from the file
        Scanner s = null;
        File f = new File(fileName);
        try {
            s = new Scanner(f);
        }catch (Exception t){
            System.out.println("test");
            return false;
        }
        if(e.equals(null)) {
            return false;
        }
        System.out.println(e.toString());
        e.clear();

        //ElephantHerd elephantHerd = new ElephantHerd();
        Elephant elephants;
        while (s.hasNext()){//adds elephants to herd
            String a = s.nextLine();
            String[] line = a.split(" ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            double height = Double.parseDouble(line[2]);
            elephants = new Elephant(name,age,height);
            e.add(elephants);
        }

        System.out.println(e.toString());
        return true;

    }

    public static boolean writeElephants(ElephantHerd e, String fileName){//writes all elements of e to a file
        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(fileName));
        }catch (Exception t){
            System.out.println("Attempt Failed");
            return false;
        }
        if(e.equals(null) || e.numEl == 0){
            return false;
        }
        for(int i = 0; i < e.numEl;i++){
            p.println(e.getIndex(i).toString());
        }
        p.close();
        return true;
    }
    public static void main(String[] args){
        ElephantHerd herd = new ElephantHerd();
        Elephant elephant1 = new Elephant("ellie",7,5.9);
        Elephant elephant2 = new Elephant("dan",8,5.3);
        Elephant elephant3 = new Elephant("blue",9,5.6);
        Elephant elephant4 = new Elephant("grey",10,5.4);
        Elephant elephant5 = new Elephant("jason",17,6.4);
        herd.add(elephant1);
        herd.add(elephant2);
        herd.add(elephant3);
        herd.add(elephant4);
        herd.add(elephant5);
        readElephants(herd,"C:\\Users\\taiye\\IdeaProjects\\CSCI1933\\Project2\\src\\ElephantText.txt");
        writeElephants(herd,"C:\\Users\\taiye\\IdeaProjects\\CSCI1933\\Project2\\src\\ElephantOutput.txt");
    }
}
