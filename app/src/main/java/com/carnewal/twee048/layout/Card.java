package com.carnewal.twee048.layout;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.carnewal.twee048.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brecht on 8/01/2016.
 */
public class Card extends FrameLayout {

    @Bind(R.id.tvValue)
    public TextView tvValue;

    private int value;


    public Card(Context context) {
        super(context);
        View cardTextView = inflate(this.getContext(), R.layout.card_framelayout, null);
        this.addView(cardTextView);
        ButterKnife.bind(this);
        setValue(0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int nr) {
        this.value = nr;
        if(this.value == 0) {
            tvValue.setText("");
        }else {
            tvValue.setText(""+value);
        }
        adjustColor(nr);
    }


    public boolean isEmpty() {
        return this.getValue() == 0;
    }




    private void adjustColor(int nr) {
        int color;

        if(nr >0 && nr < 2049) {
            color = getResources().getIdentifier("game_board_card_" + nr, "color", getContext().getPackageName());
        } else if (nr == 0) {
            color  = R.color.game_board_card_empty;
        } else {
            color = R.color.game_board_card_other;
        }


        tvValue.setBackgroundColor(getResources().getColor(color));

    }


}
