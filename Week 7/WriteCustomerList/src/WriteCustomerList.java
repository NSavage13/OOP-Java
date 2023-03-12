import java.io.*;
import java.util.ArrayList;

public class WriteCustomerList {

    public static void main(String[] args) throws Exception {
        ArrayList<CustomerInfo> cList = new ArrayList<>();
        cList.add(new CustomerInfo());
        cList.add(new CustomerInfo());
        FileWriter e = new FileWriter("customerList.txt");
        e.write(cList.toString());
        e.close();
    }
}
