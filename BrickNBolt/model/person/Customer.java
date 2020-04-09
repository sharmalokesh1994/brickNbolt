package lok.ac.BrickNBolt.model.person;

import java.util.HashSet;
import java.util.Set;

public class Customer extends Person {

    private Set<Integer> products;

    public Customer(String name, String phNo, String emailID) {
        super(name, phNo, emailID);
        products = new HashSet<>();
    }

    // Checking User is already bought the product
    // than the referral will not work
    public boolean validateReferrals( int productID ){
        return !products.contains(productID);
    }

    public boolean buyProduct( int productId ){
        products.add(productId);
        return true;
    }

}
