package com.carnewal.twee048.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.carnewal.twee048.R;
import com.carnewal.twee048.layout.BoardGridLayout;
import com.carnewal.twee048.listener.OnSwipeTouchListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brecht on 8/01/2016.
 */
public class PlayActivity extends AppCompatActivity {

    @Bind(R.id.board)
    public BoardGridLayout board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        board.setOnTouchListener(new OnSwipeTouchListener(board.getContext()){


            @Override
            public void onSwipeDown() {
                Log.i("myTag", "swiped down!");
            }

            @Override
            public void onSwipeLeft() {
                Log.i("myTag", "swiped left!");
            }

            @Override
            public void onSwipeRight() {
                Log.i("myTag", "swiped right!");
            }

            @Override
            public void onSwipeUp() {
                Log.i("myTag", "swiped up!");
            }
        });


    }
}
