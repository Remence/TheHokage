package me.remence.thehokage.utils;

import java.util.Random;

public class Truths {
    public String[] truths = {"What is the worst thing you've done?",
    "What's your biggest fear?"};

    public String generateTruth() {
        Random rand = new Random();
        String randomTruth = truths[rand.nextInt(truths.length)];
        return randomTruth;
    }
}
