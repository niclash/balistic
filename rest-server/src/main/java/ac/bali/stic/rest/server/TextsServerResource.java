package ac.bali.stic.rest.server;

import io.bali.stic.rest.common.TextsResource;
import io.bali.stic.rest.dto.Texts;
import org.restlet.representation.Representation;

public class TextsServerResource extends AbstractServerResource
    implements TextsResource
{

    @Override
    public Representation read()
    {
//        Texts texts = new Texts( exoreal, getReference() );
        Texts texts = new Texts( getReference() );
        return toRepresentation( texts );
    }
}
