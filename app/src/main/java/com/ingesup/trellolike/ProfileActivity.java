package com.ingesup.trellolike;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    Button _signoutButton;
    Button _updateButton;
    EditText _usernameText;
    EditText _keyText;
    EditText _tokenText;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        _signoutButton = (Button)findViewById(R.id.btn_signout);
        _signoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        _updateButton = (Button)findViewById(R.id.btn_update);
        _signoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });
        _usernameText = (EditText)findViewById(R.id.input_trello_username);
        _keyText = (EditText)findViewById(R.id.input_trello_key);
        _tokenText = (EditText)findViewById(R.id.input_trello_token);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        prefs = getSharedPreferences("user", Context.MODE_PRIVATE);

        _usernameText.setText(prefs.getString("trello_username", ""));
        _keyText.setText(prefs.getString("trello_key", ""));
        _tokenText.setText(prefs.getString("trello_token", ""));

    }

    private void signOut(){
        mAuth.signOut();
        prefs.edit().clear().commit();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void updateProfile(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        User user = new User(_usernameText.getText().toString(), _keyText.getText().toString(), _tokenText.getText().toString());

        Map<String, Object> postValues = user.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(currentUser.getUid(), postValues);

        mDatabase.updateChildren(childUpdates);
    }

}
