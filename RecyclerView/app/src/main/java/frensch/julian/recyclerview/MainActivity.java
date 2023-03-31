package frensch.julian.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Margot Robbie", "Margot@gmail.com","https://upload.wikimedia.org/wikipedia/commons/c/ce/Robbie_at_2019_Cannes_%28cropped%29.jpg"));
        contacts.add(new Contact("Cillan Murphy", "Cillam@gmail.com","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/800px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg"));
        contacts.add(new Contact("Saoirse Ronan", "Saoirse@gmail.com","https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Saoirse_Ronan_at_BAFTA_2016_%281%29_%28cropped%29.jpg/800px-Saoirse_Ronan_at_BAFTA_2016_%281%29_%28cropped%29.jpg"));
        contacts.add(new Contact("Emma Watson", "Emma@gmail.com","https://upload.wikimedia.org/wikipedia/commons/7/71/Emma_Watson_in_the_Bag.jpg"));
        contacts.add(new Contact("Cristian Bale", "Cristian@gmail.com","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Christian_Bale-7834.jpg/800px-Christian_Bale-7834.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this));
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        contactsRecView.setLayoutManager(new GridLayoutManager(this,2));
    }
}