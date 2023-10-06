package Github;

import java.util.Date;

public class Operation {
    private int numero;
    private Date  dateoperation;
    protected double montant;


    public Operation(int numero,Date dateoperation,double montant) {
        this.montant = montant;
        this.numero=numero;
        this.dateoperation=dateoperation;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDateoperation() {
        return dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Compte1{" +
                "code=" + numero +
                ", date=" + dateoperation  +
                ", montant =" + montant +
                '}';
    }

}

