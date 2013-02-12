package io.bali.stic.rest;

public class Balixo
{

    private final String base;

    public Balixo( String base )
    {
        this.base = base;
    }

    public Link getTexts()
    {
        return new Link( base + "texts" );
    }

}
