public class Tirelire {
    private float solde;
    private String nom;
    private static int nbTirelires = 0;

    /**
     * Constructeur
     *
     * @param nom du propriétaire
     */
    public Tirelire(String nom) {
        this.nom = nom;
        this.solde = 0;
        nbTirelires++;
    }

    /**
     * Supprime la tirelire du total de Tirelires
     */
    public void efface() {
        nbTirelires--;
    }

    /**
     * Permet de faire un dépot d'argent dans la tirelire
     *
     * @param montant à verser
     * @return le nouveau solde
     */
    public float depot(float montant) {
        solde += montant;
        return solde;
    }

    /**
     * Permet de faire un retrait d'argent dans la tirelire
     *
     * @param montant à retirer de la tirelire
     * @return le nouveau solde
     */
    public float retrait(float montant) {
        if (montant > solde) {
            System.out.println("Il n'y a pas assez d'argent dans la tirelire");
        } else {
            solde -= montant;
        }
        return solde;
    }

    /**
     * Affiche une description de la tirelire
     */
    public void affiche() {
        System.out.println("Dans la tirelire de " + nom + ", il y a " + solde + " euro" + (solde > 1 ? "s" : ""));
    }

    public float getSolde() {
        return solde;
    }

    public String getNom() {
        return nom;
    }

}
