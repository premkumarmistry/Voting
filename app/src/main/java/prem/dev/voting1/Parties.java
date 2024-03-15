package prem.dev.voting1;

public class Parties {

    private int parties1;
    private int parties2;
    private int parties3;
    private int parties4;

    public Parties(){

    }

    public Parties(int parties1, int parties2, int parties3, int parties4) {
        this.parties1 = parties1;
        this.parties2 = parties2;
        this.parties3 = parties3;
        this.parties4 = parties4;
    }

    public int getParties1() {
        return parties1;
    }

    public void setParties1(int parties1) {
        this.parties1 = parties1;
    }

    public int getParties2() {
        return parties2;
    }

    public void setParties2(int parties2) {
        this.parties2 = parties2;
    }

    public int getParties3() {
        return parties3;
    }

    public void setParties3(int parties3) {
        this.parties3 = parties3;
    }

    public int getParties4() {
        return parties4;
    }

    public void setParties4(int parties4) {
        this.parties4 = parties4;
    }
}
