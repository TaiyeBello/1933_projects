public class Bookshelf {

    Book[] book;
    int numEl;

    public Bookshelf() {
        book = new Book[20];
        numEl = 0;
    }

    public Bookshelf(int initSize) {
        book = new Book[initSize];
        numEl = 0;
    }

    public boolean add(Book newBook) {
        if (numEl == book.length) {//if bookshelf is full
            return false;
        } else if (numEl == 0) {//if bookshelf is empty
            book[numEl] = newBook;
        } else {//if bookshelf not empty
            book[numEl] = newBook;
        }
        numEl = numEl + 1;
        return true;
    }

    public Bookshelf getBooksByAuthor(String author) {
        Bookshelf a = new Bookshelf(book.length);
        for (int i = 0; i < numEl; i++) {//if you i < book length there will be null exception error
            if (book[i].getAuthor().equals(author)) {
                a.add(book[i]);
            }
        }
        return a;
    }

    public Book getIndex(int index) {
        if (!(0 <= index && index < book.length)) {
            return null;
        } else {
            return book[index];
        }
    }

    public String toString() {
        String allBooks = "";
        for (int i = 0; i < numEl; i++) {//change book.length to numEl so it wouldn't check for null spots
            allBooks = allBooks + book[i] + "\n";
        }
        return allBooks;
    }

    public void sort(char sortBy) {
        if(sortBy == 'a' || sortBy == 'A'){
            for(int i = 1;i<numEl;i++){
                Book temp = book[i];
                for(int j = i -1; j >= 0 && temp.compareTo(book[j], 'a') < 0;j--){
                    book[j + 1] = book[j];
                    book[j] = temp;
                }
            }
        }
        if(sortBy == 't' || sortBy == 'T'){
            for(int i = 1;i<numEl;i++){
                Book temp = book[i];
                for(int j = i -1; j >= 0 && temp.compareTo(book[j], 't') < 0;j--){
                    book[j + 1] = book[j];
                    book[j] = temp;
                }
            }
        }
        if(sortBy == 'r' || sortBy == 'R'){
            for(int i = 1;i<numEl;i++){
                Book temp = book[i];
                for(int j = i -1; j >= 0 && temp.compareTo(book[j], 'r') < 0;j--){
                    book[j + 1] = book[j];
                    book[j] = temp;
                }
            }
        }
    }

}

