package io.bali.stic.rest.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface TaskResource
{
    @Get("json|xml")
    public Representation read();

    @Put("json|xml")
    public void load(Representation task);

    @Delete
    public void kill();
}
