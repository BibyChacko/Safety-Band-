package leopardtechlabs.careplus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bibyc on 2/24/2018.
 */

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorListViewHolder> {

    ArrayList<DoctorDetailsClass> doctorDetailsClasses=new ArrayList<>();
    int[] img_location={R.drawable.mohan,R.drawable.mamooty,R.drawable.aamir,R.drawable.mohan};

    public DoctorListAdapter(ArrayList<DoctorDetailsClass> doctorDetailsClasses) {
        this.doctorDetailsClasses = doctorDetailsClasses;

    }


    public class DoctorListViewHolder extends RecyclerView.ViewHolder {

        TextView name,qualification,time;
        Button bookNow;
        CircleImageView photo;

        public DoctorListViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.name);
            qualification=(TextView)itemView.findViewById(R.id.qualification);
            time=(TextView)itemView.findViewById(R.id.time);
            bookNow=(Button) itemView.findViewById(R.id.book_now);
            photo=(CircleImageView) itemView.findViewById(R.id.photo);

        }
    }

    @Override
    public DoctorListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_doctor_detail,parent,false);
            DoctorListViewHolder holder=new DoctorListViewHolder(view);
            return holder;
    }

    @Override
    public void onBindViewHolder(DoctorListViewHolder holder, int position) {
            DoctorDetailsClass doctor=doctorDetailsClasses.get(position);
            holder.name.setText(doctor.getName());
            holder.time.setText("Time: "+doctor.getStartTime()+"-"+doctor.getEndtime());
            holder.qualification.setText(doctor.getQualification());
            holder.photo.setImageResource(img_location[position]);

    }

    @Override
    public int getItemCount() {
       return doctorDetailsClasses.size();
    }


}
