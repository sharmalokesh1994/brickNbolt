package lok.ac.BrickNBolt;

import lok.ac.BrickNBolt.CustomException.CanNotBuyProduct;
import lok.ac.BrickNBolt.dao.DataLayer;
import lok.ac.BrickNBolt.model.Product;
import lok.ac.BrickNBolt.model.person.Customer;
import lok.ac.BrickNBolt.model.person.Referrer;

public class Client {

    public static void main(String[] args)  {

        Referrer referrer1 = new Referrer("ref1","1234","asd");
        Customer customer1 = new Customer("c1","1234","asd");
        Customer customer2 = new Customer("c2","1234","asd");
        Customer customer3 = new Customer("c3","1234","asd");

        DataLayer dataLayer = DataLayer.getInstance();
        // Products will be a
        for(int i=1;i<10;i++){
            dataLayer.addProduct( new Product("prod"+i,50000*i) );
        }

        dataLayer.addCustomer(customer1);
        dataLayer.addCustomer(customer2);
        dataLayer.addCustomer(customer3);

        dataLayer.addReferrer(referrer1);

        int refId = dataLayer.referProduct(referrer1,1);


        try {
            dataLayer.buyProduct(customer1,refId);
            dataLayer.buyProduct(customer1,refId);
            dataLayer.buyProduct(customer2,refId);
            //dataLayer.buyProduct(customer3,refId);
            dataLayer.buyProduct(customer2,refId);
            dataLayer.buyProduct(customer1,refId);
        } catch (CanNotBuyProduct canNotBuyProduct) {
            canNotBuyProduct.printStackTrace();
        }

        dataLayer.getBalance(referrer1.getuID());

        dataLayer.viewReferrals(referrer1.getuID());

    }

}
