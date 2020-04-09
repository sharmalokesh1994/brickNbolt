package lok.ac.BrickNBolt.model.person;


abstract public class Person {

    private int uID;
    private String name;
    private String phNo;
    private String emailID;

    // for uniqueness of uID
    private static int UID = 1;

    public Person(String name, String phNo, String emailID) {

        setName(name);
        setPhNo(phNo);
        setEmailID(emailID);

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

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public int getuID() {
        return uID;
    }


}
