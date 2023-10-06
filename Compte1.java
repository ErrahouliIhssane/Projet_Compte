package Github;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public  abstract  class Compte1 {
    private int code;
    private float solde;
    private StatutDeCompte statut;
    private ArrayList<Operation> operations;

    private int c =0;


    public Compte1(int code, float solde, StatutDeCompte statut) {
        this.code = code;
        this.solde = solde;
        this.statut = statut;
        this.operations = new ArrayList<>();
    }
    // Getters et setters
    public ArrayList<Operation> getOperations() {
        return operations=new ArrayList<>();
    }

    public ArrayList<Operation> consulterOperations() {
        return operations;
    }
//    public void stringTransactions(){
//        for (Operation operation : operations) {
//            System.out.println(" " + operation.getNumero()+" "+operation.getDateoperation() +" "+ operation.getMontant());
//        }
//    }


    public void setSolde(float solde) {
        this.solde = solde;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public float getSolde() {
        return solde;
    }
    public StatutDeCompte getStatut() {
        return statut;
    }

    public void setStatut(StatutDeCompte statut) {
        this.statut = statut;
    }

        public void Verser(float montant) {
        if (montant > 0) {
            solde += montant;
            ++c;
            operations.add(new Versement(c,new Date(),montant));
        }
    }
//
//    public boolean Retrait(double montant) throws Exception {
//        if (montant > 0 && solde >= montant) {
//            solde -= montant;
//            operations.add(new Retrait(montant));
//            return true;
//        } else {
//            throw new Exception("Solde insuffisant pour le retrait.");
//        }
//    }

    public void Retrait(float montant) throws SoldeInsuffisantException {
        if (montant > 0 && solde >= montant) {

            solde -= montant;
            ++c;
            operations.add(new Retrait(c,new Date(),montant));
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour le retrait.");
        }
    }


    public void envoyer(Compte1 c ,float montant) throws SoldeInsuffisantException {
    if(montant<=getSolde())  {
       this.Retrait(montant);
        c.Verser(montant);
        }else {
        throw new SoldeInsuffisantException("Solde n'est pas verser.");
    }
    }
    public void afficherOperations(){
        for (Operation e:operations) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString() {
        return "Compte1{" +
                "code=" + code +
                ", statut=" + statut +
                ", operations=" + operations +
                '}';
    }
    public String stringSolde() {
        return ("solde=" + solde);
    }

    public double TotalVerser(){
        double total = 0.0;
        for (Operation operation : operations){
            if(operation instanceof Versement){
                total+= operation.getMontant();
            }
        }
        return total;
    }
    public double TotalRetrait(){
        double total = 0.0;
        for (Operation operation : operations){
            if(operation instanceof Retrait){
                total+= operation.getMontant();
            }
        }
        return total;
    }
    public void operationFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\MOBIL APP\\201 BASES DEV ANDROID\\compte\\app\\src\\main\\java\\Github\\File.txt",true))){
            for (Operation operat : operations){
                String OperationType = operat instanceof Retrait ? "retrait": "versement";
                String message = "operation de" + OperationType + "" +operat.getDateoperation() + "" + operat.getMontant()+ "compte" +this.getClass().getSimpleName();
                writer.write(message);
                writer.newLine();
            }
            System.out.println("fichiers et created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

