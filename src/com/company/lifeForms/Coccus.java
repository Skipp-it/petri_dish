package com.company.lifeForms;

public class Coccus extends Bacteria {

    public Coccus(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        setLIFE_SPAN(100);
        setNEARBY(1);
    }

    @Override
    public boolean bacteriaDies() {
        if (getLife()>=getLIFE_SPAN()){
            return true;
        }
        return false;
    }
}

