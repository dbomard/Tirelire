package Impl;

import Interfaces.Operation;
import Interfaces.Tirelire;

import java.util.ArrayList;

import static Utils.Util.CREDIT;
import static Utils.Util.RETRAIT;

public class TirelireImpl implements Tirelire {
    private double solde;
    private String owner;
    private ArrayList<Operation> operations;

    public TirelireImpl() {
        this.solde = 0;
        this.owner = "Inconnu";
        operations = new ArrayList<Operation>();
    }

    public TirelireImpl(String name) {
        this.solde = 0;
        this.owner = name;
        operations = new ArrayList<Operation>();
    }

    public TirelireImpl(String name, double solde) {
        this.solde = solde;
        this.owner = name;
        operations = new ArrayList<Operation>();
    }

    public double getSolde() {
        return solde;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void retirer(double montant, String note) {
        if (montant < 0) {
            System.out.println("Un retrait d'argent ne peut pas être négatif");
        } else if (montant > solde) {
            System.out.println("Il n'y a pas assez d'argent dans la tirelire");
        } else {
            solde -= montant;
            this.operations.add(new OperationImpl(montant, note, RETRAIT));
        }
    }

    @Override
    public void crediter(double montant, String note) {
        if (montant < 0) {
            System.out.println("Impossible de verser un montant négatif");
        } else {
            solde += montant;
            this.operations.add(new OperationImpl(montant, note, CREDIT));
        }
    }


    @Override
    public String description() {
        return ("Dans la tirelire de " + owner + ", il y a " + solde + " euro" + (solde > 0 ? "s" : ""));
    }

    @Override
    public void getOperationsList() {
        if (!operations.isEmpty()) {
            int i = 1;
            for (Operation op : operations) {
                System.out.println(i + " - " + op.getDescription());
                i++;
            }
        }
    }
}
