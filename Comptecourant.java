package Github;

import java.util.Date;

public class Comptecourant extends Compte1 {
    private double decouvert;


   public Comptecourant(int code,float solde, double decouvert, StatutDeCompte c){
       super(code, solde,c);
       this.decouvert = decouvert;
   }
    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public double getSolde() {
        return super.getSolde();
    }

    public boolean effectuerRetrait(double montant) throws SoldeInsuffisantException {
        if (montant > 0 && (getSolde() - montant) >= -decouvert) {
//            setSolde(getSolde()-montant);
            int n=0;
            getOperations().add(new Retrait(n++,new Date(),montant));
            return true;
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour le retrait.");
        }
    }
    public  void Retrait(float montant) throws SoldeInsuffisantException{
       if(montant > getSolde()+getDecouvert()) throw new SoldeInsuffisantException("er");
       float mt=getSolde()-montant;
       setSolde();
    }

    public void Versement(Comptecourant compteCourant2, int i, int i1) {
    }
}

