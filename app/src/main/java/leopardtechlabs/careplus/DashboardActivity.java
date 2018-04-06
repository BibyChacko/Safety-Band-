package leopardtechlabs.careplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerLayoutManager;
    RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewContainer);
        recyclerLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(recyclerLayoutManager);


        recyclerAdapter=new DepartmentAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
