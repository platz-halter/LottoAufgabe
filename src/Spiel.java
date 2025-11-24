import java.util.Arrays;

public class Spiel {
    private final int[] tip;
    private Ziehung eineZiehung;

    public Spiel(int[] input_tip) {
        Sorting sorter = new Sorting();
        input_tip = sorter.insertionSort(input_tip);

        this.tip = input_tip;
        this.eineZiehung = new Ziehung();
    }

    public String gib_gewinn(){
        int richtige_zahlen = 0;
        boolean richtige_zusatzzahl = false;
        int zusatzzahl = eineZiehung.gibZusatzzahl();

        for (int i=0; i<tip.length; i++){
            for (int j=0; j<tip.length; j++) {
                if (tip[i] == eineZiehung.gib_Lottozahl(j)) {
                    richtige_zahlen++;
                }
                if (tip[i] == zusatzzahl) {
                    richtige_zusatzzahl = true;
                }
            }
        }

        if (richtige_zahlen <= 1){
            return "Sie haben "+ richtige_zahlen + " richtige Zahl";
        }

        if (richtige_zahlen < 3){
            return "Sie haben " + richtige_zahlen + " richtige Zahlen";
        }
        if (richtige_zahlen >= 3 && richtige_zahlen <= 5){
            if (richtige_zusatzzahl){
                return "Sie haben " + richtige_zahlen + " Richtige mit Zusatzzahl!";
            }
            else {
                return "Sie haben " + richtige_zahlen + " richtige Zahlen!";
            }
        }
        if (richtige_zahlen == 6){
            return "Sie haben " + richtige_zahlen + " richtige Zahlen!!!";
        }

        return "Sie haben " + richtige_zahlen + " richtige Zahlen.";
    }
    public String gib_Lottozahl(int Nr){
        return Integer.toString(eineZiehung.gib_Lottozahl(Nr));
    }

    public String gibZusatzzahl(){
        return Integer.toString(eineZiehung.gibZusatzzahl());
    }

    public String gibTip(int Nr){
        return Integer.toString(this.tip[Nr]);
    }

}
