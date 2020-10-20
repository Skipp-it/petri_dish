package com.company.Util;

import java.util.Random;

public class RandomCoords {
    Random rand = new Random();

    public int randomNearbyPosition(int min, int max){
        return rand.nextInt(max-min+1)+min;
    }



}
