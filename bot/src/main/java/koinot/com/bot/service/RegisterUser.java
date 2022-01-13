package koinot.com.bot.service;

import koinot.com.bot.entity.Messages;
import koinot.com.bot.entity.User;
import koinot.com.bot.entity.enums.Msg;
import koinot.com.bot.entity.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.DBservice.MessageDB;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.telegramBot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: RegisterUser  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 3:45 AM $
 * @author: Qudratjon Komilov
 */
@Service
@Slf4j
public class RegisterUser {

    @Autowired ExceptionSend exceptionSend;

    @Autowired UserDB userService;

    @Lazy @Autowired public Bot bot;

    @Autowired public WorkingALot workingALot;

    @Autowired MessageDB messageDB;



    public void userLanguage(Update update) {
        try {
            long chat_id=update.getMessage().getChatId();

            Long id=update.getMessage().getFrom().getId();
            if (userService.existsByTelegramId(id)) {
                User user=userService.findAllByTelegramId(id);
                if (user.getLanguage() == null) {
                    getLanguage(update.getMessage().getFrom().getLanguageCode(),chat_id);
                } else {

                }
            } else {

                User user=new User();
                user.setTelegramId(id);
                user.setFirstName(update.getMessage().getFrom().getFirstName());
                user.setLastName(update.getMessage().getFrom().getLastName());
                user.setState(UserState.CHOOSE_LANGUAGE);
                user.setUsername(update.getMessage().getFrom().getUserName());

                userService.saveUser(user);
                getLanguage(update.getMessage().getFrom().getLanguageCode(),chat_id);
            }
        } catch (Exception e) {
            exceptionSend.senException("user language => ",e,null);
            log.error("user language => ",e);
        }
    }

    public void editLanguage(Update update) {
        int message_id=update.getCallbackQuery().getMessage().getMessageId();
        long chat_id=update.getCallbackQuery().getMessage().getChatId();
        try {
            Long id=update.getCallbackQuery().getFrom().getId();
            User user=userService.findAllByTelegramId(id);
            String s=update.getCallbackQuery().getData();
            user.setLanguage(s);
            user.setState(UserState.DEFAULT);
            userService.saveUser(user);

//            send(update.getMessage().getChatId(),messageDB.getMessage(Msg.HELLO).getTextEn());


        } catch (Exception e) {
            exceptionSend.senException("edit language => ",e,null);
            log.error("edit language => ",e);
        }
    }

    public void sendVideo(Update update) {
//        try{
//            bot.execute( new SendVideo().setChatId( update.getMessage().getChatId() )
//                    .setVideo( BotAnswerString.VIDEO_FOR_EXPLAINING_BOT ) );
//        }catch(TelegramApiException e){
//            e.printStackTrace();
//        }
    }

    public void getLanguage(String language,long chat_id) {
        try {
            List<String> strings=new ArrayList<>();
            strings.add(BotAnswerString.en);
            strings.add(BotAnswerString.ru);
            strings.add(BotAnswerString.uzl);
            Messages message=messageDB.getMessage(Msg.HELLO_CHOOSE_A_LANGUAGE);

            if (language == null) {
                bot.execute(
                        workingALot.inline(chat_id,strings,message.getTextEn())); // Sending our message object to user
            } else {
                switch (language) {
                    case (BotAnswerString.en):
                    case ("en"):
                        bot.execute(workingALot.inline(chat_id,strings,
                                                       message.getTextEn())); // Sending our message object to user
                        break;
                    case (BotAnswerString.ru):
                    case ("ru"):
                        bot.execute(workingALot.inline(chat_id,strings,
                                                       message.getTextRu())); // Sending our message object to user
                        break;
                    case ("uz"):
                    case (BotAnswerString.uz):
                        bot.execute(workingALot.inline(chat_id,strings,
                                                       message.getTextUz())); // Sending our message object to user
                        break;
                    default:
                        bot.execute(workingALot.inline(chat_id,strings,
                                                       message.getTextEn())); // Sending our message object to user
                        break;
                }
            }
        } catch (Exception e) {
            exceptionSend.senException("get language  => ",e,null);
            log.error("get language  => ",e);
        }

    }



}
