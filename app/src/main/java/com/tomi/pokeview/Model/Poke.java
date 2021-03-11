package com.tomi.pokeview.Model;

import java.io.Serializable;

public class Poke implements Serializable
{
    private static  final long id = 1L;

    private String pName;
    private String pType;

    public Poke(String pName, String pType)
    {
        this.pName=pName;
        this.pType=pType;
    }

    public Poke()
    { }

    public String getpName() {
        return pName;
    }

    public void setpName(String name) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }
}