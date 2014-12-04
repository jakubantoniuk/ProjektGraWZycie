package agh;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class screen extends JPanel implements MouseListener{

    mainWindow parent;
    public board plansza=new board();

    public screen(mainWindow tmp) {
        parent = tmp;
        addMouseListener(this);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 1; i < 15+2; i++) {
            g.setColor(Color.BLACK);
            g.drawLine((40 * i), 0, (40 * i), 15*40);
            g.drawLine(40, (40 * i) - 40, (15*40)+40, (40 * i) - 40);
            for (int j = 1; j < 15+1; j++) {
                if (!parent.tryb) {
                    if (plansza.tab[i][j].getStan() == 0) {
                        g.setColor(Color.white);
                    } else {
                        g.setColor(Color.black);
                    }
                }
                else
                {
                    if (plansza.tab[i][j].getStan() == 0) {
                        g.setColor(Color.white);
                    }else if (plansza.tab[i][j].getStan() == 1){
                        g.setColor(Color.green);
                    }else if (plansza.tab[i][j].getStan() == 2){
                        g.setColor(Color.yellow);
                    }else if (plansza.tab[i][j].getStan() == 3){
                        g.setColor(Color.red);
                    }
                }
                if (i < 15+1) g.fillRect((i * 40) + 5, (j * 40) - 35, 30, 30);
            }

        }


    }

    public void rysuj() {
        this.repaint();
    }


    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (parent.click) {
            int x = e.getX();
            int y = e.getY();
            if (x >= 40 && x <= (15*40)+40 && y >= 0 && y <= 15*40) {
                this.plansza.tab[x / 40][(y + 40) / 40].zmienStan(parent.tryb);

                //System.out.println("mouseReleased");
                this.rysuj();
            }
            // System.out.println("mousePressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}