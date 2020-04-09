package lok.ac.BrickNBolt.model;

import lok.ac.BrickNBolt.model.person.Customer;
import lok.ac.BrickNBolt.model.person.Referrer;

import java.util.ArrayList;
import java.util.List;

public class Referral {

    private int uID;
    private Product product;
    private Referrer referrer;
    private List<Customer> customers;

    // for uniqueness of uID
    private static int UID = 1;

    private int total_used_count = 0;

    public Referral(Product product, Referrer referrer) {
        this.product = product;
        this.referrer = referrer;
        customers = new ArrayList<>();
        setuID();
    }

    private void setuID() {
        this.uID = UID++;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Referrer getReferrer() {
        return referrer;
    }

    public void setReferrer(Referrer referrer) {
        this.referrer = referrer;
    }

    public int getTotal_used_count() {
        return total_used_count;
    }

    public void setTotal_used_count() {
        this.total_used_count++;
    }

    public int getuID() {
        return uID;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
