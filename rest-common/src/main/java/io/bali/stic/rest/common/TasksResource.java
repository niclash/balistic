package io.bali.stic.rest.common;

import java.util.List;
import org.restlet.resource.Get;

public interface TasksResource
{
    @Get
    public List<TaskResource> retrieve();

}
