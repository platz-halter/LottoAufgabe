import java.util.Arrays;

public class Ziehung {
    private Urne die_urne;
    private int[] dieLottozahlen;
    private int Zusatzzahl;


    public Ziehung(){
        this.dieLottozahlen = new int[6];
        this.die_urne = new Urne();
        this.Zusatzzahl = (int) (Math.random()*10);
        ziehen();
    }
    private void sortieren(){
        Sorting sorter = new Sorting();
        this.dieLottozahlen = sorter.sort7(this.dieLottozahlen);
        //Arrays.sort(this.dieLottozahlen);
    }
    public void ziehen(){
        for (int i=0; i<this.dieLottozahlen.length; i++){
            this.dieLottozahlen[i] = this.die_urne.ziehen().gibZahl();

        }
        System.out.println(Arrays.toString(this.dieLottozahlen));
        sortieren();
        System.out.println(Arrays.toString(this.dieLottozahlen));
    }
    public int gib_Lottozahl(int Nr){
        return this.dieLottozahlen[Nr];
    }

    public int gibZusatzzahl(){
        return this.Zusatzzahl;
    }

}
