import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LastManStanding extends JFrame implements ActionListener {

    private JButton btnTurn;
    private JCheckBox[] checkBoxes;
    private JLabel lblStatus;
    private boolean playerTurn;

    public LastManStanding() {
        super("Last Man Standing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the check boxes
        checkBoxes = new JCheckBox[10];
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox();
        }

        // Create the turn button
        btnTurn = new JButton("Take Turn");
        btnTurn.addActionListener(this);

        // Create the status label
        lblStatus = new JLabel("Player's turn");

        // Add the components to the frame
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel checkBoxPanel = new JPanel(new GridLayout(2, 5));
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxPanel.add(checkBoxes[i]);
        }
        panel.add(checkBoxPanel);
        panel.add(btnTurn);
        add(panel, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.SOUTH);

        // Set initial player turn to true
        playerTurn = true;

        // Set the size and show the frame
        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTurn) {
            int boxesToRemove = 1;
            if (playerTurn) {
                // Get the number of boxes to remove
                boxesToRemove = Integer.parseInt(JOptionPane.showInputDialog(this, "How many boxes do you want to remove? (1-3)", "1"));

                // Validate input
                if (boxesToRemove < 1 || boxesToRemove > 3) {
                    JOptionPane.showMessageDialog(this, "Please enter a number between 1 and 3.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Remove boxes
            int boxesRemoved = 0;
            for (int i = 0; i < checkBoxes.length; i++) {
                if (checkBoxes[i].isSelected()) {
                    checkBoxes[i].setSelected(false);
                    boxesRemoved++;
                }

                if (boxesRemoved == boxesToRemove) {
                    break;
                }
            }

            // Switch player turn
            playerTurn = !playerTurn;

            // Check if game is over
            if (getRemainingBoxes() == 1) {
                // Game over, determine winner
                if (playerTurn) {
                    JOptionPane.showMessageDialog(this, "Congratulations! You won!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Sorry, you lost. Better luck next time!", "Loser", JOptionPane.INFORMATION_MESSAGE);
                }
                System.exit(0);
            }

            // Computer's turn
            if (!playerTurn) {
                int computerBoxesToRemove = (int) (Math.random() * 3) + 1;
                lblStatus.setText("Computer removed " + computerBoxesToRemove + " boxes.");
                actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            } else {
                lblStatus.setText("Player's turn");
            }
        }
    }

    private int getRemainingBoxes() {
        int remaining = 0;
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                remaining++;
            }
        }
        return remaining;
    }

    public static void main(String[] args) {
        new LastManStanding();
    }
}
