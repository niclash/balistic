package ac.bali.stic.rest.server;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class RestServer
{

    private final Component serverComponent;

    public RestServer()
        throws Exception
    {
        serverComponent = new Component();
        serverComponent.getServers().add( Protocol.HTTP, 8182 );
        serverComponent.start();
    }

    public void addApplication(String contextRoot, Application app)
        throws Exception
    {
        serverComponent.getDefaultHost().attach( contextRoot, app );
    }
}
