import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String fileName){
        Scanner s = null;
        File f = new File(fileName);
        try {
            s = new Scanner(f);
        }catch (Exception e){
            System.out.println("Attempt Failed");
        }
        Bookshelf bookshelf = new Bookshelf();
        Book c;
        while(s.hasNext()){
            String a = s.nextLine();
            String[] b = a.split(",");
            String title = b[0];
            String author = b[1];
            double rating = Double.parseDouble(b[2]);
            c = new Book(title,author,rating);
            bookshelf.add(c);
        }
        bookshelf.sort('r');
        System.out.println(bookshelf.toString());
        return bookshelf;
    }

    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(fileName));
        }catch (Exception e){
            System.out.println("Attempt Failed");
        }
        for(int i = 0; i < b.numEl;i++){
            p.println(b.getIndex(i).toString());
        }
        p.close();
    }

    public static void main(String[] args){
        readBooksFromFile("C:/Users/taiye/Documents/bookinput.txt").sort('r');
        writeShelfToFile(readBooksFromFile("C:/Users/taiye/Documents/bookinput.txt"),"C:/Users/taiye/Documents/output.txt");
    }

}
