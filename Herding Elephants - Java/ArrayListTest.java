import org.junit.Test;
//pass in doubles for all tests
////Written by bello067
import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void add() throws Exception{
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        assertTrue(test.add(shelly));
    }

    @Test
    public void add1() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        assertTrue(test.add(1,shelly));
    }


    @Test
    public void clear() throws Exception{
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        assertTrue(test.add(shelly));
        test.clear();
        assertTrue(test.isEmpty());
    }

    @Test
    public void contains() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        test.add(shelly);
        assertTrue(test.contains(shelly));
    }


    @Test
    public void get() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        test.add(shelly);
        test.add(bob);
        assertEquals(bob,test.get(1));
    }

    @Test
    public void indexOf() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6.0);
        Elephant bob = new Elephant("bob",17,7.6);
        Elephant shane = new Elephant("shane",23,7.3);
        //Elephant lilly = new Elephant("lilly",19,7.5);
        Elephant greg = new Elephant("greg",18,7.2);
        test.add(shelly);
        test.add(shelly);
        test.add(greg);
        test.add(shane);
        test.add(bob);
        assertEquals(0,test.indexOf(shelly));
    }

    @Test
    public void isEmpty() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        assertTrue(test.add(shelly));
        assertTrue(test.add(bob));
        test.clear();
        assertTrue(test.isEmpty());


    }

    @Test
    public void lastIndexOf() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        //Elephant shane = new Elephant("shane",18,7.0);
        Elephant greg = new Elephant("greg",18,7.0);
        Elephant lilly = new Elephant("lilly",18,7.0);
        Elephant bob = new Elephant("bob",18,7.0);
        test.add(shelly);
        test.add(lilly);
        test.add(greg);
        test.add(bob);
        test.add(bob);
        assertEquals(4,test.lastIndexOf(bob));
    }

    @Test
    public void set() {
        ArrayList test = new ArrayList();
        Elephant bob = new Elephant("bob",18,7);
        test.set(1,bob);
        assertEquals(test.get(1),bob);

    }

    @Test
    public void size() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        test.add(shelly);
        test.add(bob);
        assertEquals(2,test.size());
    }

    @Test
    public void sort() {
        ArrayList test = new ArrayList();
        Elephant shelly = new Elephant("shelly",15,6);
        Elephant bob = new Elephant("bob",18,7);
        test.add(shelly);
        test.add(bob);
        test.sort(true);
        assertEquals(test.get(0),bob);
        assertEquals(test.get(1),shelly);
    }

    @Test
    public void remove() {
        ArrayList test = new ArrayList();
        Elephant bob = new Elephant("bob",18,7);
        assertTrue(test.add(bob));
        test.remove(bob);
        assertEquals(null,test.get(0));


    }

    @Test
    public void remove1() {
        ArrayList test = new ArrayList();
        Elephant bob = new Elephant("bob",18,7);
        assertTrue(test.add(bob));
        test.remove(0);
        assertEquals(null,test.get(0));
    }

    @Test
    public void toStrings() {
        ArrayList test = new ArrayList();
        Elephant bob = new Elephant("bob",18,7);
        test.add(bob);
        String expected = "bob 18 7.0\n";
        System.out.print(test.toString());
        assertEquals(expected,test.toString());
    }
}