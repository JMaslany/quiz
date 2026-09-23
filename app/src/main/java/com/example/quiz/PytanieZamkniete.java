package com.example.quiz;

abstract class Pytanie {
    protected String tresc;
    protected int zdjecie;
    protected boolean odpowiedzJest;

    Pytanie(String t, int np)
    {
        tresc = t;
        zdjecie = np;
        odpowiedzJest = false;
    }

    abstract boolean sprawdz(char c);
}

public class PytanieZamkniete extends Pytanie
{
    public String odpA;
    public String odpB;
    public String odpC;
    private char poprawnaOdp;

    PytanieZamkniete(String t, int np, String A, String B, String C, char pOdp) {
        super(t, np);
        odpA = A;
        odpB = B;
        odpC = C;
        poprawnaOdp = pOdp;
    }

    public boolean sprawdz(char odp)
    {
        if(poprawnaOdp==odp)
            return odpowiedzJest = true;
        else
            return false;
    }
}
