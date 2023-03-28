import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JLottery2 extends JFrame implements ActionListener {

    private JCheckBox[] checkBoxes;
    private JLabel[] numberLabels;
    private JButton playButton;
    private JLabel resultLabel;

    public JLottery2() {
        setTitle("JLottery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Create check boxes for numbers 0-30
        checkBoxes = new JCheckBox[31];
        for (int i = 0; i <= 30; i++) {
            checkBoxes[i] = new JCheckBox("" + i);
            checkBoxes[i].addActionListener(this);
            add(checkBoxes[i]);
        }

        // Create labels for lottery numbers
        numberLabels = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            numberLabels[i] = new JLabel();
            add(numberLabels[i]);
        }

        // Create play button
        playButton = new JButton("Play");
        playButton.addActionListener(this);
        add(playButton);

        // Create result label
        resultLabel = new JLabel();
        add(resultLabel);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            // Count number of selected check boxes
            int count = 0;
            for (int i = 0; i <= 30; i++) {
                if (checkBoxes[i].isSelected()) {
                    count++;
                }
            }

            if (count != 6) {
                JOptionPane.showMessageDialog(this, "Please select exactly 6 numbers.");
            } else {
                // Generate random lottery numbers
                int[] lotteryNumbers = new int[6];
                Random rand = new Random();
                Set<Integer> uniqueNumbers = new HashSet<>();
                while (uniqueNumbers.size() < 6) {
                    uniqueNumbers.add(rand.nextInt(31));
                }
                int i = 0;
                for (int number : uniqueNumbers) {
                    lotteryNumbers[i++] = number;
                }

                // Display lottery numbers
                for (int j = 0; j < 6; j++) {
                    numberLabels[j].setText("" + lotteryNumbers[j]);
                }

                // Check how many numbers match
                int matches = 0;
                for (int j = 0; j < 6; j++) {
                    if (checkBoxes[lotteryNumbers[j]].isSelected()) {
                        matches++;
                    }
                }

                // Determine award amount
                int award = 0;
                switch (matches) {
                    case 3:
                        award = 100;
                        break;
                    case 4:
                        award = 10000;
                        break;
                    case 5:
                        award = 50000;
                        break;
                    case 6:
                        award = 1000000;
                        break;
                }

                // Display result
                resultLabel.setText("Matching Numbers: " + matches + "\nAward: $" + award);
            }
        }
    }

    public static void main(String[] args) {
        new JLottery2();
    }
}

