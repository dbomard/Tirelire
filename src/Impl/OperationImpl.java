package Impl;

import Interfaces.Operation;

import java.util.Date;

import static Utils.Util.RETRAIT;

public class OperationImpl implements Operation {
    private float montant;
    private Date date;
    private String note;
    private int type;

    public OperationImpl(float montant, String note, int type) {
        this.montant = montant;
        this.date = new Date();
        this.note = note;
        this.type = type;
    }

    public String getDescription() {
        return ((type == RETRAIT ? "Retrait" : "Versement") + "de " + montant + "euros le " + date.toString() + ". Note : " + note);
    }
}
