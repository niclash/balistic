package io.bali.stic.rest;

public class Link
{
    private final String linkValue;

    public Link( String linkValue )
    {
        this.linkValue = linkValue;
    }

    public String getRel()
    {
        return linkValue + "/";
    }

}
