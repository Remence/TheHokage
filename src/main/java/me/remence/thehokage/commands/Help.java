package me.remence.thehokage.commands;

import me.remence.thehokage.Command;
import me.remence.thehokage.Constants;
import me.remence.thehokage.Manager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Help implements Command {
    public final Manager manager;

    public Help(Manager m) {
        this.manager = m;
    }

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if (args.isEmpty()) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("List of Commands:");
            StringBuilder desc = embed.getDescriptionBuilder();
            manager.getCommands().forEach(command -> {
                desc.append("`").append(command.getCommand()).append("`\n");
            });
            event.getChannel().sendMessage(embed.build()).queue();
            return;
        }
        Command command = manager.getCommand(String.join("", args));
        if (command == null) {
            event.getChannel().sendMessage("The command `" + String.join("", args) + "` does not exist.\n" +
                    "Use `" + Constants.prefix + command.getCommand() + "` for a list of all the commands.").queue();
            return;
        }
        event.getChannel().sendMessage("Command help for `" + command.getCommand() + "`\n" +
                command.getHelp()).queue();
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Returns a list of commands\n" +
                "Usage: " + Constants.prefix + getCommand() +  " <command>";
    }
}
