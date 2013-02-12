package io.bali.stic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import io.bali.stic.http.ProxyServer;

public class SticService extends Service
{
    private static final int NOTIFICATION_STARTED_ID = 1;

    private NotificationManager notifyManager = null;

    public SticService()
    {
        Log.i( Constants.TAG_BALISTIC, "SticService created." );
    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId )
    {
        Log.i( Constants.TAG_BALISTIC, "SticService.onStartCommand()" );
        ProxyServer proxyServer = new ProxyServer();
        proxyServer.start();
        return START_STICKY;
    }

    @Override
    public void onCreate()
    {
        Log.i( Constants.TAG_BALISTIC, "SticService.onCreate()" );
        try
        {
            Log.i( Constants.TAG_BALISTIC, "Copyright Bali Automation, 1996-2013. All Rights Reserved." );
            super.onCreate();
            createNotification();
            Log.i( Constants.TAG_BALISTIC, "Balistic started." );
        }
        catch( Exception e )
        {
            Log.e( Constants.TAG_BALISTIC, "Unable to start Balistic.", e );
        }
    }

    private void createNotification()
    {
        Notification.Builder mBuilder =
            new Notification.Builder( this )
                .setSmallIcon( R.drawable.icon )
                .setContentTitle( getText( R.string.notificationStartedTitle ) )
                .setContentText( getText( R.string.notificationStartedText ) );
        Intent notificationIntent = new Intent( this, ShowLogActivity.class );

        PendingIntent pendingIntent = PendingIntent.getActivity( this, 0, notificationIntent, 0 );
        mBuilder.setContentIntent( pendingIntent );
        notifyManager = (NotificationManager) getSystemService( Context.NOTIFICATION_SERVICE );
        notifyManager.notify( NOTIFICATION_STARTED_ID, mBuilder.getNotification() );
    }

    @Override
    public void onDestroy()
    {
        Log.i( Constants.TAG_BALISTIC, "SticService.onDestroy()" );
        notifyManager.cancel( NOTIFICATION_STARTED_ID );
        notifyManager = null;

        super.onDestroy();
    }

    @Override
    public IBinder onBind( Intent intent )
    {
        Log.i( Constants.TAG_BALISTIC, "SticService.onBind()" );
        return null;
    }
}
