package me.remence.thehokage.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EatMiloCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("eatmilo")) return;

        event.reply("Milo has been eaten by: " + event.getMember().getAsMention()).setEphemeral(false).queue();
    }

}
