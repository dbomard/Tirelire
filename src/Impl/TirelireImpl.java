package Impl;

import Interfaces.Operation;
import Interfaces.Tirelire;

import java.util.ArrayList;

import static Utils.Util.CREDIT;
import static Utils.Util.RETRAIT;

public class TirelireImpl implements Tirelire {
    private float solde;
    private String owner;
    private ArrayList<Operation> operations;

    public TirelireImpl() {
        this.solde = 0;
        this.owner = "Inconnu";
    }

    public TirelireImpl(String name) {
        this.solde = 0;
        this.owner = name;
    }

    public TirelireImpl(String name, float solde) {
        this.solde = solde;
        this.owner = name;
    }

    public float getSolde() {
        return solde;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void retirer(float montant) {
        if (montant > solde)
            System.out.println("Il n'y a pas assez d'argent dans la tirelire");
        else {
            solde -= montant;
            this.operations.add(new OperationImpl(montant, "C'est un retrait", RETRAIT));
        }
    }

    @Override
    public void crediter(float montant) {
        solde += montant;
        this.operations.add(new OperationImpl(montant, "C'est un crédit", CREDIT));
    }

    @Override
    public String description() {
        return ("Dans la tirelire de " + owner + ", il y a " + solde + " euros");
    }
}
