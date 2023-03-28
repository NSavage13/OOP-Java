import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JInsurance extends JFrame {
    private JCheckBox dentalCheckBox, visionCheckBox;
    private JRadioButton hmoRadioButton, ppoRadioButton;
    private JButton submitButton;
    private double price;
    
    public JInsurance() {
        super("Insurance Application");
        
        // Create checkboxes for insurance options
        dentalCheckBox = new JCheckBox("Dental");
        visionCheckBox = new JCheckBox("Vision");
        

        
        // Create radio buttons for insurance types
        hmoRadioButton = new JRadioButton("HMO");
        ppoRadioButton = new JRadioButton("PPO");
        
        // Add radio buttons to button group
        ButtonGroup insuranceTypeGroup = new ButtonGroup();
        insuranceTypeGroup.add(hmoRadioButton);
        insuranceTypeGroup.add(ppoRadioButton);
        
        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                price = 0;
                // Get selected options
                String selectedInsuranceType = "";
                if (hmoRadioButton.isSelected()) {
                    selectedInsuranceType = "HMO";
                    price += 200;
                } else if (ppoRadioButton.isSelected()) {
                    selectedInsuranceType = "PPO";
                    price += 600;
                }

                String selectedInsuranceOptions = "";
                if (dentalCheckBox.isSelected()) {
                    selectedInsuranceOptions += "Dental, ";
                    price += 75;
                }
                if (visionCheckBox.isSelected()) {
                    selectedInsuranceOptions += "Vision, ";
                    price += 20;
                }
                if (selectedInsuranceOptions.length() > 0) {
                    selectedInsuranceOptions = selectedInsuranceOptions.substring(0, selectedInsuranceOptions.length() - 2);
                }
                
                // Display selected options
                JOptionPane.showMessageDialog(JInsurance.this, "You selected:\n" + selectedInsuranceType + " insurance\n" + selectedInsuranceOptions + " coverage\n" + price + " price");
            }
        });
        
        // Create panel for checkboxes
        JPanel insuranceOptionsPanel = new JPanel(new GridLayout(2, 1));
        insuranceOptionsPanel.add(dentalCheckBox);
        insuranceOptionsPanel.add(visionCheckBox);
        
        
        // Create panel for radio buttons
        JPanel insuranceTypePanel = new JPanel(new GridLayout(1, 2));
        insuranceTypePanel.add(hmoRadioButton);
        insuranceTypePanel.add(ppoRadioButton);
        
        // Create panel for submit button
        JPanel submitPanel = new JPanel(new FlowLayout());
        submitPanel.add(submitButton);
        
        // Add panels to content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(insuranceOptionsPanel, BorderLayout.WEST);
        getContentPane().add(insuranceTypePanel, BorderLayout.CENTER);
        getContentPane().add(submitPanel, BorderLayout.SOUTH);
        
        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new JInsurance();
    }
}
