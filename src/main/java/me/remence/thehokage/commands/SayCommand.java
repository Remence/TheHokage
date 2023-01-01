package me.remence.thehokage.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class SayCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("say"))) return;

        OptionMapping messageOption = event.getOption("message");

        String userMessage = messageOption.getAsString();
        TextChannel textChannel = event.getTextChannel();

        textChannel.sendMessage(userMessage).queue();

        event.reply("Your message was sent successfully!").setEphemeral(true).queue();
    }
}
