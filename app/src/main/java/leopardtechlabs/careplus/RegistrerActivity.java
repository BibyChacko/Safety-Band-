package leopardtechlabs.careplus;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrerActivity extends AppCompatActivity {

    //FireBase SHA Key = bc85cab8f459ba2c5eb3ae22bfdf35eae2c960a0

    EditText name,dob,email,mobile,address,password,confirmPassword;
    RadioGroup sex;
    Button submit;
    String gender;

    UserDetails user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        name=(EditText)findViewById(R.id.user_name);
        dob=(EditText)findViewById(R.id.dob);
        email=(EditText)findViewById(R.id.email);
        mobile=(EditText)findViewById(R.id.mobile);
        address=(EditText)findViewById(R.id.address);
        password=(EditText)findViewById(R.id.password);
        confirmPassword=(EditText)findViewById(R.id.confirm_password);
        sex=(RadioGroup)findViewById(R.id.sex);
        submit=(Button)findViewById(R.id.register_now);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameIp,dobIp,emailIp,mobileIp,addressIp,passwordIp,confirmPassIp,imageEncoded="";

                nameIp=name.getText().toString();
                dobIp=dob.getText().toString();
                emailIp=email.getText().toString();
                mobileIp=mobile.getText().toString();
                addressIp=address.getText().toString();
                passwordIp=password.getText().toString();
                confirmPassIp=confirmPassword.getText().toString();

                sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                        if (i==R.id.male)
                            gender="Male";

                        else
                            gender="Female";
                    }
                });

                user=new UserDetails(nameIp,dobIp,emailIp,mobileIp,addressIp,passwordIp,imageEncoded,gender);

                if(validateInput(nameIp,dobIp,emailIp,mobileIp,addressIp,passwordIp,confirmPassIp))
                    FIrebaseRegistration(emailIp,passwordIp);

               else
                   name.setError("Invalid Ips");
            }
        });
    }

    private void FIrebaseRegistration(String emailIp, String passwordIp) {

        final FirebaseAuth firebaseAuth;
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(emailIp,passwordIp).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {


                    String id=firebaseAuth.getCurrentUser().getUid();
                        if (dataUploaded(id)){

                            Toast.makeText(RegistrerActivity.this,"Registered",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(RegistrerActivity.this,LoginActivity.class);
                            startActivity(intent);

                        }
                } else
                    Toast.makeText(RegistrerActivity.this,"Error",Toast.LENGTH_LONG).show();


            }

    });
    }

    private boolean dataUploaded(String id) {
        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference("User");
        dbRef.child(id).setValue(user);

        return true;
    }

    private boolean validateInput(String nameIp, String dobIp, String emailIp, String mobileIp, String addressIp,String passwordIp,String confirmPassIp) {
        boolean result=true;

        if (nameIp.isEmpty()||nameIp==null||nameIp=="")
                result=false;
        if (dobIp.isEmpty() || dobIp==null || dobIp=="")
                result=false;
        if (mobileIp.isEmpty() || mobileIp==null || mobileIp=="")
                result=false;
        if (emailIp.isEmpty() || emailIp==null || emailIp=="")
                result=false;
        if (addressIp.isEmpty() || addressIp==null || addressIp=="")
                result=false;
        if (passwordIp.isEmpty() || passwordIp==null || passwordIp=="" || !(passwordIp.equals(confirmPassIp)))
                result=false;
        return  result;
    }


}
