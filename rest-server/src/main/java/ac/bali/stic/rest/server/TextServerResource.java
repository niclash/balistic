package ac.bali.stic.rest.server;

import io.bali.stic.rest.common.TextResource;
import io.bali.stic.rest.dto.Text;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;

public class TextServerResource extends AbstractServerResource
    implements TextResource
{
    @Override
    public Representation read()
    {
        String loadno = getAttribute( "loadno" );
        if( loadno == null )
        {
            return new EmptyRepresentation();
        }
//        Text text = new Text( exoreal, Integer.parseInt( loadno ), getReference() );
        Text text = new Text( Integer.parseInt( loadno ), getReference() );
        return toRepresentation( text );
    }

    @Override
    public void load( Representation representation )
    {
        String loadno = getAttribute( "loadno" );
        if( loadno == null )
        {
            return;
        }
        Text text = toDomainObject( representation, Text.class );
//        exoreal.getTexts().loadText( Integer.parseInt( loadno ), text.getValue(), Origin.exoline );
    }

    @Override
    public void kill()
    {
        String loadno = getAttribute( "loadno" );
        if( loadno == null )
        {
            return;
        }
//        exoreal.getTexts().killText( Integer.parseInt( loadno ) );
    }
}
