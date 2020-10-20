package com.company;

import com.company.Util.RandomCoords;
import com.company.lifeForms.Bacilus;
import com.company.lifeForms.Bacteria;
import com.company.lifeForms.Coccus;
import com.company.lifeForms.Spirillum;


import java.util.ArrayList;
import java.util.List;

public class PetriDish {
    private List<Bacteria> bacteriaList;


    public PetriDish() {
        this.bacteriaList = new ArrayList<>();
    }

    public void addToPetriDish(Bacteria bacteria) {
        bacteriaList.add(bacteria);
    }

    public List<Bacteria> getBacteriaList() {
        return bacteriaList;
    }

    public void getLifeInPetriDish() {
        int nearbyBacteria = 0;
        for (Bacteria bacteria1 : bacteriaList) {
            if (bacteria1 instanceof Bacilus) {
                if (!bacteria1.bacteriaDies()) {
                    for (Bacteria bacteria2 : bacteriaList) {
                        if (bacteria2 instanceof Coccus || !bacteria1.bacteriaDies()) {
                            bacteria1.isNearby(bacteria2.getxPosition(), bacteria2.getyPosition());
                            System.out.println("Bacilul are un Coc nearby");
                        } else {
                            bacilusDieAndSplit(bacteria1);
                        }
                    }
                } else {
                    bacilusDieAndSplit(bacteria1);
                }
            }
            if (bacteria1 instanceof Coccus) {
                if (!bacteria1.bacteriaDies()) {
                    for (Bacteria bacteria3 : bacteriaList) {
                        if (!(bacteria3 instanceof Coccus) && bacteria1.isNearby(bacteria3.getxPosition(), bacteria3.getyPosition())) {
                            nearbyBacteria++;
                        }
                    }
                    if (!(nearbyBacteria >= 2)) {
                        coccusDieAndSplit(bacteria1);
                    }
                } else {
                    coccusDieAndSplit(bacteria1);
                }
            }
            if (bacteria1 instanceof Spirillum) {
                if (!bacteria1.bacteriaDies()) {
                    for (Bacteria bacteria4 : bacteriaList) {
                        if (!(bacteria1.isNearby(bacteria4.getxPosition(), bacteria4.getyPosition()))) {
                            spirillumDieAndSplit(bacteria1);
                        }
                    }
                } else {
                    spirillumDieAndSplit(bacteria1);
                }
            }
        }
    }

    private void spirillumDieAndSplit(Bacteria bacteria1) {
        bacteriaList.remove(bacteria1);
        bacteriaList.add(
                new Spirillum(new RandomCoords().randomNearbyPosition(bacteria1.getxPosition()-bacteria1.getNEARBY(), bacteria1.getxPosition()+bacteria1.getNEARBY()),new RandomCoords().randomNearbyPosition(bacteria1.getyPosition()-bacteria1.getNEARBY(), bacteria1.getyPosition()+bacteria1.getNEARBY())));
        bacteriaList.add(
                new Spirillum(new RandomCoords().randomNearbyPosition(bacteria1.getxPosition()-bacteria1.getNEARBY(), bacteria1.getxPosition()+bacteria1.getNEARBY()),new RandomCoords().randomNearbyPosition(bacteria1.getyPosition()-bacteria1.getNEARBY(), bacteria1.getyPosition()+bacteria1.getNEARBY())));

        System.out.println("a murit Spirillum si au mai aparut 2" + toString());
    }

    private void coccusDieAndSplit(Bacteria bacteria1) {
        bacteriaList.remove(bacteria1);
        bacteriaList.add(new Coccus(new RandomCoords().randomNearbyPosition(bacteria1.getxPosition()-bacteria1.getNEARBY(), bacteria1.getxPosition()+bacteria1.getNEARBY()),new RandomCoords().randomNearbyPosition(bacteria1.getyPosition()-bacteria1.getNEARBY(), bacteria1.getyPosition()+bacteria1.getNEARBY())));

        bacteriaList.add(new Coccus(new RandomCoords().randomNearbyPosition(bacteria1.getxPosition()-bacteria1.getNEARBY(), bacteria1.getxPosition()+bacteria1.getNEARBY()),new RandomCoords().randomNearbyPosition(bacteria1.getyPosition()-bacteria1.getNEARBY(), bacteria1.getyPosition()+bacteria1.getNEARBY())));

        System.out.println("a murit Coccus si au mai aparut 2" + toString());
    }

    private void bacilusDieAndSplit(Bacteria bacteria1) {
        bacteriaList.remove(bacteria1);
        bacteriaList.add(new Bacilus(new RandomCoords().randomNearbyPosition(bacteria1.getxPosition()-bacteria1.getNEARBY(), bacteria1.getxPosition()+bacteria1.getNEARBY()),new RandomCoords().randomNearbyPosition(bacteria1.getyPosition()-bacteria1.getNEARBY(), bacteria1.getyPosition()+bacteria1.getNEARBY())));

        bacteriaList.add(new Bacilus(new RandomCoords().randomNearbyPosition(bacteria1.getxPosition()-bacteria1.getNEARBY(), bacteria1.getxPosition()+bacteria1.getNEARBY()),new RandomCoords().randomNearbyPosition(bacteria1.getyPosition()-bacteria1.getNEARBY(), bacteria1.getyPosition()+bacteria1.getNEARBY())));

        System.out.println("a murit Bacilul si au mai aparut 2" + toString());
    }

    @Override
    public String toString() {
        return "PetriDish{" +
                "bacteriaList=" + bacteriaList +
                '}';
    }
}
