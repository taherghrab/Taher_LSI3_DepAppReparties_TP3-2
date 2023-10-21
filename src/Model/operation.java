package Model;

import java.io.Serializable;

public class operation implements Serializable {
    int op1;
    int o;
    int op2;
    int res;


    public int getOp1() {
        return op1;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public operation(int op1, int op2, int o,int res) {
        this.op1 = op1;
        this.op2 = op2;
        this.o = o;
        this.res = res;
    }
}
