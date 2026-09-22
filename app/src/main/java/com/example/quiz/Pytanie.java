package com.example.quiz;

abstract class Pytanie {
    protected String tresc;
    protected String zdjecie;
    protected boolean odpowiedzJest;

    Pytanie(String t, String np)
    {
        tresc = t;
        zdjecie = np;
        odpowiedzJest = false;
    }

    abstract boolean sprawdz();
}

public class PytanieZamkniete extends Pytanie
{


    public boolean sprawdz()
    {
        return true;
    }
}
