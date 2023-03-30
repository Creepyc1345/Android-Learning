package frensch.julian.ui_basics3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMatrix,checkBoxJoker;
    private RadioGroup rgMartialStatus;
    private ProgressBar pbCircle;

    private ProgressBar pbLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxMatrix = findViewById(R.id.checkboxMatrix);
        checkBoxJoker = findViewById(R.id.checkboxJoker);

        rgMartialStatus = findViewById(R.id.rgMartialStatus);

        pbCircle = findViewById(R.id.pbCircle);
        pbLine = findViewById(R.id.pbLine);

        if(checkBoxHarry.isChecked())
        {
            Toast.makeText(MainActivity.this, "You watched Harry Potter", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
        }

        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "You watched Harry Potter", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
                }

            }
        });

        int checkedButton = rgMartialStatus.getCheckedRadioButtonId();
        switch (checkedButton)
        {
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbInRel:
                Toast.makeText(MainActivity.this, "In a Relationshio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        rgMartialStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbInRel:
                        Toast.makeText(MainActivity.this, "In a Relationshio", Toast.LENGTH_SHORT).show();
                        pbCircle.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        pbCircle.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    pbLine.incrementProgressBy(1);
                    SystemClock.sleep(50);

                    if(pbLine.getProgress() == 100)
                    {
                        //pbLine.setBackgroundColor(0x00FF00);
                    }
                }

            }
        });
        thread.start();
    }
}