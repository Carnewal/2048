package com.carnewal.twee048.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.carnewal.twee048.R;
import com.carnewal.twee048.layout.Board;
import com.carnewal.twee048.listener.OnSwipeTouchListener;
import com.carnewal.twee048.util.Action;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brecht on 8/01/2016.
 */
public class PlayActivity extends AppCompatActivity {

    @Bind(R.id.board)
    public Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        board.setOnTouchListener(new OnSwipeTouchListener(board.getContext()){


            @Override
            public void onSwipeDown() {
                board.doAction(Action.DOWN);
            }

            @Override
            public void onSwipeLeft() { board.doAction(Action.LEFT);
            }

            @Override
            public void onSwipeRight() {
                board.doAction(Action.RIGHT);
            }

            @Override
            public void onSwipeUp() {
                board.doAction(Action.UP);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_play_menu_home) {
            this.finish();
            return true;
        } else if(id == R.id.action_play_menu_settings) {
            return true;
        } else if(id == R.id.action_play_menu_refresh) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.restart)
                    .setMessage(R.string.really_restart)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("Todo", "Restart");
                        }
                    })
                    .setNegativeButton(R.string.no, null)
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }


}
