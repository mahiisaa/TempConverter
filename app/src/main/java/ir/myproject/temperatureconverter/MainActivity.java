package ir.myproject.temperatureconverter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button cButton;
    private Button fButton;
    private EditText getTemp;
    private TextView showTemp;

    private AlertDialog.Builder dialog;
    private Toolbar toolbar;
    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cButton = (Button) findViewById(R.id.cButtonID);
        fButton = (Button) findViewById(R.id.fButtonID);
        getTemp = (EditText) findViewById(R.id.getTempID);
        showTemp = (TextView) findViewById(R.id.showTempID);

        //set up our Buttons(event listeners)
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextVal = getTemp.getText().toString();
                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter Temp", Toast.LENGTH_LONG).show();
                } else {
                    double intVal = Double.parseDouble(editTextVal);
                    String stringResult = String.valueOf(round.format(convertToCelsius(intVal)));
                    showTemp.setText(stringResult + "C");
                }

            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editTextVal = getTemp.getText().toString();
                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter Temp", Toast.LENGTH_LONG).show();
                } else {
                    double intVal = Double.parseDouble(editTextVal);
                    String stringResult = String.valueOf(round.format(convertToFar(intVal)));
                    showTemp.setText(stringResult + "F");

                }
            }
        });



    }


    public double convertToCelsius(double farVal) {
        double resultCel;
        resultCel = (farVal - 32) * 5 / 9;
        return resultCel;

    }

    public double convertToFar(double celVal) {
        double resultFar;
        resultFar = (celVal * 9 / 5) + 32;
        return resultFar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

            if(id==R.id.aboutAppID) {
                startActivity(new Intent(MainActivity.this, secondActivity.class));
            }

            else if(id==R.id.changeThemeID) {
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(getResources().getString(R.string.Alert_title));
                dialog.setMessage(getResources().getString(R.string.Alert_message));
                dialog.setCancelable(false);
                dialog.setPositiveButton(getResources().getString(R.string.positive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                        finish();
                        System.exit(0);
                    }
                });
                dialog.setNegativeButton(getResources().getString(R.string.negative), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.setCancelable(true);
                    }
                });
                AlertDialog alertD = dialog.create();
                dialog.show();

            }
                return super.onOptionsItemSelected(item);
        }

    }

