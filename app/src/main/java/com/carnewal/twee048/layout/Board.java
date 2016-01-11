package com.carnewal.twee048.layout;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.carnewal.twee048.util.Action;
import com.carnewal.twee048.util.GameUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Brecht on 8/01/2016.
 */
public class Board extends GridLayout implements Serializable {


    private static final int HOR = 4;
    private static final int VER = 4;


    private Card[][] cards;


    public Board(Context context) {
        super(context);
        createCardLayouts();
    }

    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
        createCardLayouts();
    }

    public Board(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        createCardLayouts();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i("myTag", "onSizeChanged");
        super.onSizeChanged(w, h, oldw, oldh);
        int cardWith = (Math.min(w, h) - 10) / 4;
        addCards(cardWith, cardWith);
        startGame();
    }



    private void createCardLayouts() {
        this.cards = new Card[HOR][VER];
        for (int h = 0; h < HOR; h++) {
            for (int v = 0; v < VER; v++) {
                cards[h][v] = new Card(this.getContext());
            }
        }
    }

    private void addCards(int cardWith, int cardHeight) {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                cards[x][y].setLayoutParams(new ViewGroup.LayoutParams(cardWith, cardHeight));
                this.addView(cards[x][y]);
            }
        }
    }

    public void startGame() {
        addRandomTiles(2);
    }

    private void addRandomTiles(int amount) {
        List<Card> list = GameUtils.shuffle(cards);

        ArrayList<Card> empties = new ArrayList<>();


        for (Card c : list) {
            if (c.isEmpty()) {
                empties.add(c);
            }
            if (empties.size() == amount) {
                break;
            }
        }

        if (amount > empties.size()) {
            Log.i("Not enough space", "");
            return;
        }

        for (Card c : empties) {
            c.setValue(2);
        }
    }

    public void merge(Card[] ar) {
        for (int i = ar.length - 1; i >= 1; i--) {
            Card me = ar[i];
            if(me.getValue() == 0) continue;

            Card him = ar[i - 1];

            //We can merge
            if (me.getValue() == him.getValue()) {
                Log.i("Merge", "Merging");
                me.setValue(me.getValue() * 2);
                him.setValue(0);
            }
        }
    }

    /**
     * Slide over empty spots
     *
     * @param ar
     */
    private void slide(Card[] ar) {

        HashMap<Card, Boolean> emptyMap = new HashMap<>();

        //loop all
        for (int i = ar.length - 1; i >= 0; i--) {

            if (i - 1 < 0) {
                continue;
            }

            if(ar[i].getValue() == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    ar[j+1].setValue(ar[j].getValue());
                    ar[j].setValue(0);
                }
            } else {

            }
/*
            for (int j = i - 1; j >= 0; j--) {

                if(ar[j].getValue() != 0) {
                    break;
                }

                if(i - 1 == j)


                /*
                if (ar[j].getValue() == 0 || i-1 == j) {

                    continue;
                } else {

                    Card me = ar[i-1];
                    Card him = ar[j];
                    ar[i-1].setValue(ar[j].getValue());
                    ar[j].setValue(0);
                    break;
                }
            }
*/
        }
    }

    private void work(Card[] ar) {

        slide(ar);
        merge(ar);
        slide(ar);

    }

    public void doAction(SharedPreferences p, Action action) {

        Card[][] board = cards.clone();

        if (action == Action.UP) {
            board = GameUtils.transpose(board);
        } else if (action == Action.DOWN) {
            board = GameUtils.transpose(board);
        }

        for (int i = 0; i < board.length; i++) {
            if (action == Action.LEFT || action == Action.UP) {
                board[i] = GameUtils.reverse(board[i]);
            }
            work(board[i]);
        }


        addRandomTiles(1);

        save(p);
    }


    private void save(SharedPreferences p) {
        String output = this.toString();

        SharedPreferences.Editor editor = p.edit();
        editor.putString("save", this.toString());
        editor.commit();
    }

    public void reset() {
       for(int i = 0; i< cards.length; i++) {
           for (int j = 0; j < cards[0].length; j++) {
               cards[i][j].setValue(0);
           }
       }
        addRandomTiles(2);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i< cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                s+= cards[i][j].getValue();
                s+=",";
            }
            s = s.substring(0, s.length()-1); //remove last comma
            s +="/";
        }
        s = s.substring(0, s.length()-1); //remove last slash
        return s;
    }

    public void fill(String s) {
        String[] rows = s.split("/");
        for(int i = 0; i < rows.length;i++) {
            String[] vals = rows[i].split(",");
            for(int j = 0; j < vals.length; j++){
                cards[i][j].setValue(Integer.parseInt(vals[j]));
            }
        }
    }

    public int[][] retreive() {
        int[][] seed = new int[cards.length][cards[0].length];
        for(int i = 0; i< cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
               seed[i][j] = cards[i][j].getValue();
            }
        }
        return seed;
    }

    public void fill(int[][] seed) {
        for(int i = 0; i< cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                cards[i][j].setValue(seed[i][j]);
            }
        }
    }



}
