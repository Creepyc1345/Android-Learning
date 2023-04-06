package frensch.julian.mylibrary;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String CURRENTLY_READING_BOOKS_KEY = "currently_reading_books";
    private static final String ALREADY_READ_BOOKS_KEY = "already_read_books";
    private static final String WANT_TO_READ_BOOKS_KEY = "want_to_read_books";
    private static final String FAVOURITE_BOOKS_KEY = "favourite_books";
    private static Utils instance;

    private SharedPreferences sharedPreferences;

//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> currentlyReading;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> favouriteBooks;

    private Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(null == getAllBooks()) { // First Time Launching Application -> Add some Books
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getCurrentlyReading()) {
            editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToReadBooks()) {
            editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getAlreadyReadBooks()) {
            editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getFavouriteBooks()) {
            editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
        //TODO: Add initial data
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "1Q84", "Haruki Murakami", 1350,"https://m.media-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
                "A work of maddening brilliance", "Long Description"));
        books.add(new Book(2, "Getting Started with Bluetooth Low Energy", "Kevin Townsend", 164,"https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/51d+2f5nZbL._SX379_BO1,204,203,200_.jpg",
                "BLE Learning Book", "Long Description"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        //editor.apply();
        editor.commit();
    }

    public static synchronized Utils getInstance(Context context) {
        if (null == instance) {
            instance = new Utils(context);
        }
        return instance;
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReading() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getFavouriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVOURITE_BOOKS_KEY, null), type);
        return books;
    }

    public Book getBookById(int id) {
        ArrayList<Book> books = getAllBooks();
        if(books != null)
        {
            for (Book b: books) {
                if(b.getId() == id)
                {
                    return b;
                }
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(books != null) {
            if(books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS_KEY);
                editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(books != null) {
            if(books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS_KEY);
                editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReading();
        if(books != null) {
            if(books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS_KEY);
                editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToFavourites(Book book){
        ArrayList<Book> books = getFavouriteBooks();
        if(books != null) {
            if(books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVOURITE_BOOKS_KEY);
                editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();
        if (books != null) {
            for(Book b: books) {
                if (b.getId() == book.getId()) {
                    if(books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS_KEY);
                        editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromCurrentlyReading(Book book) {
        ArrayList<Book> books = getCurrentlyReading();
        if (books != null) {
            for(Book b: books) {
                if (b.getId() == book.getId()) {
                    if(books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS_KEY);
                        editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadBooks();
        if (books != null) {
            for(Book b: books) {
                if (b.getId() == book.getId()) {
                    if(books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS_KEY);
                        editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromFavourite(Book book) {
        ArrayList<Book> books = getFavouriteBooks();
        if (books != null) {
            for(Book b: books) {
                if (b.getId() == book.getId()) {
                    if(books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVOURITE_BOOKS_KEY);
                        editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
