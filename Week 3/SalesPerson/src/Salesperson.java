public class Salesperson {
    public int id;
    private double annSalesAmount;
    private int idNumber;
    
    
    public Salesperson(int idNumber, double annSalesAmount) {
        this.annSalesAmount = annSalesAmount;
        this.idNumber = idNumber;
    }
    public int getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    
    public double getAnnSalesAmount() {
        return annSalesAmount;
    }
    public void setAnnSalesAmount(double annSalesAmount) {
        this.annSalesAmount = annSalesAmount;
    }
}