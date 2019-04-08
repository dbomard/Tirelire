package Interfaces;

public interface Tirelire {

    void retirer(double montant, String note);

    void crediter(double montant, String note);

    String description();

    void getOperationsList();
}
