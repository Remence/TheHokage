package me.remence.thehokage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class TruthDareCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("truthordare"))) return;

        EmbedBuilder todEmbed = new EmbedBuilder();
        todEmbed.setTitle("**TRUTH OR DARE**");
    }
}
