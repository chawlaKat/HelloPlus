/*
"Hello World +"
Written by Katherine Chawla
9/10/17
Cosc 4730

Reference: "Android Programming: The Big Nerd Ranch Guide"
    by Bill Phillips and Brian Hardy
Collaboration: Talitha Trippel
 */

package edu.uwyo.kchawla.helloplus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements InnerFragment.OnFragmentInteractionListener{

    public static final String TAG = "HEY_LISTEN_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"Activity created");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        //if no fragment exists, create new
        if (fragment == null){
            Log.i(TAG,"About to create fragment");

            fragment = new InnerFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }


    }

    //when Submit is clicked, log text
    @Override
    public void onFragmentInteraction(String name) {
        Log.i(TAG, "Name is "+name);
    }
}
