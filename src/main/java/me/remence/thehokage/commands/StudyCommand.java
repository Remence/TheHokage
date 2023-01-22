package me.remence.thehokage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class StudyCommand extends ListenerAdapter {

    // Initial toggle role command.
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("sendstudyreaction")) {
            EmbedBuilder studyEmbed = new EmbedBuilder();
            studyEmbed.setTitle("**STUDY WITH REMENCE**");
            studyEmbed.setDescription("Feeling unmotivated to study? Click the button below to get pinged " +
                    "whenever Remence begins his study sessions.\n\n **NOTE:** Remence follows the 60/10 " +
                    "pomodoro technique for studying. You don't have to follow the same method, but it's recommended.\n");
            studyEmbed.setColor(Color.red);

            event.replyEmbeds(studyEmbed.build())
                    .addActionRow(
                            Button.primary("opt", "Toggle")
                    ).queue();
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("opt")) {
            Member member = event.getMember();
            Role studyRole = event.getGuild().getRoleById(942580523648290847L);

            // Check to see whether the user has the study role.
            if (!(member.getRoles().contains(studyRole))) {
                event.getGuild().addRoleToMember(member, studyRole).queue();
                event.reply("You opted in.").setEphemeral(true).queue();
            } else if (member.getRoles().contains(studyRole)) {
                event.getGuild().removeRoleFromMember(member, studyRole).queue();
                event.reply("You opted out.").setEphemeral(true).queue();
            }
        }
    }
}
