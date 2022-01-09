package koinot.com.bot.telegramBot;


import koinot.com.bot.service.GetUpdate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {

//    562505195

    @Value("${bot.token}") private String botToken;

    @Value("${bot.name}") private String botUsername;

    @Autowired GetUpdate getUpdate;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        log.error("bot  AnswerBot=> ",update.getMessage().getText());

        getUpdate.answerBot(update);
    }

    @SneakyThrows
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            try {
                getUpdate.answerBot(update);
            } catch (Exception e) {
                log.error("bot  AnswerBot=> ",e);
            }
        }
    }


}
