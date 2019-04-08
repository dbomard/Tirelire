package Impl;

import Interfaces.Operation;
import Utils.OperationType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperationImpl implements Operation {
    private double montant;
    private Date date;
    private String note;
    private OperationType type;

    public OperationImpl(double montant, String note, OperationType type) {
        this.montant = montant;
        this.date = new Date();
        this.note = note;
        this.type = type;
    }

    public String getDescription() {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatDate.format(new Date());
        return ((type == OperationType.RETRAIT ? "Retrait " : "Versement ") + "de " + montant + " euro" + (montant > 1 ? "s" : "") + " le " + date + ". Note : " + note);
    }
}
