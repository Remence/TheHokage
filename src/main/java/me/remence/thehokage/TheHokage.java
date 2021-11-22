package me.remence.thehokage;

import me.remence.thehokage.commands.Ping;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class TheHokage {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(Constants.token);

        builder.setActivity(Activity.playing("Rust"));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);

        builder.addEventListeners(new Listener());

        builder.build();
    }
}
