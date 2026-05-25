import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearchTextFile {

    // Read words from file
    public String[] readWordsFromFile(
            String filePath) {

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(filePath)
                        )
        ) {

            StringBuilder sb =
                    new StringBuilder();

            String line;

            while (
                    (line = br.readLine())
                            != null
            ) {

                sb.append(
                        line.toLowerCase()
                                .replaceAll(
                                        "[^a-zA-Z ]",
                                        ""
                                )
                ).append(" ");
            }

            return sb.toString()
                    .split("\\s+");
        }

        catch (IOException e) {

            e.printStackTrace();

            return null;
        }
    }

    // Quick Sort
    public void quickSort(
            String[] arr,
            int low,
            int high) {

        if (low < high) {

            int pivot =
                    partition(
                            arr,
                            low,
                            high
                    );

            quickSort(
                    arr,
                    low,
                    pivot - 1
            );

            quickSort(
                    arr,
                    pivot + 1,
                    high
            );
        }
    }

    private int partition(
            String[] arr,
            int low,
            int high) {

        String pivot = arr[high];

        int i = low - 1;

        for (
                int j = low;
                j < high;
                j++
        ) {

            if (
                    arr[j]
                            .compareTo(pivot)
                            <= 0
            ) {

                i++;

                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Binary Search
    public int binarySearch(
            String[] words,
            String target) {

        int left = 0;
        int right =
                words.length - 1;

        while (left <= right) {

            int mid =
                    left +
                            (right - left)
                                    / 2;

            int cmp =
                    words[mid]
                            .compareTo(target);

            if (cmp == 0) {

                return mid;
            }

            else if (cmp < 0) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return -1;
    }
}