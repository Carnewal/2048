package com.carnewal.twee048;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.btnAbout)
    private Button btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_table);
        ButterKnife.bind(this);


        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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




    public void actionContinue(View v) {
        Toast.makeText(this, "Continue?", Toast.LENGTH_SHORT).show();
    }
    public void actionNewGame(View v) {
        Toast.makeText(this, "Continue?",Toast.LENGTH_SHORT).show();

    }
    public void actionAbout(View v) {
        Toast.makeText(this, "Continue?" ,Toast.LENGTH_SHORT).show();

    }
    public void actionExit(View v) {
        Toast.makeText(this, "Continue?", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(WelcomeActivity.this)
                .setTitle(R.string.welcome_about)
                .setMessage(R.string.about_text)
                .show();
    }


}
