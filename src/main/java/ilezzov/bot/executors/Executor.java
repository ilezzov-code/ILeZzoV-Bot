package ilezzov.bot.executors;

import ilezzov.bot.database.DatabaseMethods;
import ilezzov.bot.models.Messages;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Executor {
    public static void startExecuteMessage(Update update) {
        Long userId = update.getMessage().getChatId();
        String[] args = update.getMessage().getText().split(" ");

        if (args[0].equalsIgnoreCase("/start")) {
            if (args.length > 1) {
                switch (args[1]) {
                    case "freeAvatar" -> {}
                        //TODO: freeAvataLogic
                    default -> {
                        Messages.deleteMessage(userId, DatabaseMethods.getMessageId(userId));
                        Integer messageId = Messages.menu(userId);
                        DatabaseMethods.updateMessageId(userId, messageId);

                        return;
                    }
                }
            }
        }

        Messages.deleteMessage(userId, DatabaseMethods.getMessageId(userId));
        Integer messageId = Messages.menu(userId);
        DatabaseMethods.updateMessageId(userId, messageId);
    }

    public static void startExecuteKeyboard(Update update) {
        Long userId = update.getCallbackQuery().getFrom().getId();;
        String data = update.getCallbackQuery().getData();

        switch (data){
            case "user|channels" -> {
                Messages.channelsList(userId, update);
                DatabaseMethods.updateFlag(userId, "channelList");
            }
            case "user|clubBs" -> {
                Messages.clubBs(userId, update);
                DatabaseMethods.updateFlag(userId, "clubBs");
            }
            case "user|contact" -> {
                Messages.contact(userId, update);
                DatabaseMethods.updateFlag(userId, "contact");
            }
            case "user|mailing" -> {
                Messages.mailing(userId, update, DatabaseMethods.getMailingStatus(userId));
                DatabaseMethods.updateFlag(userId, "mailing");
            }
        }
    }

    public static void channelsListExecuteKeyboard(Update update) {
        Long userId = update.getCallbackQuery().getFrom().getId();;
        String data = update.getCallbackQuery().getData();

        switch (data) {
            case "user|backToMenu" -> {
                Messages.backToMenu(userId, update);
                DatabaseMethods.updateFlag(userId, "start");
            }
        }
    }

    public static void clubBsExecuteKeyboard(Update update) {
        Long userId = update.getCallbackQuery().getFrom().getId();;
        String data = update.getCallbackQuery().getData();

        switch (data) {
            case "user|backToMenu" -> {
                Messages.backToMenu(userId, update);
                DatabaseMethods.updateFlag(userId, "start");
            }
        }
    }

    public static void contactExecuteKeyboard(Update update) {
        Long userId = update.getCallbackQuery().getFrom().getId();;
        String data = update.getCallbackQuery().getData();

        switch (data) {
            case "user|backToMenu" -> {
                Messages.backToMenu(userId, update);
                DatabaseMethods.updateFlag(userId, "start");
            }
        }
    }

    public static void mailingExecuteKeyboard(Update update) {
        Long userId = update.getCallbackQuery().getFrom().getId();;
        String data = update.getCallbackQuery().getData();

        switch (data) {
            case "user|backToMenu" -> {
                Messages.backToMenu(userId, update);
                DatabaseMethods.updateFlag(userId, "start");
            }
            case "user|mailingDisable" -> {
                DatabaseMethods.disableMailing(userId);
                Messages.mailingRefresh(userId, update, DatabaseMethods.getMailingStatus(userId));
            }
            case "user|mailingEnable" -> {
                DatabaseMethods.enableMailing(userId);
                Messages.mailingRefresh(userId, update, DatabaseMethods.getMailingStatus(userId));
            }
        }
    }
}
