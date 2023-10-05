package Github;

import java.util.Date;

public class CompteEpargne extends Compte1 {
    private double taux;

    public CompteEpargne(int code, float solde, double taux) {
        super(code, solde, StatutDeCompte.CREATED);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public double getSolde() {
        return super.getSolde();
    }

    public void lesInterets() {
        double interets = super.getSolde() * (1+taux/100);
//        setSolde(getSolde() + interets);
        int n=0;
        getOperations().add(new Versement(n++,new Date(),interets));
    }

    public void envoyer(CompteEpargne ce2, int i, int i1) {
    }
}


