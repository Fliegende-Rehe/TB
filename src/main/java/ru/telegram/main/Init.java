package ru.telegram.main;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.telegram.parser.Properties.Property;

import static ru.telegram.parser.Properties.Get;

public class Init {
    public static void main(String[] args) {
        try {
            Property config = Get("src/main/resources/config.properties");
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            assert config != null;
            botsApi.registerBot(new Receive(config.getUsername(), config.getToken()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}