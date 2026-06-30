package Library_Management_System.code;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    // Linear Search
    public static void linearSearch(
            Book[] books,
            String title) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(title)) {

                System.out.println(book);
                return;
            }
        }

        System.out.println(
                "Book Not Found");
    }

    // Binary Search
    public static void binarySearch(
            Book[] books,
            String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare =
                    books[mid].title.compareToIgnoreCase(title);

            if (compare == 0) {

                System.out.println(
                        books[mid]);

                return;
            }

            else if (compare < 0) {

                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }

        System.out.println(
                "Book Not Found");
    }

    public static void main(
            String[] args) {

        Book[] books = {

                new Book(
                        101,
                        "Java Programming",
                        "James Gosling"),

                new Book(
                        102,
                        "Data Structures",
                        "Mark Allen"),

                new Book(
                        103,
                        "Operating Systems",
                        "Abraham Silberschatz"),

                new Book(
                        104,
                        "Computer Networks",
                        "Andrew Tanenbaum"),

                new Book(
                        105,
                        "Database Systems",
                        "Raghu Ramakrishnan")
        };

        System.out.println(
                "Linear Search\n");

        linearSearch(
                books,
                "Operating Systems");

        Arrays.sort(
                books,
                Comparator.comparing(
                        book -> book.title));

        System.out.println(
                "\nBinary Search\n");

        binarySearch(
                books,
                "Operating Systems");
    }
}