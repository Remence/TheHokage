package me.remence.thehokage.commands;

import me.remence.thehokage.Command;
import me.remence.thehokage.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Ping implements Command {

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue(msg -> {
            msg.editMessage(event.getJDA().getGatewayPing() + "ms").queue();
        });
    }

    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getHelp() {
        return "Returns the gateway ping of the hokage.\n" +
                "Usage: " + Constants.prefix + getCommand() + "";
    }
}
