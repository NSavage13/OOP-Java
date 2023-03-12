public class OutgoingPhoneCall extends PhoneCall {
    private int time;
    public OutgoingPhoneCall(String phoneNumber, int time) {
        super(phoneNumber);
        this.time = time;
        setPrice(0.04);
        
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
        double totalAmount = getPrice() * time;
        if (totalAmount < 1){
        String underOne =  "Outgoing call from " + getPhoneNumber() + " at a rate of " + getPrice()+"¢" + " per minute.\nTotal minutes: " + time + " Total price: " + String.format("%.2f", getPrice()*time)+"¢\n";
        return underOne;
        }else 
        return "Outgoing call from " + getPhoneNumber() + " at a rate of " + getPrice()+"¢" + " per minute.\nTotal minutes: " + time + " Total price: $" + String.format("%.2f", getPrice()*time)+"\n";
        
        
    }
    
}
