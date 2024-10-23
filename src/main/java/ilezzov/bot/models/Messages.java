package ilezzov.bot.models;

import ilezzov.bot.Main;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class Messages {
    private static final TelegramClient telegramClient = Main.telegramClient;

    public static void menu(Long chatId) {
        try {
            telegramClient.execute(SendPhoto.builder()
                    .chatId(chatId)
                    .replyMarkup(Keyboards.menu())
                    .caption("*Привет 👋* Это бот для управления каналами экосистемы [ILeZzoV'a](https://t.me/ilezzov)\n\n🦄 Используйте кнопки для взаимодействия с ботомЦ")
                    .photo(new InputFile("https://raw.githubusercontent.com/ilezzov-code/ILeZzoV-Bot/refs/heads/main/img/hello.png"))
                    .parseMode("MarkdownV2")
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newUser(Long chatId, String activation) {
        try {
            telegramClient.execute(SendMessage.builder()
                    .chatId(chatId)
                    .text(STR."""
\uD83D\uDC7E → Новый пользователь бота:\s

>Айди: \{chatId}
>Активировал по: \{activation}
""")
                    .parseMode("MarkdownV2")
                    .replyMarkup(Keyboards.newUser())
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getActivation(Update update) {
        if (update.hasMessage()) {
            return STR."*Message* \{update.getMessage().getText()}";
        }
        return STR."*Keyboard* \{update.getCallbackQuery().getData()}";
    }
}
