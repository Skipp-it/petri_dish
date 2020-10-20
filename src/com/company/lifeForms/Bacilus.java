package com.company.lifeForms;

public class Bacilus extends Bacteria{



    public Bacilus(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        setLIFE_SPAN(10);
        setNEARBY(3);
    }


    @Override
    public boolean bacteriaDies() {
        if (getLife()>=getLIFE_SPAN()){
            return true;
        }
        return false;
    }
}
