import java.util.Arrays;

public class Urne {
    private Kugel[] dieKugeln;
    private int Anzahl;

    public Urne() {
        this.dieKugeln = new Kugel[49];
        this.Anzahl = 49;

        for (int i=0; i < this.Anzahl; i++){ //Kugeln zum Array hinzufügen
            this.dieKugeln[i] = new Kugel(i+1);
        }
    }

    public Kugel ziehen() {
        int pos = (int) (this.Anzahl * Math.random());
        Kugel eineKugel = this.dieKugeln[pos];
        for (int i = pos; i < this.Anzahl -1; i++){

            this.dieKugeln[i] = this.dieKugeln[i+1];
        }



        this.Anzahl = this.Anzahl - 1;
        return eineKugel;
    }

}
