package io.bali.stic.rest.dto;

import io.bali.stic.rest.Link;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import org.restlet.data.Reference;

public class Texts
{
    private final Reference base;

    public Texts( Reference base )
    {
        this.base = base;
    }

    @XmlElement(name = "text",type = Link.class)
    public List<Link> getInstalled()
    {
        List<Link> result = new ArrayList<Link>();
//        for( int ldn = 0; ldn < 256; ldn++ )
//        {
//            if( exoreal.getTexts().isPresent( ldn ) )
//            {
//                result.add( new TextLink( ldn, base ) );
//            }
//        }
        return result;
    }

    private static class TextLink extends Link
    {
        private final int ldn;

        public TextLink( int ldn, Reference base )
        {
            super( new Reference( base, "" + ldn).toUri().getPath() );
            this.ldn = ldn;
        }

        public String getLdn()
        {
            return String.valueOf( ldn );
        }
    }
}
