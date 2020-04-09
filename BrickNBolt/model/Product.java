package lok.ac.BrickNBolt.model;

public class Product {

    private int uID;
    private String name;
    private int price;

    // for uniqueness of uID
    private static int UID = 1;

    //todo:add other variables,type, quality,description, brand etc..,
    // we can use builder design pattern to create the product object
    public Product(String name, int price) {
        this.name = name;
        this.price = price;

        setuID();
    }

    private void setuID() {
        this.uID = UID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //todo : We an add one more layer of Validation
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getuID() {
        return uID;
    }
}
