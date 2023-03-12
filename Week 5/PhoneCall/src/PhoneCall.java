public abstract class PhoneCall{
    protected String phoneNumber;
    protected double price;

    public PhoneCall(String phoneNumber){
        this.phoneNumber = phoneNumber;
        this.price = 0.0;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double getPrice();
    public abstract String getPhoneNumber();
    public abstract String Display();
    

}

