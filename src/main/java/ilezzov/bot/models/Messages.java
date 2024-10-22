package ilezzov.bot.models;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public class Messages {
    public static SendPhoto menu(Long chatId) {
        return SendPhoto.builder()
                .chatId(chatId)
                .replyMarkup(Keyboards.menu())
                .caption("*Привет 👋* Это бот для управления каналами [ILeZzoV'a](https://t.me/ilezovofficial)\n\n🦄 Используйте кнопки для взаимодействия с ботом")
                .photo(new InputFile("https://github.com/ilezzov-code/ILeZzoV-Bot/blob/main/img/hello.png"))
                .parseMode("MarkdownV2")
                .build();
    }
}
