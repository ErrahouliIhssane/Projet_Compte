package Github;


public class app {
    public static void main(String[] args) throws SoldeInsuffisantException {
        CompteEpargne ce = new CompteEpargne(1, 10000,3);
       CompteEpargne ce2 = new CompteEpargne(2, 20000,3);
       Comptecourant c2=new Comptecourant(4,100,1000,StatutDeCompte.CREATED);
//        ce.envoyer(ce2,4000);
//        ce.Verser(300);
//        ce.Verser(400);
//        ce.Retrait(500);
//        ce.afficherOperations();
//        ce.getOperations();
//        System.out.println(ce.stringSolde());
//        System.out.println(ce2.stringSolde());

        System.out.println(c2.stringSolde());

        c2.Retrait(500);
        System.out.println(c2.stringSolde());


    }
}
