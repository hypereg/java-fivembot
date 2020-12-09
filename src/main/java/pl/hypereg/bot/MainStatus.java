package pl.hypereg.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.json.JSONException;
import pl.hypereg.bot.system.Settings;
import pl.hypereg.bot.system.SettingsManager;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainStatus {
    private static Settings settings = SettingsManager.getInstance().getSettings();

    public static void main(String[] args) throws JSONException, LoginException {
        JDA jda = JDABuilder.createDefault(settings.getBotToken()).addEventListeners(new AuthorBot()).build();
        System.out.println("Bot wykonany przez hypereg jeśli chcesz więcej opcji pisz pw hypereg#0001");
        new Timer().schedule(new TimerTask(){
            public void run(){
                try {
                    String a = jsonGetRequest(settings.getServerAdress());
                    String[] rep = a.split("}");
                    int c = rep.length;
                    c--;
                    String s = Integer.toString(c);
                    System.out.println(s);
                    jda.getPresence().setActivity(Activity.playing(s + settings.getServerDescription()));
                } catch (Exception e){
                    jda.getPresence().setActivity(Activity.playing(settings.getServerOffline()));
                }
            }},0,settings.getRefreshTime());
    }
    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }


    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
