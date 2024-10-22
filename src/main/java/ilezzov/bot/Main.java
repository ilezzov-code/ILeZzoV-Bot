package ilezzov.bot;

import ilezzov.bot.preference.BotInfo;
import ilezzov.bot.updates.MessageEvent;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class Main {
    public static TelegramClient telegramClient = new OkHttpTelegramClient(BotInfo.botToken);
    public static void main(String[] args) {
        try {
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(BotInfo.botToken, new MessageEvent());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
