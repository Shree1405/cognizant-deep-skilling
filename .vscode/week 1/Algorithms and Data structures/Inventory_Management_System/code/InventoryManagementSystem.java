package Inventory_Management_System.code;

public class InventoryManagementSystem {

    public static void main(String[] args) {

        Inventory inventory =
                new Inventory();

        inventory.addProduct(
                new Product(
                        101,
                        "Laptop",
                        20,
                        65000));

        inventory.addProduct(
                new Product(
                        102,
                        "Mouse",
                        50,
                        700));

        inventory.addProduct(
                new Product(
                        103,
                        "Keyboard",
                        30,
                        1500));

        System.out.println();

        inventory.displayInventory();

        System.out.println();

        inventory.updateProduct(
                101,
                25,
                62000);

        System.out.println();

        inventory.searchProduct(
                101);

        System.out.println();

        inventory.deleteProduct(
                102);

        System.out.println();

        inventory.displayInventory();
    }
}