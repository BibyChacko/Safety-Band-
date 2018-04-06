package leopardtechlabs.careplus;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by bibyc on 2/24/2018.
 */

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder> {

    int[] imageLocation={R.drawable.clinicalmedicine,R.drawable.gynecology_icon,R.drawable.pedia_icon,R.drawable.orthopedics,R.drawable.health_cardiology};
    String[] departmentName={"General Medicine","Gynaecologist","Pediatrics","Otrhopedics","Cardiology"};

    Context context;

    DepartmentAdapter(Context context){
        this.context=context;
    }

    public class DepartmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        String date;
        int year,month,day;
        ImageView imageView;
        TextView textView;

        public DepartmentViewHolder(View itemView) {
            super(itemView);


            imageView=itemView.findViewById(R.id.image_describe);
            textView=itemView.findViewById(R.id.text_describe);
            imageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position=getAdapterPosition();
            pickDate(position);



        }


        private void pickDate(final int position) {
            Calendar calendar=Calendar.getInstance();
            year= calendar.get(Calendar.YEAR);
            month=calendar.get(Calendar.MONTH);
            day=calendar.get(Calendar.DATE);

            DatePickerDialog datePicker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int myear, int mmonth, int mday) {
                    year = myear;
                    month = mmonth+1;
                    day = mday;

                    String monthModified=String.valueOf(month),dateModified=String.valueOf(day);
                    if (month<10)
                        monthModified="0"+month;
                    if (day<10)
                        dateModified="0"+day;

                    date =year+"-"+monthModified+"-"+dateModified;

                    activityNavigation(context,position);

                }
            }, year, month, day);
            datePicker.show();

        }

        private void activityNavigation(Context context, int position) {
            Intent intent=new Intent(context,DoctorListActivity.class);
            intent.putExtra("department",departmentName[position]);
            intent.putExtra("date",date);
            context.startActivity(intent);
        }

    }




    @Override
    public DepartmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewdepartment,parent,false);
        DepartmentViewHolder holder=new DepartmentViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(DepartmentViewHolder holder, int position) {
                holder.textView.setText(departmentName[position]);
                holder.imageView.setImageResource(imageLocation[position]);
    }

    @Override
    public int getItemCount() {
        return  imageLocation.length;
    }


}
