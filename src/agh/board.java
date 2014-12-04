package agh;

/**
 * Created by Kuba on 2014-10-23.
 */
public class board {
    public cell tab[][];
    public board(){
        tab=new cell[17][17];
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                tab[i][j]=new cell();
            }
            }
    }

    public void licz()
    {
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 16; j++) {
                int s=0;
                for (int x=i-1;x<i+2;x++){
                    for (int y=j-1;y<j+2;y++){
                        s=s+tab[x][y].getStan();
                    }

                }
                s=s-tab[i][j].getStan();
                tab[i][j].setSuma(s);
            }
        }

    }
    public void live(boolean t)
    {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                if (i==0 || j==0 || i == 16 || j == 16)
                        tab[i][j].setStan(0);
                else
                    tab[i][j].process(t);
            }
        }
    }

    public void zeruj()
    {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                    tab[i][j].setStan(0);
            }
        }
    }

}
