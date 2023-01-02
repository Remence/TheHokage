package me.remence.thehokage;

import me.remence.thehokage.commands.*;
import me.remence.thehokage.listeners.JoinLeaveListener;
import me.remence.thehokage.utils.Constants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import javax.swing.text.html.Option;

public class TheHokage extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(Constants.TOKEN)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new AboutMeCommand()) // []?
                .addEventListeners(new JoinLeaveListener())
                .addEventListeners(new SayCommand())
                .addEventListeners(new PollCommand())
                .addEventListeners(new TruthDareCommand())
                .addEventListeners(new StudyCommand())
                .setActivity(Activity.watching("Naruto"))
                .setStatus(OnlineStatus.ONLINE)
                .build().awaitReady();

        Guild guild = jda.getGuildById("759195383242424340");

        if (guild != null) {
            guild.updateCommands().addCommands(
                    Commands.slash("aboutme", "Learn about your account."),
                    Commands.slash("say", "Say something as the hokage.")
                            .addOption(OptionType.STRING, "message", "What would you like to say?", true),
                    Commands.slash("poll", "Send a poll for everyone to vote on!")
                            .addOption(OptionType.STRING, "title", "Title the poll.", true)
                            .addOption(OptionType.STRING, "description", "Describe what the poll is about.", true)
                            .addOption(OptionType.CHANNEL, "channel", "Channel to send this poll to.", true)
                            .addOption(OptionType.BOOLEAN, "pingeveryone", "@everyone with your poll?", true)
                            .addOption(OptionType.STRING, "opt-1", "Option for the poll.", true)
                            .addOption(OptionType.STRING, "opt-2", "Option for the poll.", true)
                            .addOption(OptionType.STRING, "opt-3", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-4", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-5", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-6", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-7", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-8", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-9", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-10", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-11", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-12", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-13", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-14", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-15", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-16", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-17", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-18", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-19", "Option for the poll.", false)
                            .addOption(OptionType.STRING, "opt-20", "Option for the poll.", false),
                    Commands.slash("truthordare", "What will you choose?"),
                    Commands.slash("sendstudyreaction", "Only meant to be sent once."),
                    Commands.slash("studywithme", "Used when Remence starts a session.")
            ).queue();
        }
    }

}

// Action? Queue it.
