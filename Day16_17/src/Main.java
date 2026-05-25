import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String filePath =
                "C:/Users/Abinaya S/OneDrive/Desktop/JAVA/Linear_Binary_Search/Day16_17/src/large_text_file.txt";

        System.out.println("Enter word to search:");
        String targetWord = sc.nextLine().toLowerCase();

        BinarySearchTextFile search =
                new BinarySearchTextFile();

        String[] words =
                search.readWordsFromFile(filePath);

        if (words == null) {

            System.out.println("Error reading file.");
            return;
        }

        search.quickSort(
                words,
                0,
                words.length - 1
        );

        int index =
                search.binarySearch(
                        words,
                        targetWord
                );

        if (index != -1) {

            System.out.println(
                    "Word Found at Index: "
                            + index
            );
        }
        else {

            System.out.println(
                    "Word Not Found"
            );
        }

        sc.close();
    }
}