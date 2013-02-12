package io.bali.stic.rest.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;

public interface TextsResource
{
    @Get( "json|xml" )
    public Representation read();
}
