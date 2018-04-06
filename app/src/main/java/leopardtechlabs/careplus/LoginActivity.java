package leopardtechlabs.careplus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    TextView emailcontrol,passwordControl;
    Button submitControl,newUserControl;
    String emailText,passwordText,id;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailcontrol=(EditText)findViewById(R.id.emailInput);
        passwordControl=(EditText)findViewById(R.id.passwordInput);
        submitControl=(Button)findViewById(R.id.submitButton);
        newUserControl=(Button)findViewById(R.id.register);

        submitControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailText=emailcontrol.getText().toString();
                passwordText=passwordControl.getText().toString();

                processCredentials(emailText,passwordText);
            }
        });

        newUserControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrerActivity.class);
                startActivity(intent);
            }
        });

    }

    private void processCredentials(String emailText,String passwordText) {
        if (validate(emailText,passwordText)){

             auth=FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
//
                        storeDetails();

                    }

                    else {
                        emailcontrol.setError("Invalid Username or Password");
                    }
                }
            });
        }
        else {
            emailcontrol.setError("Invalid Username or Password");
        }
    }

    private void activityNavigator() {
        Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(intent);
    }

    private int storeDetails() {


        FirebaseUser user=auth.getCurrentUser();

        if (user!=null){
            id=user.getUid();
            DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference("User/"+id);

            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    UserDetails userDetails=dataSnapshot.getValue(UserDetails.class);
                    SharedPreferences store=getSharedPreferences("userDetails",MODE_PRIVATE);
                    SharedPreferences.Editor editor=store.edit();
                    editor.putString("name",userDetails.getNameIp());
                    editor.putString("id",id);
                    editor.commit();
                    activityNavigator();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }
        return 0;
    }

    private boolean validate(String emailText, String passwordText) {

        boolean f=true;

        if (emailText==null || emailText=="" || emailText.isEmpty()){
            f=false;
        }

        else if (passwordText==null || passwordText=="" ||passwordText.isEmpty()){
            f=false;
        }

        return f;
    }



}
