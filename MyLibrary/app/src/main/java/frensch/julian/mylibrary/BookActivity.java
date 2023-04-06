package frensch.julian.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";
    private TextView txtBookName, txtAuthor, txtNumPages, txtLongDescription;
    private Button btnAddToCurrentlyReading,btnAddToWantToRead,btnAddToAlreadyRead,btnAddToFavourites;
    private ImageView imgBookCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDescription = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer";
//
//        //TODO: Get the data from the recycler view in here
//        Book book = new Book(1, "1Q84", "Haruki Murakami", 1350,"https://m.media-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
//                "A work of maddening brilliance", longDescription);

        Intent intent = getIntent(); // Receive intent when activity is called
        if(intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId != -1) {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if(null != incomingBook) {
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToRead(incomingBook);
                    handleCurrentlyReading(incomingBook);
                    handleFavourite(incomingBook);
                }
            }
        }
    }

    private void initViews() {
        txtBookName = findViewById(R.id.txtBookName);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtNumPages = findViewById(R.id.txtNumPages);
        txtLongDescription = findViewById(R.id.txtLongDescription);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToRead);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToFavourites = findViewById(R.id.btnAddToFavourites);
        imgBookCover = findViewById(R.id.imgBookCover);
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtNumPages.setText(String.valueOf(book.getPages()));
        txtLongDescription.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(imgBookCover);
    }

    /**
     * Enable and disable button,
     * Add to book to Already Read Book ArrayList
     * @param book
     */
    private void handleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b: alreadyReadBooks)
        {
            if(b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }
        if(existInAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleWantToRead(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for (Book b: wantToReadBooks)
        {
            if(b.getId() == book.getId()) {
                existInWantToReadBooks = true;
            }
        }
        if(existInWantToReadBooks) {
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToWantToRead(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleCurrentlyReading(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReading();

        boolean existInCurrentlyReading = false;

        for (Book b: currentlyReadingBooks)
        {
            if(b.getId() == book.getId()) {
                existInCurrentlyReading = true;
            }
        }
        if(existInCurrentlyReading) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToCurrentlyReading(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,CurrentlyReadingBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleFavourite(final Book book) {
        ArrayList<Book> favouriteBooks = Utils.getInstance(this).getFavouriteBooks();

        boolean existInFavourite = false;

        for (Book b: favouriteBooks)
        {
            if(b.getId() == book.getId()) {
                existInFavourite = true;
            }
        }
        if(existInFavourite) {
            btnAddToFavourites.setEnabled(false);
        } else {
            btnAddToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToFavourites(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,FavouriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}