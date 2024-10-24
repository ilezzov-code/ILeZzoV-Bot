package ilezzov.bot.models;

import ilezzov.bot.Main;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class Messages {
    private static final TelegramClient telegramClient = Main.telegramClient;

    public static Integer menu(Long chatId) {
        try {
            Message message = telegramClient.execute(SendPhoto.builder()
                    .chatId(chatId)
                    .replyMarkup(Keyboards.menu())
                    .caption("*Привет 👋* Это бот для управления каналами экосистемы [ILeZzoV'a](https://t.me/ilezzov)\n\n🦄 Используйте кнопки для взаимодействия с ботом")
                    .photo(new InputFile("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/hello.png"))
                    .parseMode("MarkdownV2")
                    .build());
            return message.getMessageId();
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newUser(Long chatId, String[] activation) {
        try {
            telegramClient.execute(SendMessage.builder()
                    .chatId(chatId)
                    .text(STR."""
\uD83D\uDC7E → Новый пользователь бота:\s

>Айди: \{chatId}
>Тип активации: \{activation[0]}
""")
                    .parseMode("MarkdownV2")
                    .replyMarkup(Keyboards.newUser())
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void channelsList(Long userId, Update update) {
        try {
            telegramClient.execute(EditMessageMedia.builder()
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .chatId(userId)
                    .replyMarkup(Keyboards.backToMenu())
                    .media(InputMediaPhoto.builder()
                            .caption("""
📃 Список всех Telegram\\-каналов нашей [*экосистемы*](https://t.me/ilezzov):

• [*Brawl News*](https://t.me/newsbs_stars) — новости по игре Brawl Stars
• [*ILeZzoV AvaTars*](https://t.me/ilezzov_avatars) — дизайн персональных аватаров
• [*ILeZzoV*](https://t.me/ilezzov) — канал директора экосистемы

Купить рекламу — @ilezovofficial
""")
                            .parseMode("MarkdownV2")
                            .media("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/channels.png")
                            .build()
                    )
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void backToMenu(Long userId, Update update) {
        try {
            telegramClient.execute(EditMessageMedia.builder()
                    .chatId(userId)
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(Keyboards.menu())
                    .media(InputMediaPhoto.builder()
                            .caption("*Привет 👋* Это бот для управления каналами экосистемы [ILeZzoV'a](https://t.me/ilezzov)\n\n🦄 Используйте кнопки для взаимодействия с ботом")
                            .media("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/hello.png")
                            .parseMode("MarkdownV2")
                            .build())
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clubBs(Long userId, Update update) {
        try {
            telegramClient.execute(EditMessageMedia.builder()
                    .chatId(userId)
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(Keyboards.clubBs())
                    .media(InputMediaPhoto.builder()
                            .caption("🦄 У нас есть наш собственный клуб в BrawlStars\\! \n\nВступить в него можно по кнопке ниже или по [*клику*](https://link.brawlstars.com/invite/band/ru?tag=2YGLGQGUL&token=49bkmhmw)")
                            .media("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/club.png")
                            .parseMode("MarkdownV2")
                            .build())
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void contact(Long userId, Update update) {
        try {
            telegramClient.execute(EditMessageMedia.builder()
                    .chatId(userId)
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(Keyboards.contact())
                    .media(InputMediaPhoto.builder()
                            .caption("👔 У вас возник вопрос или хотите обсудить сотрудничество? \n\n— Напишите нам\\! [*клик*](https://t.me/ilezovofficial)")
                            .media("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/contact.png")
                            .parseMode("MarkdownV2")
                            .build())
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mailing(Long userId, Update update, Integer isEnable) {
        try {
            telegramClient.execute(EditMessageMedia.builder()
                    .chatId(userId)
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(Keyboards.mailingSetting(isEnable))
                    .media(InputMediaPhoto.builder()
                            .caption("⚙️ Управление рассылкой \n\nВключите, если хотите получать уведомления о новых конкурсах и раздачах\nОтключите, и мы вас не потревожим 😊")
                            .media("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/contact.png")
                            .parseMode("MarkdownV2")
                            .build())
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mailingRefresh(Long userId, Update update, Integer isEnable) {
        try {
            telegramClient.execute(EditMessageReplyMarkup.builder()
                    .chatId(userId)
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .replyMarkup(Keyboards.mailingSetting(isEnable))
                    .build());
            telegramClient.execute(AnswerCallbackQuery.builder()
                    .callbackQueryId(update.getCallbackQuery().getId())
                    .text("⚙️ Настройка сохранена")
                    .build()
            );
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getActivation(Update update) {
        if (update.hasMessage()) {
            String message = update.getMessage().getText();
            String[] arguments = message.split(" ");
            if (arguments[0].equalsIgnoreCase("/start"))
                return new String[]{"Start", arguments[1]};

            return new String[]{"Message", message};
        }

        return new String[]{"Keyboard", update.getCallbackQuery().getData()};
    }

    public static void deleteMessage(Long userId, Integer messageId) {
        if (messageId < 1) return;

        try {
            telegramClient.execute(DeleteMessage.builder()
                    .chatId(userId)
                    .messageId(messageId)
                    .build());
        } catch (TelegramApiException e){
            throw new RuntimeException(e);
        }
    }

}
