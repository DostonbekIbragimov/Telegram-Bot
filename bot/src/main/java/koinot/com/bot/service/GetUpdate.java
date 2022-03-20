package koinot.com.bot.service;

import koinot.com.bot.entity.User;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.service.admin.AdminService;
import koinot.com.bot.service.solve.StartSolvingTest;
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
 * @author: Dostonbek Ibragimov
 */

@Service
@Slf4j
public class GetUpdate {
    @Lazy
    @Autowired
    public Bot bot;

    @Autowired
    ExceptionSend exceptionSend;

    @Autowired
    UserDB userdb;

    @Autowired
    RegisterUser registerUser;

    @Autowired
    BotMenu botMenu;

    @Autowired
    CheckTest checkTest;

    @Autowired
    AdminService adminService;

    @Autowired
    StartSolvingTest startSolvingTest;


    public void answerBot(Update update) throws TelegramApiException {
        if (update.hasChannelPost()) {
            if (update.getChannelPost().getChatId() == -1001560114396L) {
                adminService.adminManagement(update);
            }
        }
        if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            if (data != null && data.equals("check_subscribe")) {
                if (!registerUser.checkMemberChannel(update) || !registerUser.checkMemberGroup(update)) {
                    long chatId = update.getCallbackQuery().getFrom().getId();
                    bot.execute(registerUser.workingALot.makeMessage(chatId, "Hali a'zo bo'lmagansiz"));
                    return;
                } else {
                    long chat_id = 0L;
                    if (update.hasMessage()) {
                        chat_id = update.getMessage().getFrom().getId();
                    } else if (update.hasCallbackQuery()) {
                        chat_id = update.getCallbackQuery().getFrom().getId();
                    } else if (update.hasInlineQuery()) {
                        chat_id = update.getInlineQuery().getFrom().getId();
                    }

                    User user = new User();
                    if (userdb.existsByTelegramId(chat_id)) {
                        user = userdb.findAllByTelegramId(chat_id);
                    }

                    if (user.getFirstName() == null) {
                        registerUser.askFirstName(update);
                    } else if (user.getLastName() == null) {
                        registerUser.askLastName(update);
                    } else if (user.getPhoneNumber() == null) {
                        registerUser.askPhoneNumber(update);
                    } else registerUser.createMenu(update);
                }
            }
        }
        if (update.hasMessage()) {
            SendChatAction sendChatAction = new SendChatAction();
            sendChatAction.setChatId(String.valueOf(update.getMessage().getChatId()));
            sendChatAction.setAction(ActionType.TYPING);
            bot.execute(sendChatAction);
            if (update.getMessage().hasLocation()) {

            } else {
                Message message = update.getMessage();
                long chatId = message.getChatId();
                if (chatId != -1001751223938L) {
                    AnswerBotMessage(update);
                }
            }
        } else if (update.hasCallbackQuery()) {
            SendChatAction sendChatAction = new SendChatAction();
            sendChatAction.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            sendChatAction.setAction(ActionType.TYPING);
            bot.execute(sendChatAction);
            AnswerBotCallbackQuery(update);
        } else if (update.hasInlineQuery()) {
            SendChatAction sendChatAction = new SendChatAction();
            sendChatAction.setChatId(String.valueOf(update.getInlineQuery().getFrom().getId()));
            sendChatAction.setAction(ActionType.TYPING);
            bot.execute(sendChatAction);
            AnswerBotInlineMode(update);
        }
    }

    public void AnswerBotCallbackQuery(Update update) {
        String data = update.getCallbackQuery().getData();
        Long chat_id = update.getCallbackQuery().getFrom().getId();

        User user = new User();
        if (userdb.existsByTelegramId(chat_id)) {
            user = userdb.findAllByTelegramId(chat_id);
        }
        if (!registerUser.checkMemberChannel(update) || !registerUser.checkMemberGroup(update)) {
            registerUser.createInviteLink(update);
        } else if (data != null && data.equals(BotAnswerString.START_TEST_SOLVE_CALLBACK_DATA)) {
            startSolvingTest.startSolvingTest(update);
        }
        if (data != null && data.startsWith("oldingi_")) {
            startSolvingTest.startSolvingTestPrevious(update);
        }
        if (data != null && data.startsWith("keyingi_")) {
            startSolvingTest.startSolvingTestNext(update);
        }
        if (data != null && data.endsWith("_select_test")) {
            startSolvingTest.selectedTest(update);
        }
        if (data != null && data.startsWith("endTest_")) {
            startSolvingTest.endTest(update);
        }
        log.info("user callback query " + update.getCallbackQuery().getData());
    }

    public void AnswerBotInlineMode(Update update) throws TelegramApiException {
        if (!registerUser.checkMemberChannel(update) || !registerUser.checkMemberGroup(update)) {
            registerUser.createInviteLink(update);
        }
    }

    public void AnswerBotMessage(Update update) {

        long chat_id = 0L;
        if (update.hasMessage()) {
            chat_id = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chat_id = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chat_id = update.getInlineQuery().getFrom().getId();
        }

        User user = new User();
        if (userdb.existsByTelegramId(chat_id)) {
            user = userdb.findAllByTelegramId(chat_id);
        }

        Message message = update.getMessage();

        if (!registerUser.checkMemberChannel(update) || !registerUser.checkMemberGroup(update)) {
            registerUser.createInviteLink(update);
        } else if (user.getState() == null && !message.getText().equals("/start")) {
            registerUser.askFirstName(update);
        } else if (message.getText() != null && message.getText().equals("/start")) {
            if (user.getFirstName() == null) {
                registerUser.askFirstName(update);
            } else if (user.getLastName() == null) {
                registerUser.askLastName(update);
            } else if (user.getPhoneNumber() == null) {
                registerUser.askPhoneNumber(update);
            } else registerUser.createMenu(update);
        } else if (user.getState() != null && user.getState().equals(UserState.SEND_NAME)) {
            registerUser.saveFirstName(update);
        } else if (user.getState() != null && user.getState().equals(UserState.SEND_SURNAME)) {
            registerUser.saveLastName(update);
        } else if (message.hasContact() && user.getState() != null && user.getState().equals(UserState.GET_PHONE_NUMBER)) {
            registerUser.savePhoneNumber(update);
        }

        /*       Select menu       */
        else if (user.getState() != null && user.getState().equals(UserState.SELECT_MENU)) {

            if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_ADD_TEST)) {
                botMenu.createTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_CHECK_TEST)) {
                botMenu.checkTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_SOLVE_TEST)) {
                botMenu.solveTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_SETTINGS)) {
                botMenu.settingsBot(update);
            }

        }

        /*       Create test       */
        else if (user.getState() != null && user.getState().equals(UserState.CREATE_TEST)) {
            if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_ADD_TEST)) {
                botMenu.createTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_CHECK_TEST)) {
                botMenu.checkTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_SOLVE_TEST)) {
                botMenu.solveTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_SETTINGS)) {
                botMenu.settingsBot(update);
            } else if (checkTest.isRightAddTest(update)) checkTest.addTest(update);
            else botMenu.createTest(update);
        }

        /*       Check test       */
        else if (user.getState() != null && user.getState().equals(UserState.CHECK_TEST)) {
            if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_ADD_TEST)) {
                botMenu.createTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_CHECK_TEST)) {
                botMenu.checkTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_SOLVE_TEST)) {
                botMenu.solveTest(update);
            } else if (message.getText() != null && message.getText().equals(BotAnswerString.MENU_SETTINGS)) {
                botMenu.settingsBot(update);
            } else checkTest.isRightCheckTest(update);
        } else if (user.getState() != null && user.getState().equals(UserState.SOLVING_TEST)) {
            startSolvingTest.solveTest(update);
        }

    }


    public boolean send(Long chat_id, String text) {
        try {

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chat_id));
            message.setText(text);
            bot.execute(message);
            return true;

        } catch (Exception e) {
            exceptionSend.senException("send ", e, null);
            log.error("send ", e);
            return false;
        }
    }

}
