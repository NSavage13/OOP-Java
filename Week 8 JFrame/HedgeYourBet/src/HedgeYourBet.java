import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HedgeYourBet extends JFrame implements ActionListener {
  
  private final String[] questions = {
    "Which state is known for its beaches and Disneyland?",
    "Which state is known for its theme parks and alligators?",
    "Which state is known for its big city and Statue of Liberty?",
    "Which state is known for its hot dogs and Broadway?",
    "Which state is known for the Lakers?"
  };
  
  private final String[][] choices = {
    {"California", "Florida", "New York"},
    {"California", "Florida", "New York"},
    {"California", "Florida", "New York"},
    {"California", "Florida", "New York"},
    {"California", "Florida", "New York"}
  };
  
  private final int[] answers = {1, 2, 3, 2, 1};
  
  private int score = 0;
  private static final String SCORE_FILE = "score.txt";
  private JLabel[] questionLabels = new JLabel[5];
  private JCheckBox[][] choiceCheckBoxes = new JCheckBox[5][3];
  private JButton submitButton = new JButton("Submit");
  
  public HedgeYourBet() {
    super("Hedge Your Bet Quiz");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(6, 1));
    
    // create the question and choice labels and checkboxes for each question
    for (int i = 0; i < 5; i++) {
      questionLabels[i] = new JLabel((i + 1) + ". " + questions[i]);
      add(questionLabels[i]);
      JPanel choicePanel = new JPanel();
      for (int j = 0; j < 3; j++) {
        choiceCheckBoxes[i][j] = new JCheckBox(choices[i][j]);
        choicePanel.add(choiceCheckBoxes[i][j]);
      }
      add(choicePanel);
    }
    
    // add the submit button and register the action listener
    add(submitButton);
    submitButton.addActionListener(this);

    try {
        FileInputStream fileStream = new FileInputStream(SCORE_FILE);
        DataInputStream dataStream = new DataInputStream(fileStream);
        score = dataStream.readInt();
        dataStream.close();
      } catch (IOException e) {
        // If the file doesn't exist or an error occurs, the score is already set to 0
      }
  
      // Display the player's previous score
      JOptionPane.showMessageDialog(this, "Your previous score is: " + score);
    
    pack();
    setLocationRelativeTo(null); // center the window
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    // process the user's answers and update the score
    for (int i = 0; i < 5; i++) {
      int numChecked = 0;
      int correctChecked = 0;
      for (int j = 0; j < 3; j++) {
        if (choiceCheckBoxes[i][j].isSelected()) {
          numChecked++;
          if (j + 1 == answers[i]) {
            correctChecked++;
          }
        }
      }
      if (numChecked == 1 && correctChecked == 1) {
        score += 5;
      } else if (numChecked == 2 && correctChecked == 1) {
        score += 2;
      } else if (numChecked == 3) {
        score += 1;
      }
    }
    
    // display the score message
    if (score > 21) {
      JOptionPane.showMessageDialog(this, "Fantastic!");
      
    } else if (score > 15) {
      JOptionPane.showMessageDialog(this, "Very good.");
      
    } else {
      JOptionPane.showMessageDialog(this, "Just OK.");
      
    }
    JOptionPane.showMessageDialog(this, "Your score was " + score + "/25");
    
    
    try {
        FileOutputStream fileStream = new FileOutputStream(SCORE_FILE);
        DataOutputStream dataStream = new DataOutputStream(fileStream);
        dataStream.writeInt(score);
        dataStream.close();
      } catch (IOException ex) {
        System.out.println("Error saving score: " + ex.getMessage());
      }

  }
  
  public static void main(String[] args) {
    new HedgeYourBet();
  }
}
