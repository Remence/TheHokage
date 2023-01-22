package me.remence.thehokage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PomodoroCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("pomodoro start"))) return;

        Timer timer = new Timer();
        TimerTask studyTimerTask = new TimerTask() {
            int studyTime = 10; // 3000
            int breakTime = 10; // 600
            @Override
            public void run() {
                // Need to figure out how I'm going to divide the time up and format it.
                EmbedBuilder studyTimerEmbed = new EmbedBuilder();
                studyTimerEmbed.setColor(Color.red);
                studyTimerEmbed.setTitle("**STUDY TIMER**");
                studyTimerEmbed.setDescription("There are 50 minutes remaining in your session.");
                studyTimerEmbed.setFooter("You will be notified when the session ends.");
                event.getChannel().asTextChannel().sendMessage(event.getUser().getAsMention()).queue();
                event.replyEmbeds(studyTimerEmbed.build()).queue();

                if (studyTime >= 0) {
                    studyTime--;
                }
                    EmbedBuilder breakTimerEmbed = new EmbedBuilder();
                    breakTimerEmbed.setColor(Color.red);
                    breakTimerEmbed.setTitle("**BREAK TIMER**");
                    breakTimerEmbed.setDescription("There are 10 minutes remaining in your session.");
                    breakTimerEmbed.setFooter("You will be notified when the session ends.");
                    event.getChannel().asTextChannel().sendMessage(event.getUser().getAsMention()).queue();
                    event.replyEmbeds(breakTimerEmbed.build()).queue();
                    studyTime = 3000;

                    if (breakTime >= 0) {
                        breakTime--;
                    }
                    run();
                }
            };
        studyTimerTask.run();
    }
}
