package io.bali.stic.http;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ProxyServer
{
    private Server server;

    public void start()
    {
        server = new Server();
        Connector connector = new SelectChannelConnector();
        connector.setPort( 8181 );
        server.setConnectors( new Connector[]{ connector } );

        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.NO_SESSIONS );
        context.setDisplayName( "Balistic" );
        context.setContextPath( "/" );
        server.setHandler( context );
        ProxyServlet proxyServlet = new BalancerServlet();
        ServletHolder holder = new ServletHolder( proxyServlet );
        holder.setInitParameter( "ProxyPassReverse", "true" );
        holder.setInitParameter( "BalancerMember.http.ProxyTo", "http://www.bali.io" );
        holder.setAsyncSupported( true );
        context.addServlet( holder, "/*" );

        try
        {
            server.start();
        }
        catch( Exception e )
        {
            throw new RuntimeException( e );
        }
    }

    public void stop()
        throws Exception
    {
        server.stop();
    }
}
