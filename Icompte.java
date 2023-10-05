package Github;

import java.util.ArrayList;
import java.util.List;

public interface Icompte {
    void Retrait(float montant);
    void Verser(float montant);
    double Solde();
    ArrayList<Operation> listOperation();

}
