package com.ingesup.trellolike;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompleteProfileActivity extends AppCompatActivity {

    EditText _usernameText;
    EditText _keyText;
    EditText _tokenText;
    Button _completeButton;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

        _completeButton = (Button)findViewById(R.id.btn_complete);
        _usernameText = (EditText)findViewById(R.id.input_trello_username);
        _keyText = (EditText)findViewById(R.id.input_trello_key);
        _tokenText = (EditText)findViewById(R.id.input_trello_token);
        _completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeAccount(_usernameText.getText().toString(), _keyText.getText().toString(), _tokenText.getText().toString());
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    private void completeAccount(final String username, final String key, final String token){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        User user = new User(username, key, token);
        mDatabase.child("users").child(currentUser.getUid()).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("trello_username", username);
                editor.putString("trello_key", key);
                editor.putString("trello_token", token);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
