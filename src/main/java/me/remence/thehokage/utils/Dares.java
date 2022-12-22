package me.remence.thehokage.utils;

import java.util.Random;

public class Dares {
    public String[] dares = {"Attempt a flip.",
    "Kiss the closest object to your left.",
    "Yell as loud as you can for 5 seconds.",
    "Send the latest photo/video on your camera roll."};

    public String generateDare() {
        Random rand = new Random();
        String randomDare = dares[rand.nextInt(dares.length)];
        return randomDare;
    }
}
