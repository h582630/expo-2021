package expo2021.prosjektexpo2021.v2.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vote {
    @Id
    int phonenumber;
    int value;

    public Vote(int value, int phonenumber){
        this.value = value;
        this.phonenumber = phonenumber;
    }

    public Vote(){

    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
