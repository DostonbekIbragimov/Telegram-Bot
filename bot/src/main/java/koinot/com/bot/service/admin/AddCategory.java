package koinot.com.bot.service.admin;

import koinot.com.bot.entity.User;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.DBservice.CategoryDB;
import koinot.com.bot.service.WorkingALot;
import koinot.com.bot.telegramBot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Slf4j
public class AddCategory {

    @Autowired
    ExceptionSend exceptionSend;

    @Autowired
    CategoryDB categoryDB;

    @Lazy
    @Autowired
    public Bot bot;

    @Autowired
    public WorkingALot workingALot;

    public void addCategory(Update update) {
        try {
            long chatId = update.getChannelPost().getChatId();


        } catch (Exception e) {
            exceptionSend.senException("RegisterUser saveForRegister => ", e, null);
            log.error("RegisterUser saveForRegister => ", e);
        }
    }
}
