package ac.bali.stic.rest.server;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.resource.Finder;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

public class BalisticApplication extends Application
{
    private static BalisticApplication app;

    @Override
    public Restlet createInboundRoot() {
        Context context = getContext();
        Router router = new Router( context );
        router.attachDefault(new Directory( context, "file:///"));
        router.attach( "/balistic/texts/{loadno}/", new TextFinder() );
        router.attach( "/balistic/texts/", new TextsFinder() );
        router.attach( "/balistic/", BalisticServerResource.class );
        return router;
    }

    private static class TextsFinder extends Finder
    {
        @Override
        public ServerResource create( Request request, Response response )
        {
//            return new TextsServerResource(exoreal);
            return new TextsServerResource();
        }
    }

    private static class TextFinder extends Finder
    {
        @Override
        public ServerResource create( Request request, Response response )
        {
//            return new TextServerResource(exoreal);
            return new TextServerResource();
        }
    }
}
