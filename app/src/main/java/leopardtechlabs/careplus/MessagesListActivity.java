package leopardtechlabs.careplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MessagesListActivity extends AppCompatActivity {

    RecyclerView recyclerViewContainer;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_list);

        recyclerViewContainer=(RecyclerView)findViewById(R.id.recycleContainer);
        recyclerLayoutManager=new LinearLayoutManager(this);

        recyclerViewContainer.setLayoutManager(recyclerLayoutManager);

        recyclerAdapter = new MessageAdapter(this);

        recyclerViewContainer.setAdapter(recyclerAdapter);
    }
}
