package ilezzov.bot.updates;

import ilezzov.bot.database.DatabaseMethods;
import ilezzov.bot.executors.Executor;
import ilezzov.bot.models.Messages;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;


public class StartEvent implements LongPollingSingleThreadUpdateConsumer {

    @Override
    public void consume(Update update) {
        Message message = update.getMessage();
        Long userId = getUserId(update);

        if(!DatabaseMethods.checkUser(userId)) {
            DatabaseMethods.newUser(userId, Messages.getActivation(update));
            Messages.newUser(userId, Messages.getActivation(update));
        }

        String flag = DatabaseMethods.getFlag(userId);

        if (update.hasMessage() && message.hasText()) {
            switch (flag) {
                case "start": Executor.startExecuteMessage(update);
            }
        }

        if (update.hasCallbackQuery()) {
            switch (flag) {
                case "start": Executor.startExecuteKeyboard(update);
                case "channelList": Executor.channelsListExecuteKeyboard(update);
                case "clubBs": Executor.clubBsExecuteKeyboard(update);
                case "contact": Executor.contactExecuteKeyboard(update);
                case "mailing": Executor.mailingExecuteKeyboard(update);
            }
        }
    }
    public Long getUserId(Update update) {
        if (update.hasMessage())
            return update.getMessage().getChatId();
        return update.getCallbackQuery().getFrom().getId();
    }
}
