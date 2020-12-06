package pl.hypereg.bot.system;

public class Settings {
    private String ownerId;
    private String botToken;
    private String prefix;
    private String serverAdress;
    private String serverDescription;
    private int refreshTime;

    public String getOwnerId(){
        return ownerId;
    }

    public void setOwnerId(String ownerId){
        this.ownerId = ownerId;
    }

    public String getBotToken(){
        return botToken;
    }

    public void setBotToken(String botToken){
        this.botToken = botToken;
    }

    public String getPrefix(){
        return this.prefix;
    }

    public String getServerAdress(){
        return this.serverAdress;
    }

    public void setServerAdress(String serverAdress){
        this.serverAdress = serverAdress;
    }

    public String getServerDescription(){
        return this.serverDescription;
    }

    public void setServerDescription(String serverDescription){
        this.serverDescription = serverDescription;
    }

    public int getRefreshTime(){
        return this.refreshTime;
    }

    public void setRefreshTime(int refreshTime){
        this.refreshTime = refreshTime;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }



}
