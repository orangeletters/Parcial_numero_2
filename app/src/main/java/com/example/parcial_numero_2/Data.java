package com.example.parcial_numero_2;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Watch> watches = new ArrayList<>();
    public static List<Watch> cart = new ArrayList<>();

    static {
        watches.add(new Watch("1","Rolex Submariner",70000, R.drawable.imagen1));
        watches.add(new Watch("2","Omega Speedmaster",5999.99, R.drawable.imagen1));
        watches.add(new Watch("4","Garmin Venu 3S",8000.99, R.drawable.gamien1));
        watches.add(new Watch("5","Garmin Forerunner®",9500.00, R.drawable.gamier2));
        watches.add(new Watch("6","RELOJ BAIGNOIRE",45000.00, R.drawable.cartier1));
        watches.add(new Watch("7","RELOJ SANTOS DE CARTIER",10000, R.drawable.cartier2));
        watches.add(new Watch("8","Casio Edifice EFV-550D-1AV",60000, R.drawable.casio1));
        watches.add(new Watch("9","Casio Pro Trek PRG-270-1",5000.99, R.drawable.casio2));
        // añade más si quieres
    }

    public static void addToCart(Watch w) {
        cart.add(w);
    }

    public static void removeFromCart(Watch w) {
        cart.remove(w);
    }
}
