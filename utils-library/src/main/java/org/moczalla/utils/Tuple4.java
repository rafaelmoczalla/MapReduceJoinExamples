package org.moczalla.utils;


public class Tuple4 {
    public String e1;
    public String e2;
    public String e3;
    public String e4;

    public Tuple4(String e1, String e2, String e3, String e4) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
    }

    public String toString() {
        return e1 + " " + e2 + " " + e3 + " " + e4;
    }
}