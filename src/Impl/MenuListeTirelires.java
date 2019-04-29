package Impl;

import Interfaces.Menu;

import java.util.ArrayList;

public class MenuListeTirelires extends MenuImpl {

    public int affiche(ArrayList<TirelireImpl> tirelires) {
        int nbItems = tirelires.size();
        if (nbItems == 0)
            return 0;
        for (int i = 0; i < tirelires.size(); i++) {
            System.out.println((i + 1) + " - Tirelire de " + tirelires.get(i).getOwner());
        }
        return super.TraiterInputs(nbItems);
    }
}
