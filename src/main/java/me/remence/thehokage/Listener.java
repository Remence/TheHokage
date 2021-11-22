package me.remence.thehokage;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {

    public final Manager manager = new Manager();

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(Constants.prefix + "shutdown")
                && event.getAuthor().getIdLong() == Constants.ownerID) {

            event.getChannel().sendMessage("Access granted - Shutting down.").complete();
            event.getJDA().shutdown();
            System.exit(0);
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase(Constants.prefix + "shutdown")
                && !(event.getAuthor().getIdLong() == Constants.ownerID)) {
            event.getChannel().sendMessage("Access denied.").queue();
        }
        manager.run(event);
    }
}
