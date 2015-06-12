package com.trogdan.nanoportfolio;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private final View.OnClickListener defaultSnackbarListener = new View.OnClickListener() {
        public void onClick(View v) {
            //TODO
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View coordinatorLayoutView = findViewById(R.id.snackbarPosition);
        final Button[] buttons = {
                (Button) findViewById(R.id.spotifyButton),
                (Button) findViewById(R.id.scoresButton),
                (Button) findViewById(R.id.libraryButton),
                (Button) findViewById(R.id.biggerButton),
                (Button) findViewById(R.id.xyzButton),
                (Button) findViewById(R.id.capstoneButton)
        };

        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i].setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            Snackbar
                                    .make(coordinatorLayoutView, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                                    .setAction(R.string.snackbar_action_dismiss, defaultSnackbarListener)
                                    .setActionTextColor(getResources().getColor(R.color.amber_300))
                                    .show();
                        }
                    });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
