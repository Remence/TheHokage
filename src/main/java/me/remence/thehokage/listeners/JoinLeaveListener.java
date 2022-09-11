package me.remence.thehokage.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class JoinLeaveListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        EmbedBuilder join = new EmbedBuilder();

        join.setColor(Color.GREEN);
        join.setTitle("SERVER EVENT");
        join.setDescription(event.getMember().getAsMention() + " has entered Konoha!");
        event.getGuild().getDefaultChannel().sendMessageEmbeds(join.build()).queue();
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        EmbedBuilder leave = new EmbedBuilder();

        leave.setColor(Color.RED);
        leave.setTitle("SERVER EVENT");
        leave.setDescription(event.getMember() + " has left Konoha!");
        event.getGuild().getDefaultChannel().sendMessageEmbeds(leave.build()).queue();
    }
}
