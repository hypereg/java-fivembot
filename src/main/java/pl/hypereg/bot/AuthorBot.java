package pl.hypereg.bot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AuthorBot extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!botauthor"))
        {
            long time = System.currentTimeMillis();
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Autorem bota jest <@376781097998221324>").queue(response /* => Message */ -> {
                response.editMessageFormat("Autorem bota jest <@376781097998221324>!", System.currentTimeMillis() - time).queue();
            });
        }
    }

}
