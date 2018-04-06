package leopardtechlabs.careplus;

import android.util.Log;

/**
 * Created by bibyc on 2/24/2018.
 */


public class DoctorDetailsClass {

    String Name,Specialization,Endtime,Starttime;


    public DoctorDetailsClass(String Endtime,String Name,String Specialization,String Starttime) {
        this.Name = Name;
        this.Specialization = Specialization;
        this.Endtime = Endtime;
        this.Starttime = Starttime;

    }

    public String getName() {
        return Name;
    }

    public String getQualification() {
        return Specialization;
    }

    public String getStartTime() {
        return Starttime;
    }



    public String getEndtime() {
        return Endtime;
    }
}
