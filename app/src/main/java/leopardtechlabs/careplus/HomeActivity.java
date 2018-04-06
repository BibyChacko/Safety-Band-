package leopardtechlabs.careplus;

import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sababado.circularview.CircularView;
import com.sababado.circularview.Marker;
import com.sababado.circularview.SimpleCircularViewAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    CardView bookings,messages,live,call;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        bookings=(CardView)findViewById(R.id.bookings);
        messages=(CardView)findViewById(R.id.messages);
        live=(CardView)findViewById(R.id.live);
        call=(CardView)findViewById(R.id.call);

        bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityNavigation(DashboardActivity.class);
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityNavigation(MessagesListActivity.class);
            }
        });
    }

    private void activityNavigation(Class destinationActivityClass) {
        Intent intent=new Intent(HomeActivity.this,destinationActivityClass);
        startActivity(intent);
    }


}
