import java.util.Scanner;

public class DemoPhoneCalls {
    static public Scanner input = new Scanner(System.in);
    static PhoneCall call;

    
    public static void main(String[] args){

        while(true){
            
            System.out.println("Enter (I) for INCOMING CALL\nEnter (O) for OUTGOING CALLS\nEnter (EXIT) to quit");
            System.out.print(">> ");
            String typeCall = input.nextLine();
            //Need to be able to keep inserting type of call
            System.out.println("");

            if (typeCall.equalsIgnoreCase("Exit")){
                break;

            }else if (typeCall.equalsIgnoreCase("I")){
                System.out.println("Enter phone number");
                System.out.print(">> ");
                String phoneNum = input.nextLine();
                call = new IncomingPhoneCall(phoneNum);  
                System.out.println(call.Display());  
                
            }else if(typeCall.equalsIgnoreCase("O")){
                System.out.println("Enter phone number");
                System.out.print(">> ");
                String phoneNum = input.nextLine();
                System.out.print("Enter the amount of time\n>>");
                int callTime = input.nextInt();
                
                call = new OutgoingPhoneCall(phoneNum, callTime);
                System.out.println(call.Display());
                
            }else {
                input.next();
                System.out.println("invalid");
            }

        }
        
        
        
    }
    
}
