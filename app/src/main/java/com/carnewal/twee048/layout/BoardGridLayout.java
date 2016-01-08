package com.carnewal.twee048.layout;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by Brecht on 8/01/2016.
 */
public class BoardGridLayout extends GridLayout {


    private static final int HOR = 4;
    private static final int VER = 4;


    private CardFrameLayout[][] cards;

    public BoardGridLayout(Context context) {
        super(context);
        createCards();
    }
    public BoardGridLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
       createCards();
    }
    public BoardGridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
       createCards();
    }


    private void initBoard() {

    }

    private void createCards() {
        this.cards = new CardFrameLayout[HOR][VER];
        for (int h = 0; h < HOR; h++) {
            for (int v = 0; v < VER; v++) {
                cards[h][v] = new CardFrameLayout(this.getContext());
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i("myTag", "onSizeChanged");
        super.onSizeChanged(w, h, oldw, oldh);
        int cardWith = (Math.min(w,h) - 10) / 4;
        addCards(cardWith, cardWith);
        startGame();
    }

    private void addCards(int cardWith, int cardHeight){
        for(int x = 0 ; x < 4 ; x++){
            for(int y = 0 ; y < 4 ; y++ ){
                cards[x][y].setLayoutParams(new ViewGroup.LayoutParams(cardWith, cardHeight));
                this.addView(cards[x][y]);
            }
        }
    }

    public void startGame(){
        setTestBoard();
        Log.i("myTag", "startGame");
    }

    private void setTestBoard(){
        for(int x = 0 ; x < 4 ; x++) {
            for (int y = 0; y < 4; y++) {
                cards[x][y].setValue(x*10+y);
            }
        }
    }

}
