package com.iscoapps.healthapp.Views.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.iscoapps.healthapp.R;

public class LoginActivity extends AppCompatActivity {

    EditText emailEt,passwordEd;
    TextView signUpTv;

//    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEt = findViewById(R.id.editText);
        passwordEd =  findViewById(R.id.editText2);
        signUpTv =  findViewById(R.id.textView9);

//        dataBaseHelper = new DataBaseHelper(this);
//        long id = dataBaseHelper.insertUser("user test" , "olx@hotmail.com" , "123456",
//                "96566328950");
//        System.out.println("id = " + id);
//        Log.e("test***" , "id = " + id);
    }

    public void loginFun(View view)
    {
//        User user = dataBaseHelper.getUser(emailEt.getText().toString().trim());
//        if(user != null &&
//                user.getPassword().equals(passwordEd.getText().toString()))
//        {
//            saveUserAuth(user.getId()+"");
//            Toast.makeText(this,"Welecome " + user.getName()
//                    , Toast.LENGTH_LONG).show();
//
//            Intent intent = new Intent(LoginActivity.this,
//                    HomeActivity.class);
//            startActivity(intent);
//        }
//        else {
//            Toast.makeText(this,"Wrong Auth" , Toast.LENGTH_LONG).show();
//        }

    }


    public void signUpFun(View view)
    {
        Intent intent = new Intent(LoginActivity.this,
                RegisterActivity.class);
        startActivity(intent);

    }


    public void saveUserAuth(String user_id)
    {
         SharedPreferences sharedPreferences ;
         SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("user_id" ,user_id);
        editor.commit();

    }


}
