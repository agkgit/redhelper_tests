public class Main
{
    public static void main(String[] args)
    {
        try
        {
            String botNick = "krupeninadmin";
            String botPassword = "qweasd";
            String botDomain = "xmpp.redhelper.ru";
            String botServer = "xmpp.redhelper.ru";
            int botPort = 5222;

            JabberBot bot = new JabberBot(botNick, botPassword, botDomain, botServer, botPort);
            Thread botThread = new Thread(bot);
            botThread.start();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}