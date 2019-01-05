//Written by bello067
import static org.junit.Assert.*;

public class LinkedListTest {

    @org.junit.Test
    public void add() {
        LinkedList a = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        assertTrue(a.add(shelly));
    }

    @org.junit.Test
    public void add1() {
        LinkedList a = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        assertTrue(a.add(0,shelly));
        assertTrue(a.add(1,shelly));

    }

    @org.junit.Test
    public void clear() {
        LinkedList test = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        assertTrue(test.add(shelly));
        test.clear();
        assertTrue(test.isEmpty());
    }

    @org.junit.Test
    public void contains() {
        LinkedList test = new LinkedList();
        Elephant kelly = new Elephant("kelly",18,6.9);
        Elephant nick = new Elephant("nick",19,6.7);
        Elephant anie = new Elephant("anie",17,6.8);
        Elephant ashley = new Elephant("ashley",29,7.5);
        test.add(kelly);
        test.add(anie);
        test.add(nick);
        test.sort(true);
        assertTrue(test.contains(kelly));
    }

    @org.junit.Test
    public void get() {
        LinkedList test = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        test.add(shelly);
        test.add(bob);
        assertEquals(bob,test.get(1));
    }

    @org.junit.Test
    public void indexOf() {
        LinkedList test = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6.0);
        Elephant bob = new Elephant("bob",17,7.6);
        Elephant shane = new Elephant("shane",23,7.3);
        test.add(shelly);
        test.add(shane);
        test.add(bob);
        System.out.println(test.toString());
        test.sort(true);
        System.out.println(test.toString());
        assertEquals(0,test.indexOf(bob));
        assertEquals(1,test.indexOf(shane));
        assertEquals(2,test.indexOf(shelly));
    }

    @org.junit.Test
    public void isEmpty() {
        LinkedList test = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        assertTrue(test.add(shelly));
        assertTrue(test.add(bob));
        test.clear();
        assertTrue(test.isEmpty());

    }

    @org.junit.Test
    public void lastIndexOf() {
        LinkedList test = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant greg = new Elephant("greg",18,7.0);
        Elephant lilly = new Elephant("lilly",18,7.0);
        Elephant bob = new Elephant("bob",18,7.0);
        test.add(shelly);
        test.add(lilly);
        test.add(greg);
        test.add(bob);
        test.add(bob);
        test.sort(true);
        assertEquals(1,test.lastIndexOf(bob));
    }

    @org.junit.Test
    public void set() {
        LinkedList test = new LinkedList();
        Elephant bob = new Elephant("bob",18,7);
        Elephant shelly = new Elephant("bob",18,7);
        test.add(shelly);
        test.set(0,bob);
        assertEquals(test.get(0),bob);
    }

    @org.junit.Test
    public void size() {
        LinkedList test = new LinkedList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        test.add(shelly);
        test.add(bob);
        assertEquals(2,test.size());
    }

    @org.junit.Test
    public void sort() {
        LinkedList test = new LinkedList();
        Elephant ashley = new Elephant("ashley",15,6);
        Elephant bob = new Elephant("bob",18,7);
        Elephant carl = new Elephant("carl",19,7.7);
        Elephant dylan = new Elephant("dylan",15,6);
        Elephant earl = new Elephant("earl",18,7);
        Elephant fred = new Elephant("fred",19,7.7);
        test.add(dylan);
        test.add(ashley);
        test.add(bob);
        test.add(earl);
        test.add(fred);
        test.add(carl);
        test.sort(true);
        assertEquals(test.get(0),ashley);



    }

    @org.junit.Test
    public void remove() {
        LinkedList test = new LinkedList();
        Elephant bob = new Elephant("bob",18,7);
        assertTrue(test.add(bob));
        test.remove(bob);
        assertEquals(null,test.get(0));
    }

    @org.junit.Test
    public void remove1() {
        LinkedList test = new LinkedList();
        Elephant bob = new Elephant("bob",18,7);
        assertTrue(test.add(bob));
        test.remove(0);
        assertEquals(null,test.get(0));
    }

    @org.junit.Test
    public void toStrings() {
        LinkedList test = new LinkedList();
        Elephant bob = new Elephant("bob",18,7);
        test.add(bob);
        String expected = "bob 18 7.0\n";
        System.out.print(test.toString());
        assertEquals(expected,test.toString());
    }
}