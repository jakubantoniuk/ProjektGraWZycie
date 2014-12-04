package agh;

/**
 * Created by Kuba on 2014-10-23.
 */
public class cell {
    private int stan;
    private int suma;

    public cell() {
        this.stan = 0;
    }


    public void setStan(int stan) {
        this.stan = stan;
    }

    public void zmienStan(boolean t) {
        if (!t) {
            if (this.stan == 0) {
                this.stan = 1;
            } else {
                this.stan = 0;
            }
        }else
        {
            if (this.stan < 3) {this.stan++;}
            else this.stan=0;
        }
    }

    public int getStan() {
        return stan;
    }

    public void setSuma(int x) {
        this.suma = x;
    }

    public int getSuma() {return this.suma; }


    public void process(boolean t) {
        if (!t) {
            if (this.stan == 0 && this.suma == 3)
                this.stan = 1;
            if (this.stan == 1 && (this.suma == 2 || this.suma == 3))
                this.stan = 1;
            else
                this.stan = 0;
        }else
        {
            if (this.stan == 0 && this.suma >= 7)
                this.stan = 1;
            if (this.stan == 1 && this.suma >= 10)
                this.stan = 2;
            if (this.stan == 1 && this.suma >= 16)
                this.stan = 0;
            if (this.stan == 2 && this.suma >= 12)
                this.stan = 3;
            if (this.stan == 2 && this.suma >= 20)
                this.stan = 1;
            if (this.stan == 3 && this.suma >= 16)
                this.stan = 0;
            if (this.stan == 3 && this.suma <= 12)
                this.stan = 2;
        }
    }
}
