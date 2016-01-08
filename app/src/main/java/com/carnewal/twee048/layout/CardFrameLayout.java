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
public class CardFrameLayout extends FrameLayout {

    @Bind(R.id.tvValue)
    public TextView tvValue;

    private int value;


    public CardFrameLayout(Context context) {
        super(context);
        View cardTextView = inflate(this.getContext(), R.layout.card_framelayout, null);
        this.addView(cardTextView);
        ButterKnife.bind(this);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int nr) {
        this.value = nr;
        tvValue.setText(""+value);
    }


}
