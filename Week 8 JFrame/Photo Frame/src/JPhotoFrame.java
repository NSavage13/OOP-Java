import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Create an application for Paula’s Portraits, a photography studio. The application allows users to compute the price of a photography session. Paula’s base price is $40 for an in-studio photo session with one person. The in-studio fee is $75 for a session with two or more subjects, and $95 for a session with a pet. A $90 fee is added to take photos on location instead of in the studio. Include a set of mutually exclusive check boxes to select the portrait subject and another set for the session location. Include labels as appropriate to explain the application’s functionality. Save the file as JPhotoFrame.java
 * 
 */

public class JPhotoFrame extends JFrame implements ActionListener {
    private JCheckBox oneBox, multiBox, petBox;
    private JCheckBox inStudioBox, onLocationBox;
    private JButton calcButton;
    private JLabel resultLabel;
    

    public JPhotoFrame(){
        setTitle("Paula's Portraits");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        oneBox = new JCheckBox("One person ($40)");
        multiBox = new JCheckBox("Two or more people ($75)");
        petBox = new JCheckBox("Pet ($95)");
        inStudioBox = new JCheckBox("In-studio ($0)");
        onLocationBox = new JCheckBox("On location ($90)");
        calcButton = new JButton("Calculate");
        resultLabel = new JLabel(" ");

        JPanel mainPanel = new JPanel(new FlowLayout());
        JPanel subjectPanel = new JPanel(new GridLayout(1, 4));
        JPanel locationPanel = new JPanel(new GridLayout(1, 3));
        JPanel buttonPanel = new JPanel(new GridLayout(1,1));
        
        subjectPanel.add(oneBox);
        subjectPanel.add(multiBox);
        subjectPanel.add(petBox);
        locationPanel.add(inStudioBox);
        locationPanel.add(onLocationBox);
        buttonPanel.add(calcButton); 

        mainPanel.add(new JLabel("Select portrait subject:"));
        mainPanel.add(subjectPanel);
        mainPanel.add(new JLabel("Select session location:"));
        mainPanel.add(locationPanel);
        mainPanel.add(buttonPanel);
        
        add(mainPanel);
        add(resultLabel, BorderLayout.SOUTH);
        
        calcButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int basePrice = 0;
        if (oneBox.isSelected()) {
            basePrice = 40;
        } else if (multiBox.isSelected()) {
            basePrice = 75;
        } else if (petBox.isSelected()) {
            basePrice = 95;
        }
        int locationFee = 0;
        if (onLocationBox.isSelected()) {
            locationFee = 90;
        }
        int totalPrice = basePrice + locationFee;
        JOptionPane.showMessageDialog(JPhotoFrame.this, String.format("Total price: $%d", totalPrice));
        
    }
    
    public static void main(String[] args) {
        JPhotoFrame frame = new JPhotoFrame();
        frame.setVisible(true);
    }

    
}
