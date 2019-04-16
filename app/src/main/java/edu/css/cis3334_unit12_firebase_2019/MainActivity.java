package edu.css.cis3334_unit12_firebase_2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/***
 * Creates Main
 * @author Abigailsova & Jack
 * @version 2.0
 *
 */

public class MainActivity extends AppCompatActivity {

    private TextView textViewStatus;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonGoogleLogin;
    private Button buttonCreateLogin;
    private Button buttonSignOut;
    private Button buttonStartChat;

    /**
     * OnCreate instantiates the variables that make up the structure of the application
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonGoogleLogin = (Button) findViewById(R.id.buttonGoogleLogin);
        buttonCreateLogin = (Button) findViewById(R.id.buttonCreateLogin);
        buttonSignOut = (Button) findViewById(R.id.buttonSignOut);
        buttonStartChat = findViewById(R.id.buttonStartChat);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            /***
             * OnClick getText email & password for normal login
             * @param v
             */
            public void onClick(View v) {
                Log.d("CIS3334", "normal login ");
                signIn(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });

        buttonCreateLogin.setOnClickListener(new View.OnClickListener() {
            /**
             * OnCLick get Text on Create Account
             * @param v
             */
            public void onClick(View v) {
                Log.d("CIS3334", "Create Account ");
                createAccount(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });

        buttonGoogleLogin.setOnClickListener(new View.OnClickListener() {
            /***
             * OnClick get Google Login page
             * @param v
             */
            public void onClick(View v) {
                Log.d("CIS3334", "Google login ");
                googleSignIn();
            }
        });

        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            /**
             * OnCLick log user out
             * @param v
             */
            public void onClick(View v) {
                Log.d("CIS3334", "Logging out - signOut ");
                signOut();
            }
        });

        buttonStartChat.setOnClickListener(new View.OnClickListener() {
            /**
             * OnClick initate Chat activity
             * @param v
             */
            public void onClick(View v) {
                Log.d("CIS3334", "Starting Chat Intent ");
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);

            }
        });

    }

    /***
     * createAccount makes new user account
     * @param email
     * @param password
     */

    private void createAccount(String email, String password) {

        Toast.makeText(getApplicationContext(), "Create Account not implemented yet !!! ", Toast.LENGTH_LONG).show();

    }

    /**
     * signIn creates the exisiting user 
     * @param email
     * @param password
     */

    private void signIn(String email, String password){

        Toast.makeText(getApplicationContext(), "signIn not implemented yet !!! ", Toast.LENGTH_LONG).show();

    }

    private void signOut () {

        Toast.makeText(getApplicationContext(), "signOut not implemented yet !!! ", Toast.LENGTH_LONG).show();

    }

    private void googleSignIn() {

        Toast.makeText(getApplicationContext(), "Google SignIn not implemented yet !!! ", Toast.LENGTH_LONG).show();

    }



}
