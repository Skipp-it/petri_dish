package com.company;

import com.company.lifeForms.Bacilus;
import com.company.lifeForms.Bacteria;
import com.company.lifeForms.Coccus;
import com.company.lifeForms.Spirillum;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int timeLimit=2000;
        int tick=0;
        PetriDish petriDish = new PetriDish();

        Bacilus bacilus = new Bacilus(3,5);
        petriDish.addToPetriDish(bacilus);

        Coccus coccus = new Coccus(2,4);
        petriDish.addToPetriDish(coccus);

        Spirillum spirillum = new Spirillum(3,2);
        petriDish.addToPetriDish(spirillum);


        while (timeLimit>tick){
            tick ++;
            for (Bacteria bacteria: petriDish.getBacteriaList()) {
                bacteria.setLife(tick);
            }
            petriDish.getLifeInPetriDish();
//            System.out.println(petriDish.toString());
            Thread.sleep(1000);
        }

    }
}
