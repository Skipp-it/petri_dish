package com.company.lifeForms;

public class Spirillum extends Bacteria{

    public Spirillum(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        setLIFE_SPAN(40);
        setNEARBY(2);
    }

    @Override
    public boolean bacteriaDies() {
        if (getLife()>=getLIFE_SPAN()){
            return true;
        }
        return false;
    }
}
