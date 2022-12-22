package me.remence.thehokage.utils;

import java.util.Random;

public class Truths {
    public String[] truths = {"",
    ""};

    public String generateTruth() {
        Random rand = new Random();
        String randomTruth = truths[rand.nextInt(truths.length)];
        return randomTruth;
    }
}
