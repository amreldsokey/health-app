package com.iscoapps.healthapp.Views.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import com.iscoapps.healthapp.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity
{

    Dialog generalDialog;
    Boolean isVaildEmail = false , isVaildPhone = false,
    isLicensed = false;


    public  final String[] paths = {  "Choose Gender" , "Male" , "Female" };
    String city="";



    //--------------------------- views -----------------------------------//

    EditText phone , email  ,  username   ,
        password ;

    Button signupBtn;
    ConstraintLayout layout;
    ProgressBar loadingPb;
    Spinner countryS;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.sign_up);



        setContentView(R.layout.signup_user_screen);

        layout = findViewById(R.id.container);

        findViewsToReferences();

        setListenerOfViews();

    }

    public void backFun(View view)
    {
        finish();
    }

    public void setListenerOfViews()
    {
//        try {



        signupBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                clearError();
//                loadingPb.setVisibility(View.VISIBLE);
//                signupBtn.setVisibility(View.INVISIBLE);
//               checkDataThenRegister();
            }
        });




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                R.layout.spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryS.setAdapter(adapter);
        countryS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city = paths[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void findViewsToReferences()
    {
//        try {

        phone = findViewById(R.id.textView33);
        email = findViewById(R.id.textView55);

        username = findViewById(R.id.textView22);

         layout= findViewById(R.id.container);


        countryS= findViewById(R.id.spinner);

        loadingPb = findViewById(R.id.progressBar4);
        signupBtn= findViewById(R.id.button19);

        password= findViewById(R.id.textView2223);


//        }
//        catch ( Exception e)
//        {
//            Log.e("exception" , e.getMessage());
//        }

    }




    public  boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }



    public void checkDataThenRegister()
    {
//        if(!username.getText().toString().isEmpty() &&
//        !phone.getText().toString().isEmpty() &&
//                !password.getText().toString().isEmpty() &&
//                !email.getText().toString().isEmpty() &&
//                 !city.isEmpty())
//        {
//
//                DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
//                long id = dataBaseHelper.insertUser(username.getText().toString()
//                        , email.getText().toString() , password.getText().toString(),
//                        phone.getText().toString(),
//                        city);
//
//
//                SharedPreferences sharedPreferences ;
//                SharedPreferences.Editor editor;
//
//                sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
//                editor = sharedPreferences.edit();
//
//                editor.putString("user_id" ,id+"");
//                editor.putString("name" ,username.getText().toString());
//                editor.putString("email" ,email.getText().toString());
//                editor.putString("city" ,city);
//
//                editor.commit();
//
//                Toast.makeText(this,"Register successfully", Toast.LENGTH_LONG).show();
//
//                Intent i = new Intent(RegisterActivity.this , HomeActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(i);
//
//
//        }
//        else{
//
//            loadingPb.setVisibility(View.GONE);
//            signupBtn.setVisibility(View.VISIBLE);
//
//
//            Toast.makeText(this,"Validation error ," +
//                    "Missing some of Data", Toast.LENGTH_LONG).show();
//        }
    }


    public void saveUserAuth(String user_id )
    {
        SharedPreferences sharedPreferences ;
        SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("user_id" ,user_id);
        editor.commit();

    }


}
