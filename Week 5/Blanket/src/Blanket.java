public class Blanket {
    protected String size;
    protected String material;
    protected String color;
    protected double price;
    

    
    public Blanket(String size, String material, String color) {
        this.size = size;
        this.material = material;
        this.color = color;
    }
    public Blanket() {
        size = "Twin";
        color = "White";
        material = "Cotton";
        price = 30.00;
    }
    public void setColor(String color) {
        
    }
    public void setMaterial(String material) {
        switch(material.toLowerCase()) {
            case "cotton":
                this.material = "cotton";
                break;
            case "wool":
                this.material = "wool";
                this.price += 20.00;
                break;
            case "cashmere":
                this.material = "cashmere";
                this.price += 45.00;
                break;
            default:
                this.material = "cotton";
                break;
        }
    }

    public void setSize(String size) {
        switch(size.toLowerCase()) {
            case "twin":
                this.size = "Twin";
                this.price = 30.00;
                break;
            case "double":
                this.size = "Double";
                this.price += 10.00;
                break;
            case "queen":
                this.size = "Queen";
                this.price += 25.00;
                break;
            case "king":
                this.size = "King";
                this.price += 40.00;
                break;
            default:
                this.size = "Twin";
                this.price = 30.00;
                break;
        }
    }
    public String toString() {
        return String.format("%s %s blanket made of %s, $%.2f", size, color, material, price);
    }
    
    
    
}
