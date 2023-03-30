package frensch.julian.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view){
        // First Name
        TextView txtFirstName = findViewById(R.id.txtFirstName);
        EditText edtTxtFirstName = findViewById(R.id.edtTxtFirstName);
        txtFirstName.setText("First Name: " + edtTxtFirstName.getText().toString());

        // Last Name
        TextView txtLastName = findViewById(R.id.txtLastName);
        EditText edtTxtLastName = findViewById(R.id.edtTxtLastName);
        txtLastName.setText("Last Name: " + edtTxtLastName.getText().toString());

        // Email
        TextView txtEmail = findViewById(R.id.txtEmail);
        EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);
        txtEmail.setText("Email: " + edtTxtEmail.getText().toString());
    }
}
