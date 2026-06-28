package Inventory_Management_System.code;

import java.util.HashMap;

public class Inventory {

    HashMap<Integer, Product> products =
            new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        products.put(product.productId, product);

        System.out.println(
                "Product Added Successfully");
    }

    // Update Product
    public void updateProduct(
            int productId,
            int quantity,
            double price) {

        if (products.containsKey(productId)) {

            Product product =
                    products.get(productId);

            product.quantity = quantity;
            product.price = price;

            System.out.println(
                    "Product Updated Successfully");
        }

        else {

            System.out.println(
                    "Product Not Found");
        }
    }

    // Delete Product
    public void deleteProduct(
            int productId) {

        if (products.remove(productId) != null) {

            System.out.println(
                    "Product Deleted Successfully");
        }

        else {

            System.out.println(
                    "Product Not Found");
        }
    }

    // Search Product
    public void searchProduct(
            int productId) {

        Product product =
                products.get(productId);

        if (product != null) {

            System.out.println(product);
        }

        else {

            System.out.println(
                    "Product Not Found");
        }
    }

    // Display Inventory
    public void displayInventory() {

        for (Product product :
                products.values()) {

            System.out.println(product);

            System.out.println(
                    "---------------------");
        }
    }
}
