package ilezzov.bot.executors;

import ilezzov.bot.models.Messages;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class Executor {
    public static void startExecuteMessage(Update update) {
        Message message = update.getMessage();
        Long userId = message.getChatId();

        Messages.menu(userId);
    }

    public static void startExecuteKeyboard(Update update) {

    }

}
