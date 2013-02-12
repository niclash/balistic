package io.bali.stic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class StartServiceActivity extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        Log.i( Constants.TAG_BALISTIC, "StartServiceActivity.onCreate()" );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.starting );

        Intent intent = new Intent( this, SticService.class );
        SticServiceConnection connection = new SticServiceConnection(getApplicationContext());
        bindService( intent, connection, 0 );
    }
}
