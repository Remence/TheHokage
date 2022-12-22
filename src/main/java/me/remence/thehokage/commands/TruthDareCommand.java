package me.remence.thehokage.commands;

import me.remence.thehokage.utils.Dares;
import me.remence.thehokage.utils.Truths;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class TruthDareCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("truthordare"))) return;

        EmbedBuilder todEmbed = new EmbedBuilder();
        todEmbed.setTitle("**TRUTH OR DARE**");
        todEmbed.setDescription("Choose wisely...");
        todEmbed.setColor(Color.RED);

        event.replyEmbeds(todEmbed.build())
                .addActionRow(
                        Button.success("truth-option", "Truth"),
                        Button.danger("dare-option", "Dare"),
                        Button.secondary("random-option", "Random")
                ).queue();
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("truth-option")) {
            EmbedBuilder truthEmbed = new EmbedBuilder();
            Truths randomTruth = new Truths();

            truthEmbed.setTitle("Placeholder truth title");
            truthEmbed.setColor(Color.green);
            truthEmbed.setDescription(randomTruth.generateTruth());

            event.replyEmbeds(truthEmbed.build()).queue();
        } else if (event.getButton().getId().equals("dare-option")) {
            EmbedBuilder dareEmbed = new EmbedBuilder();
            Dares randomDare = new Dares();

            dareEmbed.setTitle("dare title");
            dareEmbed.setColor(Color.red);
            dareEmbed.setDescription(randomDare.generateDare());

            event.replyEmbeds(dareEmbed.build()).queue();
        } else if (event.getButton().getId().equals("random-option")) {
            // Random button logic.
        }
    }


}
