public abstract class Book {
    private String title;
    protected double price;


    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    public double getPrice() {
        return price;
    }
    // Abstract Method
    public abstract void setPrice();

  
}
