package frensch.julian.uichallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText edtTxtName, edtTxtEmail, edtTxtPassword, edtTxtPasswordRepeat;
    private TextView txtWarnName, txtWarnEmail, txtWarnPassword, txtWarnPasswordRepeat;
    private Button btnPickImage, btnRegister;
    private ImageView ProfilePicture;
    private CheckBox LicenseAgreement;
    private RadioGroup Gender;
    private Spinner Country;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init_Register();
            }
        });
    }

    private void initViews() {
        Log.d(TAG,"initViews: Started");

        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtPasswordRepeat = findViewById(R.id.edtTxtPasswordRepeat);

        txtWarnName = findViewById(R.id.txtWarningName);
        txtWarnEmail = findViewById(R.id.txtWarningEmail);
        txtWarnPassword = findViewById(R.id.txtWarningPassword);
        txtWarnPasswordRepeat = findViewById(R.id.txtWarningPasswordRepeat);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        ProfilePicture = findViewById(R.id.imgViewProfilePicture);
        LicenseAgreement = findViewById(R.id.cBLicenceAgreement);
        Gender = findViewById(R.id.rbgGender);
        Country = findViewById(R.id.spinnerCountry);
        parent = findViewById(R.id.parent);
    }

    private void init_Register() {
        Log.d(TAG,"initRegister: Started");
        if(validateRegisterData()) {
            if(LicenseAgreement.isChecked()) {
                showSnackBar();
            }
            else {
                Toast.makeText(this, "You need to agree to license agreement", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar() {
        Log.d(TAG,"showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPasswordRepeat.setVisibility(View.GONE);

        String name = edtTxtName.getText().toString();
        String email = edtTxtName.getText().toString();
        String country = Country.getSelectedItem().toString();
        String gender = "";
        switch(Gender.getCheckedRadioButtonId()) {
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
        }
        String snackText = "Name : " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Country: " + country + "\n";

        Log.d(TAG,snackText);
        Snackbar.make(parent, "Snack Bar Text"+ snackText,Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtTxtName.setText("");
                        edtTxtEmail.setText("");
                        edtTxtPassword.setText("");
                        edtTxtPasswordRepeat.setText("");
                    }
                }).show();
    }

    private boolean validateRegisterData() {
        Log.d(TAG,"validateRegisterData: Started");
        if(edtTxtName.getText().toString().equals("")) {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Name");
            return false;
        }
        if(edtTxtEmail.getText().toString().equals("")) {
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Email");
            return false;
        }
        if(edtTxtPassword.getText().toString().equals("")) {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Password");
            return false;
        }
        if(edtTxtPassword.getText().toString().equals("")) {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Repeat your Password");
            return false;
        }

        if(!edtTxtPassword.getText().toString().equals(edtTxtPasswordRepeat.getText().toString())) {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Password does not match");
            return false;
        }

        return true;
    }

}