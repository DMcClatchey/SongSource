package com.song_source.songsource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookSdk;
import com.facebook.login.*;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.widget.LoginButton;
import com.facebook.FacebookException;
import com.facebook.*;

public class Login extends AppCompatActivity {

    private LoginButton facebooklogin;
    private TextView theinfo;
    private CallbackManager fbcallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        fbcallback = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

        theinfo = (TextView)findViewById(R.id.info);
        facebooklogin = (LoginButton)findViewById(R.id.login_button);

        facebooklogin.registerCallback(fbcallback, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult theloginResult) {

                Intent myIntent = new Intent(Login.this, HomeScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                Login.this.startActivity(myIntent);

                /*theinfo.setText(
                        "User ID: "
                                + theloginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + theloginResult.getAccessToken().getToken()
                );*/


            }

            @Override
            public void onCancel() {

                theinfo.setText("Login attempt canceled.");

            }

            @Override
            public void onError(FacebookException e) {
                theinfo.setText("Login attempt failed.");
            }
        });

        Button LoggingIn = (Button) findViewById(R.id.EmailLogin);
        LoggingIn.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Login.this, ActualLogin.class);
                //myIntent.putExtra("key", value); //Optional parameters
                Login.this.startActivity(myIntent);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        fbcallback.onActivityResult(requestCode, resultCode, data);

    }

    /*@Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }this is a facebook event tracker?*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
