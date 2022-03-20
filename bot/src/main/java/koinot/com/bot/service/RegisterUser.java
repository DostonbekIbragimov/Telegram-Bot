package koinot.com.bot.service;

import koinot.com.bot.entity.User;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.telegramBot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RegisterUser {

    @Lazy
    @Autowired
    public Bot bot;
    @Autowired
    public WorkingALot workingALot;
    @Autowired
    ExceptionSend exceptionSend;
    @Autowired
    UserDB userService;

    public void saveFirstName(Update update) {
        try {
            long chatId = 0L;
            if (update.hasMessage()) {
                chatId = update.getMessage().getFrom().getId();
            } else if (update.hasCallbackQuery()) {
                chatId = update.getCallbackQuery().getFrom().getId();
            } else if (update.hasInlineQuery()) {
                chatId = update.getInlineQuery().getFrom().getId();
            }

            User user = new User();
            if (userService.existsByTelegramId(chatId)) {
                user = userService.findAllByTelegramId(chatId);
            }

            Message message = update.getMessage();

            user.setTelegramId(chatId);
            user.setFirstName(message.getText());
            user.setUsername(message.getFrom().getUserName());
            user.setState(UserState.SEND_SURNAME);

            userService.saveUser(user);
            askLastName(update);


        } catch (Exception e) {
            exceptionSend.senException("RegisterUser saveForRegister => ", e, null);
            log.error("RegisterUser saveForRegister => ", e);
        }
    }

    public void saveLastName(Update update) {
        long chatId = 0L;
        if (update.hasMessage()) {
            chatId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chatId = update.getInlineQuery().getFrom().getId();
        }

        User user = new User();
        if (userService.existsByTelegramId(chatId)) {
            user = userService.findAllByTelegramId(chatId);
        }

        Message message = update.getMessage();
        user.setLastName(message.getText());
        user.setState(UserState.GET_PHONE_NUMBER);

        userService.saveUser(user);

        askPhoneNumber(update);
    }

    public void savePhoneNumber(Update update) {
        long chatId = 0L;
        if (update.hasMessage()) {
            chatId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chatId = update.getInlineQuery().getFrom().getId();
        }

        String phoneNumber = update.getMessage().getContact().getPhoneNumber();
        if (phoneNumber != null) {
            if (isRightPhoneNumber(phoneNumber)) {

                User user = new User();
                if (userService.existsByTelegramId(chatId)) {
                    user = userService.findAllByTelegramId(chatId);
                }

                user.setPhoneNumber(phoneNumber);
                user.setVerified(true);
                user.setState(UserState.SELECT_MENU);

                userService.saveUser(user);

                createMenu(update);

            } else askPhoneNumber(update);
        } else askPhoneNumber(update);
    }

    private boolean isRightPhoneNumber(String phone) {
        if (phone.replace(" ", "").replace("+", "").length() != 12) return false;
        else return phone.replace("+", "").replace(" ", "").startsWith("998");
    }

    public void createMenu(Update update) {
        long chatId = 0L;
        if (update.hasMessage()) {
            chatId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chatId = update.getInlineQuery().getFrom().getId();
        }
        User user = new User();
        if (userService.existsByTelegramId(chatId)) {
            user = userService.findAllByTelegramId(chatId);
        }
        user.setState(UserState.SELECT_MENU);
        userService.saveUser(user);

        List<String> menuList = new ArrayList<>();
        menuList.add(BotAnswerString.MENU_ADD_TEST);
        menuList.add(BotAnswerString.MENU_CHECK_TEST);
        menuList.add(BotAnswerString.MENU_SOLVE_TEST);
        menuList.add(BotAnswerString.MENU_SETTINGS);
        SendMessage replyMessageMenu = new WorkingALot().keyboard(chatId, menuList, BotAnswerString.MENU_TEXT);
        try {
            bot.execute(replyMessageMenu);
        } catch (Exception e) {
            exceptionSend.senException("RegisterUser createMenu => ", e, null);
            log.error("RegisterUser createMenu => ", e);
        }
    }

    public void createInviteLink(Update update) {
        long userTelegramId = 0L;
        if (update.hasMessage()) {
            userTelegramId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            userTelegramId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            userTelegramId = update.getInlineQuery().getFrom().getId();
        }

        if (userTelegramId == 0L) {
            return;
        }

        boolean isChannel = checkMemberChannel(update);
        boolean isGroup = checkMemberGroup(update);

        SendMessage sendMessage = workingALot.makeMessage(userTelegramId, BotAnswerString.INVITE_CHANNEL);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();

        List<InlineKeyboardButton> i1 = new ArrayList<>();
        List<InlineKeyboardButton> i2 = new ArrayList<>();
        List<InlineKeyboardButton> i3 = new ArrayList<>();

        InlineKeyboardButton channel = new InlineKeyboardButton();
        channel.setText("Kanalga a'zo bo'ling");
        channel.setUrl("https://t.me/infoituz");
        channel.setCallbackData("channel_subscribe");
        i1.add(channel);

        InlineKeyboardButton group = new InlineKeyboardButton();
        group.setText("Guruhga a'zo bo'ling");
        group.setUrl("https://t.me/infoit_uz");
        group.setCallbackData("group_subscribe");
        i2.add(group);

        InlineKeyboardButton check = new InlineKeyboardButton();
        check.setText("✅ A'zolikni tekshirish");
        check.setCallbackData("check_subscribe");
        i3.add(check);

        listListRows.add(i1);
        listListRows.add(i2);
        listListRows.add(i3);

        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            bot.execute(sendMessage);
        } catch (Exception e) {
            exceptionSend.senException("RegisterUser createInviteLink => ", e, null);
            log.error("RegisterUser createInviteLink => ", e);
        }
    }

    public boolean checkMemberChannel(Update update) {
        long userTelegramId = 0L;
        if (update.hasMessage()) {
            userTelegramId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            userTelegramId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            userTelegramId = update.getInlineQuery().getFrom().getId();
        }

        if (userTelegramId == 0L) {
            return true;
        }

        boolean isChannel = false;
        GetChatMember getChatMember = new GetChatMember();
        getChatMember.setChatId(String.valueOf(-1001795823609L));
        getChatMember.setUserId(userTelegramId);

        try {
            ChatMember chatMember = bot.execute(getChatMember);
            System.err.println(chatMember.getStatus());
            if (chatMember.getStatus().equals("creator")) {
                isChannel = true;
            } else if (chatMember.getStatus().equals("administrator")) {
                isChannel = true;
            } else isChannel = chatMember.getStatus().equals("member");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return isChannel;
    }

    public boolean checkMemberGroup(Update update) {
        long userTelegramId = 0L;
        if (update.hasMessage()) {
            userTelegramId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            userTelegramId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            userTelegramId = update.getInlineQuery().getFrom().getId();
        }

        if (userTelegramId == 0L) {
            return true;
        }
        boolean isGroup = false;

        GetChatMember getChatMember = new GetChatMember();
        getChatMember.setChatId(String.valueOf(-1001751223938L));
        getChatMember.setUserId(userTelegramId);

        try {
            ChatMember chatMember = bot.execute(getChatMember);
            System.err.println(chatMember.getStatus());
            if (chatMember.getStatus().equals("creator")) {
                isGroup = true;
            } else if (chatMember.getStatus().equals("administrator")) {
                isGroup = true;
            } else isGroup = chatMember.getStatus().equals("member");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return isGroup;
    }


    public void askFirstName(Update update) {
        long chatId = 0L;
        if (update.hasMessage()) {
            chatId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chatId = update.getInlineQuery().getFrom().getId();
        }


        User user = new User();
        if (userService.existsByTelegramId(chatId)) {
            user = userService.findAllByTelegramId(chatId);
        }
        user.setTelegramId(chatId);
        user.setState(UserState.SEND_NAME);
        userService.saveUser(user);

        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.HTML);
        message.setChatId(String.valueOf(chatId));
        message.setText(BotAnswerString.ASK_FIRST_NAME);

        ReplyKeyboardRemove replyMarkup = new ReplyKeyboardRemove();
        replyMarkup.setRemoveKeyboard(true);

        message.setReplyMarkup(replyMarkup);

        try {
            bot.execute(message);
        } catch (Exception e) {
            exceptionSend.senException("RegisterUser askFirstLastName => ", e, null);
            log.error("RegisterUser askFirstLastName => ", e);
        }
    }

    public void askLastName(Update update) {
        long chatId = 0L;
        if (update.hasMessage()) {
            chatId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chatId = update.getInlineQuery().getFrom().getId();
        }

        User user = new User();
        if (userService.existsByTelegramId(chatId)) {
            user = userService.findAllByTelegramId(chatId);
        }
        user.setState(UserState.SEND_SURNAME);
        userService.saveUser(user);

        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.HTML);
        message.setChatId(String.valueOf(chatId));
        message.setText(BotAnswerString.ASK_LAST_NAME);

        ReplyKeyboardRemove replyMarkup = new ReplyKeyboardRemove();
        replyMarkup.setRemoveKeyboard(true);

        message.setReplyMarkup(replyMarkup);

        try {
            bot.execute(message);
        } catch (Exception e) {
            exceptionSend.senException("RegisterUser askLastName => ", e, null);
            log.error("RegisterUser askLastName => ", e);
        }
    }

    public void askPhoneNumber(Update update) {
        long chatId = 0L;
        if (update.hasMessage()) {
            chatId = update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getFrom().getId();
        } else if (update.hasInlineQuery()) {
            chatId = update.getInlineQuery().getFrom().getId();
        }

        User user = new User();
        if (userService.existsByTelegramId(chatId)) {
            user = userService.findAllByTelegramId(chatId);
        }
        user.setState(UserState.GET_PHONE_NUMBER);
        userService.saveUser(user);

        SendMessage replyMessageMenu = new WorkingALot().phoneNumber(chatId, BotAnswerString.PHONE_NUMBER_BUTTON, BotAnswerString.ASK_PHONE_NUMBER);

        try {
            bot.execute(replyMessageMenu);
        } catch (Exception e) {
            exceptionSend.senException("RegisterUser createMenu => ", e, null);
            log.error("RegisterUser createMenu => ", e);
        }
    }
}
