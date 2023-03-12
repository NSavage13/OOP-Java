public class IncomingPhoneCall extends PhoneCall {

    public IncomingPhoneCall(String phoneNumber) {
        super(phoneNumber);
        setPrice(0.02); 
    }

    @Override
    public double getPrice() {
       return price; 
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String Display() {
        return "Incoming call from " + getPhoneNumber() + " at a rate of " + getPrice()+"¢" + " per minute. Total price: " + getPrice()+"¢\n";
    }

    

    

    

    

    
    
}
