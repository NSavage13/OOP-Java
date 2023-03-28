import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountryCapital extends JFrame implements ActionListener {
    String[] country = { "USA", "Canada", "Russia", "China", "Mexico", "Italy", "Ireland" };
    String[] capitals = { "Washington DC", "Ottawa", "Moscow", "Beijing", "Mexico City", "Rome", "Dublin" };
    JLabel countryLabel = new JLabel("Countries");
    JComboBox<String> box = new JComboBox<>(country);
    private String choice;
    JButton submit;

    public CountryCapital() {
        super("Country Capitals");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridBagLayout());
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        add(countryLabel);
        add(box);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        choice = (String) box.getSelectedItem();

        for (int i = 0; i < country.length; i ++){
            if (choice.equals(country[i])){
                JOptionPane.showMessageDialog(this, capitals[i]);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        CountryCapital one = new CountryCapital();
    }
}
