package io.bali.stic.rest.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface CellResource
{
    @Get("json|xml")
    public Representation read();

    @Put("json|xml")
    public void set( Representation dpac );

}
