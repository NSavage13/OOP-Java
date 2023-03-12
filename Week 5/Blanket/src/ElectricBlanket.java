public class ElectricBlanket extends Blanket {
    private int heat;
    private boolean shutoff;
    public ElectricBlanket() {
        super();
        heat = 1;
        shutoff = false;
    }
    public ElectricBlanket(Blanket Add,int heat, boolean isShutoff) {  
        size = Add.size;
        color = Add.color;
        material = Add.material;
        price = Add.price;
        setHeat(heat);
        setShutoff(isShutoff);
    }
    public int getHeat() {
        return heat;
    }
    public void setHeat(int heat) {
        if (heat > 5 || heat < 1){
            heat = 1;
        }else {
            this.heat = heat;
        }
    }
    public boolean isShutoff() {
        return shutoff;
    }
    public void setShutoff(boolean shutoff) {
        this.shutoff = shutoff;
        if (shutoff == true){
            price += 5.75;
        }
    }
    public String toString() {
        return String.format("%s %s blanket made of %s, $%.2f, Heat is %d, Shutoff feature is %s", size, color, material, price, heat, shutoff);

    }
}
