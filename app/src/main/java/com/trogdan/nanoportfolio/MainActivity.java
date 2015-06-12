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

    //Will not change, but Android doesn't instantiate much of the object until onCreate, so no final
    private View coordinatorLayoutView;
    private Button[] buttons;
    private int[] text_ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayoutView = findViewById(R.id.snackbarPosition);
        buttons = new Button[]{
                (Button) findViewById(R.id.spotifyButton),
                (Button) findViewById(R.id.scoresButton),
                (Button) findViewById(R.id.libraryButton),
                (Button) findViewById(R.id.biggerButton),
                (Button) findViewById(R.id.xyzButton),
                (Button) findViewById(R.id.capstoneButton)
        };

        text_ids = new int[]{
                R.string.snackbar_spotify_text,
                R.string.snackbar_scores_text,
                R.string.snackbar_library_text,
                R.string.snackbar_bigger_text,
                R.string.snackbar_xyz_text,
                R.string.snackbar_capstone_text,
        };

        for(int i = 0; i < buttons.length; i++)
        {
            final int index = i;
            buttons[index].setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            Snackbar
                                    .make(coordinatorLayoutView, text_ids[index], Snackbar.LENGTH_LONG)
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
