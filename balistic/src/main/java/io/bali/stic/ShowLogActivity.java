package io.bali.stic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ShowLogActivity extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        Log.i( Constants.TAG_BALISTIC, "ShowLogActivity.onCreate()" );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.showlog );
    }
}
