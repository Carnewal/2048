package com.carnewal.twee048.util;

import com.carnewal.twee048.layout.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

/**
 * Created by Brecht on 11/01/2016.
 */
public class GameUtils<T> {















    /**
     *
     * [ [1,2]
     *   [3,4] ]
     *
     *   becomes
     *
     * [ [3,1]
     *   [4,2] ]
     *
     *
     * @param array
     * @return
     */
    public static Card[][] transpose (Card[][] array) {
        if (array == null || array.length == 0)//empty or unset array, nothing do to here
            return array;

        int width = array.length;
        int height = array[0].length;

        Card[][] array_new = new Card[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                array_new[y][x] = array[x][y];
            }
        }
        return array_new;
    }

    /**
     *
     * [1,2,3,4]
     * becomes
     * [4,3,2,1]
     *
     * @param array
     * @return
     */
    public static Card[] reverse(Card[] array) {
        Card[] newArr = new Card[array.length];
        for(int i = 0; i < newArr.length; i++) {
            newArr[newArr.length - 1 - i] = array[i];
        }
        return newArr;
    }


    /**
     *
     * Om een random vak te kiezen
     *
     * @param matrix
     * @return
     */
    public static List<Card> shuffle(Card[][] matrix) {

        ArrayList<Card> cards = new ArrayList<>();

        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                cards.add(matrix[i][j]);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }


}
