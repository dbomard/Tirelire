package Interfaces;

public interface Tirelire {

    public void retirer(double montant, String note);

    public void crediter(double montant, String note);

    public String description();

    public void getOperationsList();
}
