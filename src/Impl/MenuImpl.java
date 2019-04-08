package Impl;

import Interfaces.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuImpl implements Menu {

    @Override
    public int affiche() {
        return 0;
    }

    @Override
    public int TraiterInputs(int nbItems) {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        boolean responseIsGood = false;
        try {
            choix = sc.nextInt();
            responseIsGood = (choix >= 1 && choix <= nbItems);
        } catch (InputMismatchException e) {
            sc.next();
        }
        if (!responseIsGood)
            return 0;
        else
            return choix;
    }
}
