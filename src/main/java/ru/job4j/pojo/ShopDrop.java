package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = 0; i < products.length - 1; i++) {
            if (i >= index) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        if (index == products.length - 1){
                products[products.length - 1] = null;
        }
        return products;
    }
}
