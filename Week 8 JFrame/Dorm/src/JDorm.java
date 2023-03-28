import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDorm extends JFrame {
    private JCheckBox privateRoomCheckBox, internetCheckBox, cableTvCheckBox, microwaveCheckBox, refrigeratorCheckBox;
    private JTextArea choicesTextArea;
    
    public JDorm() {
        super("Dorm Room Options");
        
        // Create checkboxes for room options
        privateRoomCheckBox = new JCheckBox("Private Room");
        internetCheckBox = new JCheckBox("Internet Connection");
        cableTvCheckBox = new JCheckBox("Cable TV Connection");
        microwaveCheckBox = new JCheckBox("Microwave");
        refrigeratorCheckBox = new JCheckBox("Refrigerator");
        
        // Create text area for displaying choices
        choicesTextArea = new JTextArea(5, 20);
        choicesTextArea.setEditable(false);
        JScrollPane choicesScrollPane = new JScrollPane(choicesTextArea);
        
        // Add item listeners to checkboxes
        privateRoomCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateChoices();
            }
        });
        internetCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateChoices();
            }
        });
        cableTvCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateChoices();
            }
        });
        microwaveCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateChoices();
            }
        });
        refrigeratorCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateChoices();
            }
        });
        
        // Create panel for checkboxes
        JPanel optionsPanel = new JPanel(new GridLayout(5, 1));
        optionsPanel.add(privateRoomCheckBox);
        optionsPanel.add(internetCheckBox);
        optionsPanel.add(cableTvCheckBox);
        optionsPanel.add(microwaveCheckBox);
        optionsPanel.add(refrigeratorCheckBox);
        
        // Add panels to content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(choicesScrollPane, BorderLayout.CENTER);
        getContentPane().add(optionsPanel, BorderLayout.WEST);
        
        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // Display initial choices
        updateChoices();
    }
    
    private void updateChoices() {
        String choices = "";
        if (privateRoomCheckBox.isSelected()) {
            choices += "Private room\n";
        }
        if (internetCheckBox.isSelected()) {
            choices += "Internet connection\n";
        }
        if (cableTvCheckBox.isSelected()) {
            choices += "Cable TV connection\n";
        }
        if (microwaveCheckBox.isSelected()) {
            choices += "Microwave\n";
        }
        if (refrigeratorCheckBox.isSelected()) {
            choices += "Refrigerator\n";
        }
        choicesTextArea.setText(choices);
    }
    
    public static void main(String[] args) {
        new JDorm();
    }
}
