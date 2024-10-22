package ilezzov.bot.models;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

public class Keyboards {
    public static InlineKeyboardMarkup menu() {
        InlineKeyboardButton[] row1 = {
                InlineKeyboardButton.builder()
                .callbackData("channels")
                .text("Каналы")
                .build()
        };

        InlineKeyboardButton[] row2 = {
                InlineKeyboardButton.builder()
                        .callbackData("clubBs")
                        .text("Клуб")
                        .build(),
                InlineKeyboardButton.builder()
                        .callbackData("clubBs")
                        .text("Связаться")
                        .build()
        };

        InlineKeyboardButton[] row3 = {
                InlineKeyboardButton.builder()
                        .callbackData("clubBs")
                        .text("Рассылка")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .keyboardRow(new InlineKeyboardRow(row2))
                .build();
    }
}
