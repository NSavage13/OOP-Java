import java.util.Scanner;

class SecretPhrase {
    public static void main(String[] args) {
        String answer = "You suck";
        String hint = "*** **c*";
        Scanner input = new Scanner(System.in);
        System.out.println("Lets play Hangman!");
        System.out.println("");
        System.out.println(hint);
        System.out.println("");

        while (!answer.equals(hint)) {
            
            System.out.println("Guess a letter:");
            String guess = input.nextLine();
            char letter = guess.charAt(0);

            if (answer.contains(String.valueOf(letter))) {
                for (int i = 0; i < answer.length(); i++) {
                    if (answer.charAt(i) == letter) {
                        hint = hint.substring(0, i) + letter + hint.substring(i+1);
                    }
                }
                System.out.println("Correct! The phrase is now: " + hint);
            } else {
                System.out.println("Incorrect. The letter " + letter + " is not in the phrase.");
            }
        }
        System.out.println("Congratulations! You have guessed the phrase: " + answer);

        input.close();
    }
}
