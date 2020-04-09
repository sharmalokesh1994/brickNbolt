package lok.ac.BrickNBolt.model.person;

import lok.ac.BrickNBolt.model.Product;
import lok.ac.BrickNBolt.model.Referral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// In DB it will be created new table which extends Person
public class Referrer extends Person {

    private List<Referral> referrals;
    private int balance;

    public Referrer(String name, String phNo, String emailID) {
        super(name, phNo, emailID);
        referrals = new ArrayList<>();
        balance = 0;
    }

    public void updateBalance(int balance){
        this.balance = this.balance+balance;
    }

    public int getBalance(){
        return balance;
    }
    // to generate referrals
    public Referral getGenerateReferral(Product product){
        //todo: if we use db we will check the referral Id is generated for that product or not

        Referral referral = new Referral(product,this);
        referrals.add(referral);
        return referral;
    }

    // to view the referrals
    public List<Referral> getReferrals() {
        return referrals;
    }
}
