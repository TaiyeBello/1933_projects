import org.junit.Test;

import static org.junit.Assert.*;

public class BookshelfTest {

    @org.junit.Test
    public void add() throws Exception {
        //make bookshelf
        Bookshelf a = new Bookshelf();
        //make book
        Book b = new Book("To Kill a Mocking Bird","Ashley Davis",4.5);
        //add book to bookshelf
        boolean x = a.add(b);
        assertTrue(x);
    }

    @org.junit.Test
    public void getBooksByAuthor() throws Exception{
        Bookshelf a = new Bookshelf();
        Book b = new Book("To Kill a Mocking Bird","Ashley Davis",4.5);
        Book d = new Book("The Journey","Chris Davis",4.5);

        a.add(b);
        a.add(d);

        Bookshelf c;
        c = a.getBooksByAuthor("Ashley Davis");
        //check if first element has something(b) and second has nothing if so it works
        assertEquals(b, c.getIndex(0));
        assertEquals(null, c.getIndex(1));

        //assertTrue(c.numEl == 1);

    }

    @org.junit.Test
    public void toStrings() throws Exception{//cant have same name as toString becasue toString overides object to print object so if you have two
        //it will try to overide using this toString as well
        Bookshelf a = new Bookshelf();
        Book b = new Book("To Kill a Mocking Bird","Ashley Davis",4.5);
        //Book c = new Book("Tom and Jerry","Chris Davis",4.2);
        a.add(b);
        //a.add(c);
        //a.toString();
        String expected = "To Kill a Mocking Bird, Ashley Davis, 4.5\n";
        //assertTrue(a.toString().equals(expected));
        System.out.println(expected);
        System.out.println(a.toString());
        assertEquals(expected, a.toString());
    }

    @Test
    public void sort() {
        Bookshelf a = new Bookshelf();
        Bookshelf sortT = new Bookshelf();
        Bookshelf sortA = new Bookshelf();

        Book b = new Book("The Journey","Ashley Davis",4.1);
        Book c = new Book("Saving Christmas","Tina Charles",3.5);
        Book d = new Book("Loving the Outlier","Andrew Hemmings",4.2);

        a.add(b);
        a.add(c);
        a.add(d);

        sortT.add(d);
        sortT.add(c);
        sortT.add(b);

        sortA.add(d);
        sortA.add(b);
        sortA.add(c);

        a.sort('t');
        assertEquals(sortT.toString(), a.toString());
        a.sort('a');
        assertEquals(sortA.toString(), a.toString());
    }
}