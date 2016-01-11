package com.carnewal.twee048.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.carnewal.twee048.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_table);
        ButterKnife.bind(this);



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




    @OnClick(R.id.btnContinue)
    public void actionContinue(View v) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("new", false);
        startActivity(intent);
    }
    @OnClick(R.id.btnNewGame)
    public void actionNewGame(View v) {

        final WelcomeActivity me = this;

        new android.support.v7.app.AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.restart)
                .setMessage(R.string.really_restart)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(me, PlayActivity.class);
                        intent.putExtra("new", true);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();


    }

    @OnClick(R.id.btnAbout)
    public void actionAbout(View v) {
        new AlertDialog.Builder(WelcomeActivity.this)
                .setTitle(R.string.welcome_about)
                .setMessage(R.string.about_text)
                .show();
    }
    @OnClick(R.id.btnExit)
    public void actionExit(View v) {
        this.finish();
    }



}
