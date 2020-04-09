package lok.ac.BrickNBolt.dao;


import lok.ac.BrickNBolt.CustomException.CanNotBuyProduct;
import lok.ac.BrickNBolt.Services.ValidateReferral;
import lok.ac.BrickNBolt.model.Product;
import lok.ac.BrickNBolt.model.Referral;
import lok.ac.BrickNBolt.model.person.Customer;
import lok.ac.BrickNBolt.model.person.Referrer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// We can make this class Singletone class
public class DataLayer {

    static int discount=5000;
    static int referrerMoney=10000;

    private static DataLayer instance ;

    private Map<Integer,Product> products;
    private Map<Integer,Referrer> referrers;
    private Map<Integer, Customer> customers;
    private Map<Integer, Referral> referrals;

    private DataLayer(){
        products = new HashMap<>();
        referrers = new HashMap<>();
        customers = new HashMap<>();
        referrals = new HashMap<>();
    };


    public static DataLayer getInstance(){
        if( instance==null ){
            synchronized (DataLayer.class){
                if(instance==null){
                    instance = new DataLayer();
                }
            }
        }
        return instance;
    }

    public void addReferrer(Referrer referrer){
        referrers.put(referrer.getuID(),referrer);
    }

    public void addProduct(Product product){
        products.put(product.getuID(),product);
    }

    public void addCustomer(Customer customer){
        customers.put(customer.getuID(),customer);
    }

    public int referProduct( Referrer referrer, int product ){
        Referral referral =  referrer.getGenerateReferral( products.get(product) );
        referrals.put(referral.getuID(),referral);
        return referral.getuID();
    }

    public int buyProduct(Customer customer ,int referralId) throws CanNotBuyProduct {

        if(ValidateReferral.validateReferral(customer,referrals.get(referralId))){
            customer.buyProduct( referrals.get(referralId).getProduct().getuID() );

            Referral referral = referrals.get(referralId);
            referral.getCustomers().add(customer);
            referral.setTotal_used_count();
            Referrer referrer = referral.getReferrer();
            // We can use global variable
            referrer.updateBalance(referrerMoney);

            // the price is always more than 5000
            // we can create a stateless service for different strategies of product
            return referral.getProduct().getPrice()-discount;

        }else{
            return referrals.get(referralId).getProduct().getPrice();
        }

        /*//todo:
        // throw if the the user can not buy the product
        throw new CanNotBuyProduct("User can not buy the product");


         */
    }

    public void getBalance( int referrerId ){
        System.out.println(referrers.get(referrerId).getBalance());
    }

    public void viewReferrals(int referrerId){
        for( Referral referral : referrers.get(referrerId).getReferrals()){

            System.out.println( " referral ID "+ referral.getuID() + " is used "+ referral.getTotal_used_count()+" times and below customers used " );

            for( Customer customer : referral.getCustomers() ){
                System.out.println(customer.getName());
            }
        }
    }


}
