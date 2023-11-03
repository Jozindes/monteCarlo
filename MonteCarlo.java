
import java.util.Observable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jožko
 */
public class MonteCarlo extends Observable {
    
    private final ISimulacia simulacia;
    private final int pocetReplikacii;
    private boolean beh;
    
    public MonteCarlo(int paPocetReplikacii, ISimulacia paSimulacia) {
        this.pocetReplikacii = paPocetReplikacii;
        this.beh = true;
        this.simulacia = paSimulacia;
    }
    
    public void simulacia() {
        this.simulacia.predSimulaciou();
        for (int i = 0; i < this.pocetReplikacii; i++) {
            if (this.beh == true) {
                this.simulacia.replikacia();
                setChanged();
                notifyObservers(this.simulacia);
            } else {
                break;
            }
        }
        //this.simulacia.poSimulacii();
    }
    
    public ISimulacia dajSimulaciu() {
        return this.simulacia;
    }
    
    public void zmenaBehu(boolean paBeh) {
        this.beh = paBeh;
    }
}
