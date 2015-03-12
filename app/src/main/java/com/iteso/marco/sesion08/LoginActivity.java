package com.iteso.marco.sesion08;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/**
 * Created by marco on 3/11/15.
 */
public class LoginActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        User user = LoadPreferences();

        if(user.getUsuario() != null && user.getUsuario().trim() != "" &&
           user.getPassword() != null && user.getPassword().trim() != "" &&
           user.isLogged() == true)
        {
            //intent to main activity
            startMainActivity();
        }
        else
        {
            setContentView(R.layout.activity_login);
        }

    }

    public User LoadPreferences()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MY_PREFERENCES", MODE_PRIVATE);
        User user = new User();
        user.setUsuario(sharedPreferences.getString("USER", null));
        user.setPassword(sharedPreferences.getString("PWD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));

        return user;
    }

    public void OnClick(View view)
    {
        Login();
        startMainActivity();
    }

    private void Login()
    {
        User user = new User();
        user.setUsuario(((EditText)findViewById(R.id.editUser)).getText().toString());
        user.setPassword(((EditText) findViewById(R.id.editPassword)).getText().toString());
        user.setLogged(true);

        SharedPreferences sharedPreferences = getSharedPreferences("MY_PREFERENCES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER", user.getUsuario());
        editor.putString("PWD", user.getPassword());
        editor.putBoolean("LOGGED", user.isLogged());

        editor.commit();
    }

    private void startMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
