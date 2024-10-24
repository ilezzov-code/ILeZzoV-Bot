package ilezzov.bot.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
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
                .keyboardRow(new InlineKeyboardRow(row3))
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

    public static InlineKeyboardMarkup clubBs() {
        InlineKeyboardButton[] row1 = {
                InlineKeyboardButton.builder()
                        .text("Вступить в клуб")
                        .url("https://link.brawlstars.com/invite/band/ru?tag=2YGLGQGUL&token=49bkmhmw")
                        .build()
        };
        InlineKeyboardButton[] row2 = {
                InlineKeyboardButton.builder()
                        .callbackData("user|backToMenu")
                        .text("В меню")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .keyboardRow(new InlineKeyboardRow(row2))
                .build();
    }

    public static InlineKeyboardMarkup contact() {
        InlineKeyboardButton[] row1 = {
                InlineKeyboardButton.builder()
                        .text("Написать нам")
                        .url("https://t.me/ilezovofficial")
                        .build()
        };
        InlineKeyboardButton[] row2 = {
                InlineKeyboardButton.builder()
                        .callbackData("user|backToMenu")
                        .text("В меню")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .keyboardRow(new InlineKeyboardRow(row2))
                .build();
    }

    public static InlineKeyboardMarkup mailingSetting(Integer isEnable) {
        InlineKeyboardButton[] row1 = new InlineKeyboardButton[1];

        if (isEnable == 1) {
            row1[0] = InlineKeyboardButton.builder()
                            .text("Выключить рассылку")
                            .callbackData("user|mailingDisable")
                            .build();
        }

        else {
            row1[0] = InlineKeyboardButton.builder()
                            .text("Включить рассылку")
                            .callbackData("user|mailingEnable")
                            .build();
        }

        InlineKeyboardButton[] row2 = {
                InlineKeyboardButton.builder()
                        .callbackData("user|backToMenu")
                        .text("В меню")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .keyboardRow(new InlineKeyboardRow(row2))
                .build();
    }

    public static InlineKeyboardMarkup backToMenu() {
        InlineKeyboardButton[] row1 = {
                InlineKeyboardButton.builder()
                        .callbackData("user|backToMenu")
                        .text("В меню")
                        .build()
        };

        return InlineKeyboardMarkup.builder()
                .keyboardRow(new InlineKeyboardRow(row1))
                .build();
    }
}
