package scrabbleScoreKeeper;

public class Model {
    private int p1, p2, p3, p4, num;
    
    public Model(){};
    
    public Model(int newP1, int newP2, int newP3, int newP4, int newNum) {
        this.p1 = newP1;
        this.p2 = newP2;
        this.p3 = newP3;
        this.p4 = newP4;
        this.num = newNum;
    }

    public void addRecord(int newP1, int newP2, int newP3, int newP4, int newNum) {
        this.p1 = newP1;
        this.p2 = newP2;
        this.p3 = newP3;
        this.p4 = newP4;
        this.num = newNum;
    }

    public int get1() {
        return this.p1;
    }

    public void set1(int newP1) {
        this.p1 = newP1;
    }

    public int get2() {
        return this.p2;
    }

    public void set2(int newP1) {
        this.p2 = newP1;
    }

    public int get3() {
        return this.p3;
    }

    public void set3(int newP3) {
        this.p3 = newP3;
    }
    public int get4() {
        return this.p4;
    }

    public void set4(int newP4) {
        this.p4 = newP4;
    }
    public int getNum() {
        return this.num;
    }

    public void setNum(int newNum) {
        this.num = newNum;
    }
}