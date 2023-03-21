package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {
    //---------------------------------------1- variable ları olustur.--------------------------------------------------
    private String checkin;
    private String checkout;
    //---------------------------------------2- bos constructor olustur.------------------------------------------------
    public BookingDatesPojo() {
    }
    //----------------------------------------3- dolu constructor olustur.----------------------------------------------
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
    //-----------------------------------------4- getter-setter olustur.------------------------------------------------
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    //----------------------------------------5- pojoclass yazdırmak ıcın "toString"------------------------------------
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
    //------------------------------------------------------------------------------------------------------------------
}