//Written by bello067
import org.junit.Test;

import static org.junit.Assert.*;

public class ElephantHerdTest {

    @Test
    public void add() {
        ElephantHerd herd = new ElephantHerd();
        Elephant elephant = new Elephant("ellie",7,5);
        assertTrue(herd.add(elephant));

    }
    @Test
    public void find() {
        ElephantHerd herd = new ElephantHerd();
        Elephant elephant = new Elephant("ellie",7,5);
        herd.add(elephant);
        assertEquals(herd.find("ellie"), elephant);


    }

    @Test
    public void remove() {
        ElephantHerd herd = new ElephantHerd();
        Elephant elephant = new Elephant("ellie",7,5);
        assertTrue(herd.add(elephant));
        assertEquals(herd.numEl,1);
        herd.remove(0);
        assertEquals(herd.numEl,0);

    }

    @Test
    public void sort() {
        ElephantHerd herd = new ElephantHerd();
        Elephant elephant1 = new Elephant("ellie",12,6.0);
        Elephant elephant2 = new Elephant("sam",9,5.6);
        Elephant elephant3 = new Elephant("keke",7,5.5);
        Elephant elephant4 = new Elephant("jason",10,5.8);
        herd.add(elephant1);
        herd.add(elephant2);
        herd.add(elephant3);
        herd.add(elephant4);
        System.out.println(herd.toString());
        herd.sort();
        System.out.println(herd.toString());
        assertTrue(herd.getIndex(0).getHeight() == 6.0);
        assertTrue(herd.getIndex(1).getHeight() == 5.8);
        assertTrue(herd.getIndex(2).getHeight() == 5.6);
        assertTrue(herd.getIndex(3).getHeight() == 5.5);
    }

    @Test
    public void getTopKLargestElephants() {
        ElephantHerd herd = new ElephantHerd();
        Elephant elephant1 = new Elephant("ellie",12,6.0);
        Elephant elephant2 = new Elephant("sam",9,5.6);
        Elephant elephant3 = new Elephant("keke",7,5.5);
        Elephant elephant4 = new Elephant("jason",10,5.8);
        herd.add(elephant1);
        herd.add(elephant2);
        herd.add(elephant3);
        herd.add(elephant4);
        Elephant a = herd.getTopKLargestElephants(5)[0];
        Elephant b = herd.getTopKLargestElephants(5)[1];
        Elephant c = herd.getTopKLargestElephants(5)[2];
        Elephant d = herd.getTopKLargestElephants(5)[3];
        assertTrue(a.getHeight() == 6.0);
        assertTrue(b.getHeight() == 5.8);
        assertTrue(c.getHeight() == 5.6);
        assertTrue(d.getHeight() == 5.5);
        //System.out.println(herd.getTopKLargestElephants(5).length);



    }
}