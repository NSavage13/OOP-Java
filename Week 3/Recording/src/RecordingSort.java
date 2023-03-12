import java.util.Arrays;
import java.util.Scanner;

public class RecordingSort {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Recording[] recordings = new Recording[5];

    // Prompt the user for values for each recording
    for (int i = 0; i < recordings.length; i++) {
      System.out.println("Enter the title for recording " + (i + 1) + ":");
      String title = input.nextLine();
      System.out.println("Enter the artist for recording " + (i + 1) + ":");
      String artist = input.nextLine();
      System.out.println("Enter the playing time in seconds for recording " + (i + 1) + ":");
      int playingTime = input.nextInt();
      input.nextLine();
      recordings[i] = new Recording(title, artist, playingTime);
    }

    // Prompt the user for the field to sort by
    System.out.println("Sort recordings by (1) song title, (2) artist, or (3) playing time:");
    int sortBy = input.nextInt();
    input.nextLine();

    // Perform the sort
    switch (sortBy) {
      case 1:
        Arrays.sort(recordings, (a, b) -> a.getTitle().compareTo(b.getTitle()));
        break;
      case 2:
        Arrays.sort(recordings, (a, b) -> a.getArtist().compareTo(b.getArtist()));
        break;
      case 3:
        Arrays.sort(recordings, (a, b) -> Integer.compare(a.getPlayingTime(), b.getPlayingTime()));
        break;
    }

    // Display the sorted recordings
    System.out.println("Sorted Recordings:");
    for (Recording recording : recordings) {
      System.out.println("Title: " + recording.getTitle() + ", Artist: " + recording.getArtist() + ", Playing Time: " + recording.getPlayingTime() + " seconds");
    }
  }
}
