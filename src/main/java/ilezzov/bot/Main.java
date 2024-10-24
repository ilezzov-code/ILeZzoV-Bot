package ilezzov.bot;

import ilezzov.bot.database.Connector;
import ilezzov.bot.database.Tables;
import ilezzov.bot.preference.BotInfo;
import ilezzov.bot.preference.Database;
import ilezzov.bot.updates.StartEvent;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.sql.Connection;

public class Main {
    public final static TelegramClient telegramClient = new OkHttpTelegramClient(BotInfo.botToken);
    public final static Connection connection = new Connector(Database.host, Database.user, Database.database, Database.password).getConnection();

    public static void main(String[] args) {
        Tables.checkTables();
        try {
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(BotInfo.botToken, new StartEvent());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
