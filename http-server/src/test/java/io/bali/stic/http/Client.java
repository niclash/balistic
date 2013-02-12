package io.bali.stic.http;

import java.io.IOException;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.io.Buffer;
import org.eclipse.jetty.io.Connection;
import org.eclipse.jetty.io.EndPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client
{
    private final HttpClient client;
    private final String url;

    public Client( String url )
    {
        this.url = url;
        client = new HttpClient();
    }

    public void start()
    {
        try
        {
            HttpExchange exchange = new RedirectingHttpExchange();
            exchange.setURL( url );
            client.start();
            client.send( exchange );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
        throws Exception
    {
        new Client( "http://localhost:8181/en" ).start();
        System.out.println( "Done!" );
        Thread.sleep( 10000 );
    }

    private static class RedirectingHttpExchange extends HttpExchange
    {
        private String redirectTo;
        private boolean redirect;

        @Override
        protected Connection onSwitchProtocol( EndPoint endp )
            throws IOException
        {
            System.out.println( "onSwitchProtocol(" + endp + ")" );
            return super.onSwitchProtocol( endp );
        }

        @Override
        protected void onRequestCommitted()
            throws IOException
        {
            System.out.println( "onRequestCommitted()" );
            super.onRequestCommitted();
        }

        @Override
        protected void onRequestComplete()
            throws IOException
        {
            System.out.println( "onRequestComplete()" );
            super.onRequestComplete();
        }

        @Override
        protected void onResponseStatus( Buffer version, int status, Buffer reason )
            throws IOException
        {
            if( status == 302 || status == 301)
            {
                redirect = true;
            }
            System.out.println( "onResponseStatus(" + version + "," + status + "," + reason + ")" );
            super.onResponseStatus( version, status, reason );
        }

        @Override
        protected void onResponseHeader( Buffer name, Buffer value )
            throws IOException
        {
            System.out.println( "onResponseHeader(" + name + "," + value + ")" );
            String headerName = name.toString( "UTF-8" );
            if( headerName.equals( "Location" ) )
            {
                redirectTo = value.toString( "UTF-8" );
            }
            super.onResponseHeader( name, value );
        }

        @Override
        protected void onResponseHeaderComplete()
            throws IOException
        {
            System.out.println( "onResponseHeaderComplete()" );
            super.onResponseHeaderComplete();
        }

        @Override
        protected void onResponseContent( Buffer content )
            throws IOException
        {
            System.out.println( "onReponseContent(" + content + ")" );
            super.onResponseContent( content );
        }

        @Override
        protected void onResponseComplete()
            throws IOException
        {
            System.out.println( "onResponseComplete()" );
            if( redirect )
            {
                new Client( redirectTo ).start();
            }
            super.onResponseComplete();
        }

        @Override
        protected void onConnectionFailed( Throwable x )
        {
            System.out.println( "onConnectionFailed(" + x + ")" );
            super.onConnectionFailed( x );
        }

        @Override
        protected void onException( Throwable x )
        {
            System.out.println( "onException() -> " );
            x.printStackTrace();
            super.onException( x );
        }

        @Override
        protected void onExpire()
        {
            System.out.println( "onExpire()" );
            super.onExpire();
        }

        @Override
        protected void onRetry()
            throws IOException
        {
            System.out.println( "onRetry()" );
            super.onRetry();
        }
    }
}
