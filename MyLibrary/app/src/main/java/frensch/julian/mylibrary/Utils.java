package frensch.julian.mylibrary;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReading;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> favouriteBooks;

    private Utils() {
        if(null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == currentlyReading) {
            currentlyReading = new ArrayList<>();
        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }
        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == favouriteBooks) {
            favouriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: Add initial data
        allBooks.add(new Book(1, "1Q84", "Haruki Murakami", 1350,"https://m.media-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
                "A work of maddening brilliance", "Long Description"));
        allBooks.add(new Book(2, "Getting Started with Bluetooth Low Energy", "Kevin Townsend", 164,"https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/51d+2f5nZbL._SX379_BO1,204,203,200_.jpg",
                "BLE Learning Book", "Long Description"));
    }

    public static synchronized Utils getInstance() {
        if (null == instance) {
            instance = new Utils();
        }
        return instance;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReading() {
        return currentlyReading;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b: allBooks) {
            if(b.getId() == id)
            {
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }
    public boolean addToWantToRead(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addToCurrentlyReading(Book book){
        return currentlyReading.add(book);
    }
    public boolean addToFavourites(Book book){
        return favouriteBooks.add(book);
    }
}
