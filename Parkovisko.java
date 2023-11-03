
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jožko
 */
public class Parkovisko implements ISimulacia {
    
    private MonteCarlo mc = null;
    private int aktualnaReplikacia;
    
    // statisticke premenne
    private double celkovaUspesnostPrvaTaktika;
    private double celkovaUspesnostDruhaTaktika;
    private double celkovaUspesnostTretiaTaktika;
    private int[] pocetnostPrvaTaktika;
    private int[] pocetnostDruhaTaktika;
    private int[] pocetnostTretiaTaktika;
    
    // obsadenost parkoviska
    private final int velkostParkoviska;
    private boolean[] obsadenostParkovacichMiest;
    private ArrayList<Integer> volneParkovacieMiesta;
    
    // generatory
    private Random generatorNasad;
    private Random generatorPoctuZaparkovanychAut;
    private Random[] poleGeneratorovKamZaparkovat;
    
    /*
    private Random generatorPrejdenychMiest2;
    private Random generatorPrejdenychMiest3;
    */
    
    public Parkovisko(int paVelkostParkoviska) {
        this.velkostParkoviska = paVelkostParkoviska;    
        this.obsadenostParkovacichMiest = new boolean[this.velkostParkoviska];
        
        for (int i = 0; i < this.velkostParkoviska; i++) {
            this.obsadenostParkovacichMiest[i] = false;
        }      
        
       
        
        // generatory pre prejdenie minimalneho poctu miest
        /*
        this.generatorPrejdenychMiest2 = new Random(this.generatorNasad.nextInt());
        this.generatorPrejdenychMiest3 = new Random(this.generatorNasad.nextInt());
        */
    }
    
    private int generatorPoctuZaparkovanychAutSample() {
        return this.generatorPoctuZaparkovanychAut.nextInt(this.velkostParkoviska + 1);
    }
    
    private int generatorKamZaparkovatSample() {
        return this.poleGeneratorovKamZaparkovat[this.volneParkovacieMiesta.size() - 1].nextInt(this.volneParkovacieMiesta.size());
    }
    
    private void vynulujParkovisko() {       
        this.volneParkovacieMiesta = new ArrayList<>();
        for (int i = 0; i < this.velkostParkoviska; i++) {
            this.volneParkovacieMiesta.add(i);
        }
        for (int i = 0; i < this.obsadenostParkovacichMiest.length; i++) {
            this.obsadenostParkovacichMiest[i] = false;
        }
    }
    
    private void obsadParkovacieMiestaAutami() {       
        this.vynulujParkovisko();
        
        int kolkoAutPrislo = this.generatorPoctuZaparkovanychAutSample();
        
        for (int i = 0; i < kolkoAutPrislo; i++) {
            int ktoreOdstranujem = this.generatorKamZaparkovatSample();
            int jehoHodnota = this.volneParkovacieMiesta.remove(ktoreOdstranujem);
            this.obsadenostParkovacichMiest[jehoHodnota] = true;
        }
    }
    
    @Override
    public void replikacia() {             
        
        this.obsadParkovacieMiestaAutami();     
        this.aktualnaReplikacia = this.aktualnaReplikacia + 1;
        
        // 1. taktika
        int kdeZaparkujem = 3 * this.velkostParkoviska;
        int zaciatok = this.obsadenostParkovacichMiest.length - 1;
        
        for (int j = zaciatok; j >= 0; j--) {
            if (this.obsadenostParkovacichMiest[j] == false) {
                if (j != 2 && j != 5 && j != 8) {
                    kdeZaparkujem = j + 1;
                    break;
                }
            }
        }
        this.celkovaUspesnostPrvaTaktika = this.celkovaUspesnostPrvaTaktika + kdeZaparkujem;
        if (kdeZaparkujem < this.velkostParkoviska + 1) {
            this.pocetnostPrvaTaktika[kdeZaparkujem - 1]++;
        } else {
            this.pocetnostPrvaTaktika[this.velkostParkoviska]++;
        }
        
        // 2. taktika
        kdeZaparkujem = 3 * this.velkostParkoviska;
        
        int prejdemMinimalne = 2 * this.velkostParkoviska / 3;
        
        zaciatok = this.velkostParkoviska - prejdemMinimalne - 1;
        
        for (int j = zaciatok; j >= 0; j--) {
            if (this.obsadenostParkovacichMiest[j] == false) {
                if (j != 2 && j != 5 && j != 8) {
                    kdeZaparkujem = j + 1;
                    break;
                }
            }
        }
        
        this.celkovaUspesnostDruhaTaktika = this.celkovaUspesnostDruhaTaktika + kdeZaparkujem;
        if (kdeZaparkujem < this.velkostParkoviska + 1) {
            this.pocetnostDruhaTaktika[kdeZaparkujem - 1]++;
        } else {
            this.pocetnostDruhaTaktika[this.velkostParkoviska]++;
        }
        
        // 3. taktika
        kdeZaparkujem = 3 * this.velkostParkoviska;
        
        if (this.velkostParkoviska % 2 == 0) {
            prejdemMinimalne = this.velkostParkoviska / 2;
        } else {
            prejdemMinimalne = this.velkostParkoviska / 2 + 1;
        }
        
        zaciatok = this.velkostParkoviska - prejdemMinimalne - 1;
        
        for (int j = zaciatok; j >= 0; j--) {
            if (this.obsadenostParkovacichMiest[j] == false) {
                if (j != 2 && j != 5 && j != 8) {
                    kdeZaparkujem = j + 1;
                    break;
                }
            }
        }
        
        this.celkovaUspesnostTretiaTaktika = this.celkovaUspesnostTretiaTaktika + kdeZaparkujem;
        if (kdeZaparkujem < this.velkostParkoviska + 1) {
            this.pocetnostTretiaTaktika[kdeZaparkujem - 1]++;
        } else {
            this.pocetnostTretiaTaktika[this.velkostParkoviska]++;
        }
    }

    @Override
    public void predSimulaciou() {
        
        // generator nasad pre ostatne generatory
        this.generatorNasad = new Random();
                       
        // generator pre pocet zaparkovanych aut na parkovisku
        this.generatorPoctuZaparkovanychAut = new Random(this.generatorNasad.nextInt());
        
        // generatory pre vyberanie volnych parkovacich miest
        this.poleGeneratorovKamZaparkovat = new Random[this.velkostParkoviska];
        for (int i = 0; i < this.velkostParkoviska; i++) {
            this.poleGeneratorovKamZaparkovat[i] = new Random(this.generatorNasad.nextInt());
        }
        
        this.aktualnaReplikacia = 0;
        
        this.celkovaUspesnostPrvaTaktika = 0;
        this.celkovaUspesnostDruhaTaktika = 0;
        this.celkovaUspesnostTretiaTaktika = 0;
        this.pocetnostPrvaTaktika = new int[this.velkostParkoviska + 1];
        this.pocetnostDruhaTaktika = new int[this.velkostParkoviska + 1];
        this.pocetnostTretiaTaktika = new int[this.velkostParkoviska + 1];
    }

    @Override
    public void poSimulacii() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*
    private int pocetPrejdenychMiest2Sample() {
        return this.generatorPrejdenychMiest2.nextInt(2 * this.velkostParkoviska / 3, this.velkostParkoviska + 1);
    }
    
    private int pocetPrejdenychMiest3Sample() {
        return this.generatorPrejdenychMiest3.nextInt(this.velkostParkoviska / 2, this.velkostParkoviska + 1);
    }
    */
    
    public int dajCisloReplikacie() {
        return this.aktualnaReplikacia;
    }
    
    public double pocetnost1priemer() {
        return (double) this.celkovaUspesnostPrvaTaktika / this.aktualnaReplikacia;
    }
    
    public double pocetnost2priemer() {
        return (double) this.celkovaUspesnostDruhaTaktika / this.aktualnaReplikacia;
    }
    
    public double pocetnost3priemer() {
        return (double) this.celkovaUspesnostTretiaTaktika / this.aktualnaReplikacia;
    }
    
    public int[] dajPocetnostPrvaTaktika() {
        return this.pocetnostPrvaTaktika;
    }
    
    public int[] dajPocetnostDruhaTaktika() {
        return this.pocetnostDruhaTaktika;
    }
    
    public int[] dajPocetnostTretiaTaktika() {
        return this.pocetnostTretiaTaktika;
    }
    
    public int dajVelkostParkoviska() {
        return this.velkostParkoviska;
    }
     
    public void nastavMC(MonteCarlo mc) {
        this.mc = mc;
    }
    
    public MonteCarlo dajMC() {
        return mc;
    }
}
