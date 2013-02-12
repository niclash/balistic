package ac.bali.stic.rest.server;

import io.bali.stic.rest.Balixo;
import io.bali.stic.rest.common.BalixoResource;
import org.restlet.representation.Representation;

public class BalisticServerResource extends AbstractServerResource
    implements BalixoResource
{
    @Override
    public Representation retrieve()
    {
        Balixo balixo = new Balixo( getReference().toUri().getPath() );
        return toRepresentation( balixo );
    }
}
