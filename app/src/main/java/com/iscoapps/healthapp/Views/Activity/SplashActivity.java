package com.iscoapps.healthapp.Views.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iscoapps.healthapp.R;
import java.io.File;

public class SplashActivity extends AppCompatActivity
{

    private Handler mHandler;
    private ConstraintLayout layout;

    //------------ reference of views -------------------//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash_screen);

        layout = findViewById(R.id.container);

        Bundle bundle =  getIntent().getExtras();


            mHandler  = new Handler();

            mHandler.postDelayed(new Runnable()
            {
                public void run()
                {

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    // set the new task and clear flags
                    i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK );
                    startActivity(i);
                    finish();


//                        if( getUserId() > 0)
//                        {
//                            // go to register first time
//                            Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                            // set the new task and clear flags
//                            i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK |
//                                    Intent.FLAG_ACTIVITY_NEW_TASK );
//                            startActivity(i);
//                            finish();
//                        }
//                        else
//                        {
//                            // go to home screen
//                            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
//                            // set the new task and clear flags
//                            i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK |
//                                    Intent.FLAG_ACTIVITY_NEW_TASK );
//                            startActivity(i);
//                            finish();
//
//                        }

                    }
            }, 3000);
        }


    private int getUserId()
    {
        SharedPreferences sharedPreferences ;
        SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);

        return Integer.valueOf( sharedPreferences.getString( "user_id" , "-1") );

    }

    public  void deleteCache(Context context) {
//        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
//        } catch (Exception e) {
//            Log.e("exception" , e.getMessage());
//        }
    }

    public  boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }


}
