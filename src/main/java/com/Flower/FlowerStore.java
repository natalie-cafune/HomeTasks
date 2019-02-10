package com.Flower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class FlowerStore {

    int purse ;
    ArrayList flowers;

    public ArrayList<String> sell(int c, int r, int t) {

        String [] strings = new String[(c + r + t)];

        Chamomile [] chamomile = new Chamomile[c];
        for (int i = 0; i < c; i++) {
            chamomile[i] = new Chamomile();
            strings[i] = chamomile[i].getName();
        }

        Rose [] roses = new Rose[r];
        for (int i = 0; i < r; i++) {
        roses [i] = new Rose();
        strings[c + i] = roses[i].getName();

        }

        Tulip [] tulips = new Tulip[t];
        for (int i = 0; i < t; i++) {
            tulips[i] = new Tulip();
            strings [(c+r) + i ] = tulips[i].getName();
        }

        flowers = new ArrayList(Arrays.asList(strings));
        return flowers;
    }

    // кошелек магазина
    public int purseCheck (int c, int r, int t){
        return purse = (c* 70) + (r * 100) + (t * 45);
    }

    // перемешивает цветы
    public ArrayList <String> sellSequence (int c, int r, int t){

        String [] strings = new String[(c + r + t)];


        Chamomile [] chamomile = new Chamomile[c];
        for (int i = 0; i < c; i++) {
            chamomile[i] = new Chamomile();
            strings[i] = chamomile[i].getName();
        }

        Rose [] roses = new Rose[r];
        for (int i = 0; i < r; i++) {
            roses [i] = new Rose();
            strings[c + i] = roses[i].getName();

        }

        Tulip [] tulips = new Tulip[t];
        for (int i = 0; i < t; i++) {
            tulips[i] = new Tulip();
            strings [(c+r) + i ] = tulips[i].getName();
        }
        Random random = new Random();

        flowers = new ArrayList(Arrays.asList(strings));
        Collections.shuffle(flowers, random);
        return flowers;
    }
}