package ilezzov.bot.updates;

import ilezzov.bot.Main;
import ilezzov.bot.models.Messages;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class MessageEvent implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient = Main.telegramClient;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
                try {
                    telegramClient.execute(Messages.menu(message.getChatId()));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}
