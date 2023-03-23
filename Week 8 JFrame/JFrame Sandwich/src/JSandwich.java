import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JSandwich extends JFrame implements ActionListener {
    private double price;
    private String ingredientChoice, breadChoice;
    private String[] ingredients = {"Chicken", "Ham", "Turkey"};
    private double[] ingredientsPrice = {5.00, 5.50, 6.00};
    private String[] bread = {"White", "Wheat", "Rye"};
    private double[] breadPrice = {2.00, 2.50, 3.00};

    private JLabel ingredientLabel, breadLabel, priceLabel;
    private JComboBox<String> ingredientBox, breadBox;
    private JButton priceButton;

    public JSandwich(){
        super("Sublime Sandwich Shop");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        ingredientLabel = new JLabel("Main Ingredients");
        breadLabel = new JLabel("Bread Type");
        priceLabel = new JLabel("Price ");
        ingredientBox = new JComboBox<>(ingredients);
        breadBox = new JComboBox<>(bread);
        priceButton = new JButton("Calculate Price");
        priceButton.addActionListener(this);

        add(ingredientLabel);
        add(ingredientBox);
        add(breadLabel);
        add(breadBox);
        add(priceLabel);
        add(priceButton);

        setVisible(true);

        


        
    }

    public void actionPerformed(ActionEvent e){
        ingredientChoice = (String) ingredientBox.getSelectedItem();
        breadChoice = (String) breadBox.getSelectedItem();

        calculatePrice();
        priceLabel.setText("Price: $" + String.format("%.2f", price));

    }

    public void calculatePrice(){
        double ingrPrice = 0;
        double brePrice = 0;

        for (int i = 0; i < ingredients.length; i++){
            if (ingredientChoice.equals(ingredients[i])){
                ingrPrice = ingredientsPrice[i];
                break;
            }
        }

        for (int i = 0; i < bread.length; i ++){
            if (breadChoice.equals(bread[i])){
                brePrice = breadPrice[i];
                break;
            }
        }

        price = ingrPrice + brePrice;
    }

    public static void main(String[] args) {
        new JSandwich();
    }
    
}
