package Impl;

import Interfaces.Menu;

import java.util.ArrayList;

public class MenuAccueilImpl extends MenuImpl {

    @Override
    public int affiche() {
        System.out.println("1 - Consulter une tirelire");
        System.out.println("2 - Ouvrir une tirelire");
        System.out.println("\nFaites votre choix");
        return super.TraiterInputs(2);
    }
}
