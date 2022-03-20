package koinot.com.bot.service;

import koinot.com.bot.entity.User;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.DBservice.QuestionDB;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.telegramBot.Bot;
import koinot.com.bot.util.Dictionary;
import koinot.com.bot.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class BotMenu {

    @Lazy
    @Autowired
    public Bot bot;
    @Autowired
    public WorkingALot workingALot;
    @Autowired
    ExceptionSend exceptionSend;
    @Autowired
    UserDB userService;
    @Autowired
    UserDB userdb;

    @Autowired
    QuestionDB questionDB;

    public void createTest(Update update) {
        Long chat_id = update.getMessage().getFrom().getId();

        User user = new User();
        if (userdb.existsByTelegramId(chat_id)) {
            user = userdb.findAllByTelegramId(chat_id);
        }

        SendMessage sendMessage = new Util().SendCustomMessage(BotAnswerString.CREATE_TEST, update);
        try {
            user.setState(UserState.CREATE_TEST);
            userService.saveUser(user);

            bot.execute(sendMessage);

        } catch (Exception e) {
            exceptionSend.senException("BotMenu createTest => ", e, null);
            log.error("BotMenu createTest => ", e);
        }

    }

    public void checkTest(Update update) {
        Long chatId = update.getMessage().getFrom().getId();

        User user = new User();
        if (userdb.existsByTelegramId(chatId)) {
            user = userdb.findAllByTelegramId(chatId);
        }

        SendMessage sendMessage = new Util().SendCustomMessage(BotAnswerString.CHECK_TEST, update);
        try {
            user.setState(UserState.CHECK_TEST);
            userService.saveUser(user);

            bot.execute(sendMessage);

        } catch (Exception e) {
            exceptionSend.senException("BotMenu checkTest => ", e, null);
            log.error("BotMenu checkTest => ", e);
        }
    }

    public void solveTest(Update update) {
        try {
            Long chatId = update.getMessage().getFrom().getId();

            bot.execute(workingALot.inline(chatId, Collections.singletonList(BotAnswerString.START_TEST_SOLVE), new Dictionary().beforeStartTest(40, 2)));

        } catch (Exception e) {
            exceptionSend.senException("BotMenu solveTest => ", e, null);
            log.error("BotMenu solveTest => ", e);
        }
    }

    public void errorCheckTest(Update update, String error) {
        Long chatId = update.getMessage().getFrom().getId();

        User user = new User();
        if (userdb.existsByTelegramId(chatId)) {
            user = userdb.findAllByTelegramId(chatId);
        }

        SendMessage sendMessage = new Util().SendCustomMessage(error, update);
        try {
            user.setState(UserState.SELECT_MENU);
            userService.saveUser(user);

            bot.execute(sendMessage);

        } catch (Exception e) {
            exceptionSend.senException("BotMenu checkTest => ", e, null);
            log.error("BotMenu checkTest => ", e);
        }
    }

    public void settingsBot(Update update) {
        try {
            Long chatId = update.getMessage().getFrom().getId();

            User user = new User();
            if (userdb.existsByTelegramId(chatId)) {
                user = userdb.findAllByTelegramId(chatId);
            }

            List<User> users = userdb.findAll();

           /* for (User value : users) {

                if(value.getState().equals(UserState.GET_PHONE_NUMBER)){
                    bot.execute(workingALot.makeMessage(value.getTelegramId(), "Assalomu alaykum. Botimizdan to'liq " +
                            "foydalanishingiz uchun, iltimos telefon raqamizni yuboring. Istalgan test yechishingiz " +
                            "mumkin bo'ladi."));
                }

                if(value.getState().equals(UserState.SOLVING_TEST)){
                    bot.execute(workingALot.makeMessage(value.getTelegramId(), "Assalomu alaykum. Testni tugatish " +
                            "esingizdan chiqdi!. Yuqoridagi testdan ''Testni tugatish'' ni bosing!"));
                }

            }
*/
            bot.execute(workingALot.makeMessage(chatId, new Dictionary().getMe(user)));

        } catch (Exception e) {
            exceptionSend.senException("BotMenu checkTest => ", e, null);
            log.error("BotMenu checkTest => ", e);
        }
    }
}