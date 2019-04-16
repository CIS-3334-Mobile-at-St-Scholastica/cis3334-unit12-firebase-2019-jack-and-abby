package edu.css.cis3334_unit12_firebase_2019;

import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Chat Activity hold the functionality for the Chat feature in the application
 */
public class ChatActivity extends AppCompatActivity {

    private static final
    Object AuthResult = null;
    private static final String CIS3334 = "CIS3334" ;
    Button btnPost;
    Button btnLogout;
    EditText etMessage;
    TextView tvMsgList;
    FirebaseAuth mAuth;

    /**
     * OnCreate method intializes the functions that happen upon opening the application
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btnPost = findViewById(R.id.buttonPost);
        btnLogout = findViewById(R.id.buttonChatLogout);
        etMessage = findViewById(R.id.editTextMessage);
        tvMsgList = findViewById(R.id.textViewMsgList);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgText = etMessage.getText().toString();
                etMessage.setText("");           // clear out the message text box to be ready for the next message


                // This does not push message to firebase yet...
                //    The next line should really be in the Firebase onDataChange() method
                tvMsgList.setText(msgText+ "\n" + tvMsgList.getText());

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();           // quit this activity and return to mainActivity
            }
        });

    }
    /**
     * OnStart method initializes the functions that happen in order for the user to interact
     * @override OnStart
     */

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        Object currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        if (currentUser != null) {
            // User is signed in
            Log.d("CIS3334", "onAuthStateChanged:signed_in:" + currentUser.getUid());
            Toast.makeText(MainActivity.this, "User Signed In", Toast.LENGTH_LONG).show();
            etMessage.setText("Signed In");
        } else {
            // User is signed out
            Log.d("CIS3334", "onAuthStateChanged:signed_out");
            Toast.makeText(MainActivity.this, "User Signed Out", Toast.LENGTH_LONG).show();
            etMessage.setText("Signed Out");
        }
    }

    /**
     * Creates onComplete Method- the action of when the user is logging in
     */
    /
            @Override
    mAuth.createUserWithEmailAndPassword(email, password)
    addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
        public void onComplete(Task<AuthResult> task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(CIS3334, "createUserWithEmail:success");
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                // If sign in fails, display a message to the user.
                Log.w(CIS3334, "createUserWithEmail:failure", task.getException());
                Toast.makeText(ChatActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                updateUI(null);
            }

            // ...
        }
    }

    /***
    * Create a new user
    */
        private void createAccount(
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid(););
    }

}}