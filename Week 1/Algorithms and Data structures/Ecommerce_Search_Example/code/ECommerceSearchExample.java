package Ecommerce_Search_Example.code;

import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearchExample {

    // Linear Search
    public static Product linearSearch(
            Product[] products,
            int productId) {

        for (Product product : products) {

            if (product.productId == productId) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(
            Product[] products,
            int productId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == productId) {
                return products[mid];
            }

            else if (products[mid].productId < productId) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {

                new Product(
                        105,
                        "Laptop",
                        "Electronics"),

                new Product(
                        101,
                        "Mouse",
                        "Accessories"),

                new Product(
                        103,
                        "Keyboard",
                        "Accessories"),

                new Product(
                        104,
                        "Monitor",
                        "Electronics"),

                new Product(
                        102,
                        "Headphones",
                        "Audio")
        };

        System.out.println("Linear Search\n");

        Product result =
                linearSearch(products, 103);

        if (result != null) {

            System.out.println(result);
        }

        else {

            System.out.println(
                    "Product Not Found");
        }

        // Sort array for Binary Search
        Arrays.sort(
                products,
                Comparator.comparingInt(
                        p -> p.productId));

        System.out.println(
                "\nBinary Search\n");

        result =
                binarySearch(products, 103);

        if (result != null) {

            System.out.println(result);
        }

        else {

            System.out.println(
                    "Product Not Found");
        }
    }
}