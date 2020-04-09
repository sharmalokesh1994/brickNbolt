package lok.ac.BrickNBolt.Services;

import lok.ac.BrickNBolt.model.Referral;
import lok.ac.BrickNBolt.model.person.Customer;

// We can right Stateless Service here
public class ValidateReferral {

    public static boolean validateReferral(Customer customer, Referral referral){
        return customer.validateReferrals(referral.getProduct().getuID());
    }

}
