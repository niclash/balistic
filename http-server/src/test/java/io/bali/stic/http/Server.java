package io.bali.stic.http;

public class Server
{
    public static void main( String[] args )
        throws Exception
    {
        ProxyServer proxyServer = new ProxyServer();
        proxyServer.start();
        Thread.sleep( 60000 );
        proxyServer.stop();
    }
}
