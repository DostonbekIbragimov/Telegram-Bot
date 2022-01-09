package koinot.com.bot.service;

import koinot.com.bot.entity.User;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.repository.UserRepository;
import koinot.com.bot.service.UserService.UserService;
import koinot.com.bot.telegramBot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @className: GetUpdate  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 2:16 AM $
 * @author: Qudratjon Komilov
 */

@Service
@Slf4j
public class GetUpdate {
    @Lazy @Autowired public Bot bot;

    @Autowired ExceptionSend exceptionSend;

    @Autowired UserService userService;

    @Autowired RegisterUser registerUser;



    public void answerBot(Update update) throws TelegramApiException {
        if (update.hasMessage()) {
            SendChatAction sendChatAction=new SendChatAction();
            sendChatAction.setChatId(String.valueOf(update.getMessage().getChatId()));
            sendChatAction.setAction(ActionType.TYPING);
            bot.execute(sendChatAction);

            if (update.getMessage().hasLocation()) {

            } else {
                AnswerBotMessage(update);
            }
        } else if (update.hasCallbackQuery()) {
            SendChatAction sendChatAction=new SendChatAction();
            sendChatAction.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            sendChatAction.setAction(ActionType.TYPING);
            bot.execute(sendChatAction);
            AnswerBotCallbackQuery(update);
        } else if (update.hasInlineQuery()) {
            SendChatAction sendChatAction=new SendChatAction();
            sendChatAction.setChatId(String.valueOf(update.getInlineQuery().getFrom().getId()));
            sendChatAction.setAction(ActionType.TYPING);
            bot.execute(sendChatAction);
            AnswerBotInlineMode(update);
        }
    }

    public void AnswerBotCallbackQuery(Update update) throws TelegramApiException {

    }

    public void AnswerBotInlineMode(Update update) throws TelegramApiException {
//        inlineQueryAnswerService.inlineQuery(update);
    }

    public void AnswerBotMessage(Update update) {
        Message message = update.getMessage();
        Long id = update.getMessage().getFrom().getId();
        String language = BotAnswerString.uzl;
        User user = new User();
        if(userService.existsByTelegramId( id )){
            user = userService.findAllByTelegramId( id );
            if(user.getLanguage() != null){
                language = user.getLanguage();
            }
        }

        if(message.getText().equals( "/start" )){
            registerUser.userLanguage( update );
            registerUser.sendVideo( update );
        }
        send(update.getMessage().getChatId(),"hello");

    }

    public boolean send(Long chat_id,String text) {
        try {

            SendMessage message=new SendMessage();
            message.setChatId(String.valueOf(chat_id));
            message.setText(text);
            bot.execute(message);
            return true;

        } catch (Exception e) {
            exceptionSend.senException("send ",e,null);
            log.error("send ",e);
            return false;
        }
    }

}
