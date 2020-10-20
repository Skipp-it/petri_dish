package com.company.lifeForms;

public abstract class Bacteria {

    private int life;
    private int LIFE_SPAN;
    private int NEARBY;
    private int xPosition;
    private int yPosition;

    public Bacteria(int xPosition, int yPosition) {
        this.LIFE_SPAN = getLIFE_SPAN();
        this.NEARBY = getNEARBY();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getLIFE_SPAN() {
        return LIFE_SPAN;
    }

    public int getNEARBY() {
        return NEARBY;
    }

    protected void setLIFE_SPAN(int LIFE_SPAN) {
        this.LIFE_SPAN = LIFE_SPAN;
    }

    protected void setNEARBY(int NEARBY) {
        this.NEARBY = NEARBY;
    }

    public boolean isNearby(int xPosition, int yPosition) {
        if (((this.xPosition + NEARBY < xPosition) || (this.xPosition - NEARBY > xPosition)) && ((this.yPosition + NEARBY < yPosition) || (this.yPosition - NEARBY > yPosition))) {
            return true;
        }
        return false;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setLife(int timePulse) {
        life++;
    }

    public int getLife() {
        return life;
    }

    public boolean checkLifeSpan() {
        if (this.life < this.LIFE_SPAN) {
            return true;
        }
        return false;
    }

    public abstract boolean bacteriaDies();

    @Override
    public String toString() {
        return "Bacteria{" +
                "life=" + life +
                ", LIFE_SPAN=" + LIFE_SPAN +
                ", NEARBY=" + NEARBY +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
