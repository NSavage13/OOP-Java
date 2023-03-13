import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuizUsingFile {

    public static void main(String[] args) {
        // Read previous high score from file
        int previousHighScore = readHighScoreFromFile();

        // Quiz questions
        String[] questions = {
            "What is the capital city of Spain?",
            "What is the largest country in South America?",
            "What is the smallest country in the world?",
            "What is the highest mountain in Africa?",
            "What is the longest river in the world?",
            "What is the largest desert in the world?",
            "What is the only continent with no permanent ice?",
            "What is the only country to border both the Atlantic and Pacific oceans?",
            "What is the largest island in the world?",
            "What is the name of the sea that lies between Europe and Africa?",
        };

        // Quiz choices
        String[][] choices = {
            {"Madrid", "Barcelona", "Seville", "Valencia"},
            {"Brazil", "Argentina", "Colombia", "Peru"},
            {"Monaco", "Nauru", "Tuvalu", "Vatican City"},
            {"Kilimanjaro", "Mount Kenya", "Mount Stanley", "Mount Meru"},
            {"Nile", "Amazon", "Yangtze", "Mississippi"},
            {"Sahara", "Gobi", "Arabian", "Kalahari"},
            {"Australia", "South America", "Africa", "Antarctica"},
            {"Russia", "Canada", "United States", "China"},
            {"Greenland", "Borneo", "Madagascar", "New Guinea"},
            {"Mediterranean", "Black", "Red", "Arabian"},
        };

        // Quiz answers
        int[] answers = {0, 0, 3, 0, 0, 0, 3, 1, 0, 0};

        // Quiz score
        int score = 0;

        // Quiz loop
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < choices[i].length; j++) {
                System.out.println((j) + ". " + choices[i][j]);
            }
            int answer = scanner.nextInt();
            if (answer == answers[i]) {
                score++;
            }
        }

        // Display score and high score
        System.out.println("Score: " + score);
        System.out.println("Previous high score: " + previousHighScore);

        // Write new high score to file if it is higher than previous high score
        if (score > previousHighScore) {
            writeHighScoreToFile(score);
            System.out.println("New high score!");
        }
    }

    private static int readHighScoreFromFile() {
        try {
            Scanner scanner = new Scanner(new File("highscore.txt"));
            return scanner.nextInt();
        } catch (FileNotFoundException e) {
            return 0;
        }
    }

    private static void writeHighScoreToFile(int highScore) {
        try {
            FileWriter writer = new FileWriter("highscore.txt");
            writer.write(Integer.toString(highScore));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing high score to file");
        }
    }
}
