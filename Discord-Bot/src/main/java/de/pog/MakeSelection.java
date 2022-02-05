package de.pog;

import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class MakeSelection extends ListenerAdapter {

    public void onSelectionMenu(SelectionMenuEvent event) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        OffsetDateTime date = event.getGuild().getTimeCreated();
        String formatted = df.format(date);

        if (event.getComponent().getId().equals("infos")) {

            for (int i = 0; i < event.getValues().size(); i++) {

                switch (event.getValues().get(i)) {

                    case "owner":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Der aktuelle Owner ist: **" + event.getGuild().getOwner().getUser().getName() + "**").queue();
                        });
                        break;

                    case "member":
                        event.getUser().openPrivateChannel().queue(privateChannel -> {
                            privateChannel.sendMessage("Der Server hat akutell **" + event.getGuild().getMemberCount() + "** Member").queue();
                        });
                        break;

                    case "date":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Der Server wurde am **" + formatted + "** erstellt").queue();
                        });
                        break;

                    case "booster":
                        event.getUser().openPrivateChannel().queue( privateChannel -> {
                            privateChannel.sendMessage("Der Ser hat aktuell **" + event.getGuild().getBoostCount() + "** Booster").queue();
                        });
                        break;

                    default:
                        break;
                }

            }

            event.reply("Dir wurden alle Infos Privat geschickt").setEphemeral(true).queue();

        }

    }

}
