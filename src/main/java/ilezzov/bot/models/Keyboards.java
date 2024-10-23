package ilezzov.bot.models;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

public class Keyboards {
    public static InlineKeyboardMarkup menu() {
        InlineKeyboardButton[] row1 = {
                InlineKeyboardButton.builder()
                .callbackData("user|channels")
                .text("Каналы")
                .build()
        };

        InlineKeyboardButton[] row2 = {
                InlineKeyboardButton.builder()
                        .callbackData("user|clubBs")
                        .text("Клуб")
                        .build(),
                InlineKeyboardButton.builder()
                        .callbackData("user|contact")
                        .text("Связаться")
                        .build()
        };

        InlineKeyboardButton[] row3 = {
                InlineKeyboardButton.builder()
                        .callbackData("user|mailing")
                        .text("Рассылка")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .keyboardRow(new InlineKeyboardRow(row2))
                .build();
    }

    public static InlineKeyboardMarkup newUser() {
        InlineKeyboardButton[] row1 = {
                InlineKeyboardButton.builder()
                        .callbackData("admin|newUserStats")
                        .text("Статистика")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .build();
    }
}
