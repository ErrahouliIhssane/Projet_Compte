package Github;


public class app {
    public static void main(String[] args) throws SoldeInsuffisantException {
        CompteEpargne ce = new CompteEpargne(1, 10000,3);
       CompteEpargne ce2 = new CompteEpargne(2, 20000,3);
        ce.envoyer(ce2,4000);

        System.out.println(ce.stringSolde());
        System.out.println(ce2.stringSolde());

    }
}
