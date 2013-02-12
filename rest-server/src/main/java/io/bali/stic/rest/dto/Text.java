package io.bali.stic.rest.dto;

import org.restlet.data.Reference;

public class Text
{
//    private final ExoReal exoreal;
    private final int ldn;
    private final Reference base;

    public Text( int ldn, Reference base )
    {
//        this.exoreal = exoreal;
        this.ldn = ldn;
        this.base = base;
    }

    public String getMaxLength()
    {
//        return String.valueOf( exoreal.getTexts().maxLength(ldn) );
        return "10";
    }

    public String getLoadNumber()
    {
        return String.valueOf( ldn );
    }

    public String getValue()
    {
//        return exoreal.getTexts().readText( ldn );
        return "Niclas";
    }
}

