package agh;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;


public class mainWindow extends JFrame {

    private int dt=500;
    public boolean click;
    public boolean played;
    public boolean tryb;



    screen ekran=new screen(this);
    buttons przyciski=new buttons(this);


    public ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> result;

    mainWindow() {
        JFrame jf = new JFrame("Gra w Życie");
        jf.setSize((15*40)+90, (15*40)+80);
        jf.setResizable(false);
        click=true;
        played=false;

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

        listPane.add(przyciski);
        listPane.add(ekran);


        jf.add(listPane);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        //run();
        //stop();
    }

    Runnable petla = new Runnable() {
        public void run() {

            ekran.plansza.licz();
            ekran.plansza.live(tryb);
            ekran.rysuj();

        }
    };


    public void run()  {

       result = service.scheduleAtFixedRate(petla, 0, dt, TimeUnit.MILLISECONDS);

    }

    public void start() {
        click=false;
        played=true;
        run();
    }

    public void stop() {
        click=true;
        if (played)
        result.cancel(true);

    }


    public void reset() {
        click=true;

        ekran.plansza.zeruj();
        ekran.rysuj();
        if (played)
        result.cancel(true);
    }}