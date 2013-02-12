package io.bali.stic;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SticServiceConnection
    implements ServiceConnection
{
    private Context context;

    SticServiceConnection( Context context )
    {
        Log.i(Constants.TAG_BALISTIC, "SticServiceConnection created.");
        this.context = context;
    }

    @Override
    public void onServiceConnected( ComponentName componentName, IBinder binder )
    {
        Log.i(Constants.TAG_BALISTIC, "SticServiceConnection.onServiceConnected()");
        Toast toast = Toast.makeText( context, "Balistic is Running.", 1000 );
        toast.show();
    }

    @Override
    public void onServiceDisconnected( ComponentName componentName )
    {
        Log.i(Constants.TAG_BALISTIC, "SticServiceConnection.onServiceDisconnected()");
    }
}
