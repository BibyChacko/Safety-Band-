package leopardtechlabs.careplus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by bibyc on 3/13/2018.
 */

class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {

    Context context;
    ArrayList<MessagesClass> messageList =new ArrayList<>();

    public MessageAdapter(Context context) {
        this.context=context;
    }

    class  MessageAdapterViewHolder extends RecyclerView.ViewHolder{


        public MessageAdapterViewHolder(View itemView) {
            super(itemView);
        }


    }

    @Override
    public MessageAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_message_list_item,parent,false);
        MessageAdapterViewHolder holder=new MessageAdapterViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MessageAdapterViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
