package frensch.julian.ui_basics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTxt;
    private TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

        edtTxt = findViewById(R.id.EditTxtName);
        edtTxt.setOnClickListener(this);

        txtHello = findViewById(R.id.txtHello);

        /*btnHello.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_LONG).show();
                return false;
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnHello:
                //Toast.makeText(this, "Hello Button clicked", Toast.LENGTH_SHORT).show();
                txtHello.setText("Hello " + edtTxt.getText().toString());
                break;
            case R.id.EditTxtName:
                Toast.makeText(this, "Attenpting to type something", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
}