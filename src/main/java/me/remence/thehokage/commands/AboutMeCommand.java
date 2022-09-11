package me.remence.thehokage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class AboutMeCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("aboutme"))) return;

        EmbedBuilder aboutmeEmbed = new EmbedBuilder();

        aboutmeEmbed.setColor(Color.red);
        aboutmeEmbed.setTitle("**ABOUT ME - " + event.getMember().getNickname() + "**");

        event.replyEmbeds(aboutmeEmbed.build()).queue();
    }
}
