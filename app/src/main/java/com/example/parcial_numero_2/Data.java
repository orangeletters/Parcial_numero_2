package com.example.parcial_numero_2;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Watch> watches = new ArrayList<>();
    public static List<Watch> cart = new ArrayList<>();

    static {
        watches.add(new Watch("1","Rolex Submariner",8999.99, R.drawable.imagen1));
        watches.add(new Watch("2","Omega Speedmaster",5999.99, R.drawable.imagen1));

    }

    public static void addToCart(Watch w) {
        cart.add(w);
    }

    public static void removeFromCart(Watch w) {
        cart.remove(w);
    }
}
