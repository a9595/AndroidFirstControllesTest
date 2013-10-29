package com.example5.myapplication5;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    Button b1;
    SeekBar mySeekBar;
    EditText textName;
    TextView textViewSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();


            textName = (EditText) findViewById(R.id.textName);
            textViewSeekBar = (TextView) findViewById(R.id.textViewSeekBar);
            b1 = (Button) findViewById(R.id.b1);
            b1.setOnClickListener(myhandler21);

            //seekBar fuckkk
            mySeekBar = ((SeekBar) findViewById(R.id.mySeekBar));
            mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                   textViewSeekBar.setText(Integer.toString(progress));
                }
            });


        }
    }

    View.OnClickListener myhandler21 = new View.OnClickListener() {
        public void onClick(View v) {

            String result = "Hello, " + textName.getText().toString();
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Packing List");
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
