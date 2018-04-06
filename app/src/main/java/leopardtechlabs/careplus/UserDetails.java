package leopardtechlabs.careplus;

/**
 * Created by bibyc on 3/1/2018.
 */

public class UserDetails
{
    String nameIp,dobIp,emailIp,mobileIp,addressIp,passwordIp,imageEncoded,gender;

    public UserDetails(){}
    public UserDetails(String nameIp, String dobIp, String emailIp, String mobileIp, String addressIp, String passwordIp, String imageEncoded,String gender) {
        this.nameIp = nameIp;
        this.dobIp = dobIp;
        this.emailIp = emailIp;
        this.mobileIp = mobileIp;
        this.addressIp = addressIp;
        this.passwordIp = passwordIp;
        this.imageEncoded = imageEncoded;
        this.gender=gender;
    }

    public String getNameIp() {
        return nameIp;
    }

    public String getAddressIp() {
        return addressIp;
    }

    public String getImageEncoded() {
        return imageEncoded;
    }
}
