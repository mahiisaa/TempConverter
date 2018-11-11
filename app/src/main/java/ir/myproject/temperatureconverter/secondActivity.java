package ir.myproject.temperatureconverter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {
private Toolbar toolbar;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


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
                Toast.makeText(getApplicationContext(), "this is About App page", Toast.LENGTH_SHORT).show();
            }
               // break;
            else if(id==R.id.changeThemeID) {
                dialog = new AlertDialog.Builder(secondActivity.this);
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

