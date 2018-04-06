package leopardtechlabs.careplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DoctorListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerLayoutManager;
    RecyclerView.Adapter recyclerAdapter;

    ArrayList<DoctorDetailsClass> doctorDetail=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        Intent intent=getIntent();
        String deptartment=intent.getStringExtra("department");
        String date=intent.getStringExtra("date");

        recyclerView=(RecyclerView)findViewById(R.id.doctor_list_container);
        recyclerLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        fetchData(deptartment,date);




        recyclerAdapter=new DoctorListAdapter(doctorDetail);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void fetchData(String deptartment,String date) {

        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference("Doctors/"+date+"/"+deptartment);
        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    DoctorDetailsClass doctor=(DoctorDetailsClass) dataSnapshot.getValue(DoctorDetailsClass.class);
                    String et=doctor.getEndtime();
                    et+="";

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
