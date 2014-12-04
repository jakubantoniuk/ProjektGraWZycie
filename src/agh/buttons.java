package agh;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class buttons extends JPanel implements ActionListener{
    JButton start,stop,reset;
    JComboBox tryb;
    mainWindow parent;

    public buttons(mainWindow tmp) {
        parent=tmp;

        this.setSize(-1, 20);
        this.setMaximumSize(new Dimension(500, 25));

        start = new JButton("Start");
        this.add(start);
        start.addActionListener(this);

        stop = new JButton("Stop");
        this.add(stop);
        stop.addActionListener(this);

        reset = new JButton("Reset");
        this.add(reset);
        reset.addActionListener(this);

        tryb = new JComboBox(new String[]{"Czarno-Białe", "Kolorowe"});
        this.add(tryb);
        tryb.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== start) {
                parent.start();
        }
        else if(e.getSource()== reset) {
            parent.reset();
        }
        else if(e.getSource()== stop) {
            parent.stop();
        }
        else if(e.getSource()== tryb) {
            String x = (String)tryb.getSelectedItem();
            if (x=="Czarno-Białe"){parent.tryb=false;}
            else {parent.tryb=true;}
            parent.ekran.rysuj();

            parent.ekran.plansza.zeruj();
            parent.stop();
        }

    }


}
