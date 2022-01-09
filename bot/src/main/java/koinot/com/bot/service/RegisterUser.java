package koinot.com.bot.service;

import koinot.com.bot.entity.User;
import koinot.com.bot.entity.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.UserService.UserService;
import koinot.com.bot.telegramBot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
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

    @Autowired UserService userService;

   @Lazy @Autowired public Bot bot;

    @Autowired public WorkingALot workingALot;


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
            strings.add(BotAnswerString.uz);

            if (language == null) {
                bot.execute(workingALot.inline(chat_id,strings,BotAnswerString.HELLO_CHOOSE_A_LANGUAGE_EN)); // Sending our message object to user
            } else {
                switch (language) {
                    case (BotAnswerString.en):
                    case ("en"):
                        bot.execute(workingALot.inline(chat_id,strings,BotAnswerString.HELLO_CHOOSE_A_LANGUAGE_EN)); // Sending our message object to user
                        break;
                    case (BotAnswerString.ru):
                    case ("ru"):
                        bot.execute(workingALot.inline(chat_id,strings,BotAnswerString.HELLO_CHOOSE_A_LANGUAGE_RU)); // Sending our message object to user
                        break;
                    case ("uz"):
                    case (BotAnswerString.uzl):
                        bot.execute(workingALot.inline(chat_id,strings,BotAnswerString.HELLO_CHOOSE_A_LANGUAGE_UZL)); // Sending our message object to user
                        break;
                    case (BotAnswerString.uz):
                        bot.execute(workingALot.inline(chat_id,strings,BotAnswerString.HELLO_CHOOSE_A_LANGUAGE_UZ)); // Sending our message object to user
                        break;
                    default:
                        bot.execute(workingALot.inline(chat_id,strings,BotAnswerString.HELLO_CHOOSE_A_LANGUAGE_EN)); // Sending our message object to user
                        break;
                }
            }
        } catch (Exception e) {
            exceptionSend.senException("get language  => ",e,null);
            log.error("get language  => ",e);
        }

    }

}
