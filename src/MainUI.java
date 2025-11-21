import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame{
    private JTextField tipp1;
    private JTextField tipp2;
    private JTextField tipp3;
    private JTextField tipp4;
    private JTextField tipp5;
    private JTextField tipp6;

    private JTextField ziehung1;
    private JTextField ziehung2;
    private JTextField ziehung3;
    private JTextField ziehung4;
    private JTextField ziehung5;
    private JTextField ziehung6;

    private JTextField feld_zusatzzahl;
    private JButton ziehenButton;
    private JPanel MainPanel;
    private JLabel ergebnis_text;



    public MainUI(){
        setContentPane(MainPanel);
        setTitle("");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setSize(1000, 200);
        setVisible(true);
        setLocationRelativeTo(null);

        ziehung1.setFocusable(false);
        ziehung2.setFocusable(false);
        ziehung3.setFocusable(false);
        ziehung4.setFocusable(false);
        ziehung5.setFocusable(false);
        ziehung6.setFocusable(false);


        ziehenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] user_input_tips = {tipp1, tipp2, tipp3, tipp4, tipp5, tipp6};
                JTextField[] result_output   = {ziehung1, ziehung2, ziehung3, ziehung4, ziehung5, ziehung6};


                int[] tipp_zahlen = new int[6];

                for(int i=0; i<user_input_tips.length; i++){
                    int tip = 0;

                    try {
                        tip = Integer.parseInt(user_input_tips[i].getText());

                        if (tip <= 0) {
                            ergebnis_text.setText("Eine Eingabe ist kleiner als der erlaubte Bereich!");
                            return;
                        }
                        if (tip > 49) {
                            ergebnis_text.setText("Eine Ihrer Eingaben ist größer als 49");
                            return;
                        }
                    }
                    catch (Exception ex){
                        ergebnis_text.setText("Überprüfen sie Ihre Eingabe");
                        tip = 0;
                        return;
                    }
                    finally {
                        tipp_zahlen[i] = tip;
                        tip = 0;
                    }
                }

                Spiel spiel = new Spiel(tipp_zahlen);

                for (int i=0; i<result_output.length; i++){
                    result_output[i].setText(spiel.gib_Lottozahl(i));
                    user_input_tips[i].setText(spiel.gibTip(i));
                }
                feld_zusatzzahl.setText(spiel.gibZusatzzahl());
                ergebnis_text.setText(spiel.gib_gewinn());
            }
        });
    }
}
