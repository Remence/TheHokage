package me.remence.thehokage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class PollCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("poll"))) return;

        EmbedBuilder pollEmbed = new EmbedBuilder();
        String[] emoji = {"\uD83C\uDDE6",
                "\uD83C\uDDE7",
                "\uD83C\uDDE8",
                "\uD83C\uDDE9",
                "\uD83C\uDDEA",
                "\uD83C\uDDEB",
                "\uD83C\uDDEC",
                "\uD83C\uDDED",
                "\uD83C\uDDEE",
                "\uD83C\uDDEF",
                "\uD83C\uDDF0",
                "\uD83C\uDDF1",
                "\uD83C\uDDF2",
                "\uD83C\uDDF3",
                "\uD83C\uDDF4",
                "\uD83C\uDDF5",
                "\uD83C\uDDF6",
                "\uD83C\uDDF7",
                "\uD83C\uDDF8",
                "\uD83C\uDDF9"
        };

        OptionMapping titleOption = event.getOption("title");
        OptionMapping descriptionOption = event.getOption("description");
        OptionMapping channelOption = event.getOption("channel");
        OptionMapping pingEveryoneOption = event.getOption("pingeveryone");

        OptionMapping[] reasonList = {event.getOption("opt-1"),
                event.getOption("opt-2"),
                event.getOption("opt-3"),
                event.getOption("opt-4"),
                event.getOption("opt-5"),
                event.getOption("opt-6"),
                event.getOption("opt-7"),
                event.getOption("opt-8"),
                event.getOption("opt-9"),
                event.getOption("opt-10"),
                event.getOption("opt-11"),
                event.getOption("opt-12"),
                event.getOption("opt-13"),
                event.getOption("opt-14"),
                event.getOption("opt-15"),
                event.getOption("opt-16"),
                event.getOption("opt-17"),
                event.getOption("opt-18"),
                event.getOption("opt-19"),
                event.getOption("opt-20")
        };

        List<String> options = event.getOptions().stream()
                .filter(opt -> opt.getName().startsWith("opt-"))
                .map(OptionMapping::getAsString)
                .collect(Collectors.toList());

        pollEmbed.setColor(Color.RED);
        pollEmbed.setTitle("**POLL - " + titleOption.getAsString() + "**");
        pollEmbed.setDescription(descriptionOption.getAsString() + " \n");
        pollEmbed.setFooter("Please react to the letter corresponding to your vote.\nPoll sent by: " + event.getUser().getName());

        for (int i = 0; i < options.size(); i++) {
            pollEmbed.appendDescription(emoji[i] + " -> " + reasonList[i].getAsString() + "\n");
        }

        if (pingEveryoneOption.getAsBoolean()) {
            channelOption.getAsTextChannel().sendMessage("@everyone").queue();
        }

        channelOption.getAsTextChannel().sendMessageEmbeds(pollEmbed.build()).queue(reactPoll -> {
            for (int j = 0; j < options.size(); j++) {
                reactPoll.addReaction(Emoji.fromFormatted(emoji[j])).queue();
            }
        });

        event.reply("Your poll was sent sudccessfully!").setEphemeral(true).queue();
    }
}
