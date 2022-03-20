package koinot.com.bot.telegramBot;


import koinot.com.bot.entity.Question;
import koinot.com.bot.entity.RealTimeAnswers;
import koinot.com.bot.entity.User;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.service.GetUpdate;
import koinot.com.bot.service.RegisterUser;
import koinot.com.bot.service.WorkingALot;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {

//    562505195

    @Autowired
    GetUpdate getUpdate;
    @Autowired
    WorkingALot workingALot;
    @Autowired
    UserDB userdb;

    @Autowired
    RegisterUser registerUser;
    @Value("${bot.token}")
    private String botToken;
    @Value("${bot.name}")
    private String botUsername;

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
        log.error("bot  AnswerBot=> ", update.getMessage().getText());
        getUpdate.answerBot(update);
    }

    @SneakyThrows
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            try {
                getUpdate.answerBot(update);
            } catch (Exception e) {
                log.error("bot  AnswerBot=> ", e);
            }
        }
    }

    public void AnswerBotForChannel(Update update, Question question) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(new InputFile(question.getPhotoId()));
        sendPhoto.setCaption(question.getAnswer() + "\n" + question.getCategory().getName() + "\n" + question.getGrade());
        sendPhoto.setChatId(String.valueOf(update.getChannelPost().getChatId()));

        try {
            execute(sendPhoto);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sendTestForUser(Update update, RealTimeAnswers answer) {

        SendPhoto sendPhoto = new SendPhoto();

        Question question = answer.getQuestion();

        sendPhoto.setPhoto(new InputFile(question.getPhotoId()));
        sendPhoto.setChatId(String.valueOf(update.getCallbackQuery().getFrom().getId()));


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();

        List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
        inlineKeyboardButton.add(workingALot.makeMessage("A", "A_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage("B", "B_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage("C", "C_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage("D", "D_" + question.getId() + "_select_test"));
        listListRows.add(inlineKeyboardButton);

        List<InlineKeyboardButton> inlineKeyboardButtonBottom = new ArrayList<>();

        inlineKeyboardButtonBottom.add(workingALot.makeMessage("Oldingi", "oldingi_" + question.getId()));
        inlineKeyboardButtonBottom.add(workingALot.makeMessage(answer.getIndexation() + 1L + " / " + answer.getRealTest().getTestCount(), "nnnn_" + answer.getIndexation()));
        inlineKeyboardButtonBottom.add(workingALot.makeMessage("Keyingi", "keyingi_" + question.getId()));

        listListRows.add(inlineKeyboardButtonBottom);

        List<InlineKeyboardButton> i3 = new ArrayList<>();

        i3.add(workingALot.makeMessage("Testni yakunlash", "endTest_" + answer.getId()));

        listListRows.add(i3);


        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendPhoto);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sendTestById(Update update, RealTimeAnswers answer) {
        EditMessageMedia sendPhoto = new EditMessageMedia();

        Question question = answer.getQuestion();

        InputMedia photo3 = new InputMediaPhoto();
        photo3.setMedia(question.getPhotoId());
        sendPhoto.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        sendPhoto.setMedia(photo3);
        sendPhoto.setChatId(String.valueOf(update.getCallbackQuery().getFrom().getId()));


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();

        List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";

        String whichSelect = answer.getWhichSelected();
        if (whichSelect != null) {
            if (whichSelect.equals(A)) {
                A = "✔️ A";
            } else if (whichSelect.equals(B)) {
                B = "✔️ B";
            } else if (whichSelect.equals(C)) {
                C = "✔️ C";
            } else {
                D = "✔️ D";
            }
        }

        inlineKeyboardButton.add(workingALot.makeMessage(A, "A_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage(B, "B_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage(C, "C_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage(D, "D_" + question.getId() + "_select_test"));
        listListRows.add(inlineKeyboardButton);

        List<InlineKeyboardButton> inlineKeyboardButtonBottom = new ArrayList<>();

        inlineKeyboardButtonBottom.add(workingALot.makeMessage("Oldingi", "oldingi_" + question.getId()));
        inlineKeyboardButtonBottom.add(workingALot.makeMessage(answer.getIndexation() + 1L + " / " + answer.getRealTest().getTestCount(), "nnnn_" + answer.getIndexation()));
        inlineKeyboardButtonBottom.add(workingALot.makeMessage("Keyingi", "keyingi_" + question.getId()));

        listListRows.add(inlineKeyboardButtonBottom);

        List<InlineKeyboardButton> i3 = new ArrayList<>();

        i3.add(workingALot.makeMessage("Testni yakunlash", "endTest_" + answer.getId()));

        listListRows.add(i3);


        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendPhoto);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sendTestById(Update update, RealTimeAnswers answer, String whichSelect) {
        EditMessageMedia sendPhoto = new EditMessageMedia();

        Question question = answer.getQuestion();

        InputMedia photo3 = new InputMediaPhoto();
        photo3.setMedia(question.getPhotoId());
        sendPhoto.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        sendPhoto.setMedia(photo3);
        sendPhoto.setChatId(String.valueOf(update.getCallbackQuery().getFrom().getId()));


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();

        List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";

        if (whichSelect != null) {
            if (whichSelect.equals(A)) {
                A = "✔️ A";
            } else if (whichSelect.equals(B)) {
                B = "✔️ B";
            } else if (whichSelect.equals(C)) {
                C = "✔️ C";
            } else {
                D = "✔️ D";
            }
        }
        inlineKeyboardButton.add(workingALot.makeMessage(A, "A_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage(B, "B_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage(C, "C_" + question.getId() + "_select_test"));
        inlineKeyboardButton.add(workingALot.makeMessage(D, "D_" + question.getId() + "_select_test"));
        listListRows.add(inlineKeyboardButton);

        List<InlineKeyboardButton> inlineKeyboardButtonBottom = new ArrayList<>();

        inlineKeyboardButtonBottom.add(workingALot.makeMessage("Oldingi", "oldingi_" + question.getId()));
        inlineKeyboardButtonBottom.add(workingALot.makeMessage(answer.getIndexation() + 1L + " / " + answer.getRealTest().getTestCount(), "nnnn_" + answer.getIndexation()));
        inlineKeyboardButtonBottom.add(workingALot.makeMessage("Keyingi", "keyingi_" + question.getId()));

        listListRows.add(inlineKeyboardButtonBottom);

        List<InlineKeyboardButton> i3 = new ArrayList<>();

        i3.add(workingALot.makeMessage("Testni yakunlash", "endTest_" + answer.getId()));

        listListRows.add(i3);

        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendPhoto);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sendAllTestWithResult(Update update, User user, List<RealTimeAnswers> answers) {
        try {
            for (RealTimeAnswers answer : answers) {
                Question question = answer.getQuestion();
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setPhoto(new InputFile(question.getPhotoId()));
                String corr;
                if (answer.isCorrect()) corr = "✅";
                else corr = "❌";
                String whichSelect;
                if (answer.getWhichSelected() == null) whichSelect = "[ ]";
                else whichSelect = answer.getWhichSelected();
                String caption = answer.getIndexation() + 1 + " - test savoli.\n\n" + "✅ To'g'ri javob: " + question.getAnswer() + "\nSiz belgilagan javob: " + whichSelect + "\n\nSizning javobingiz: " + corr;

                sendPhoto.setCaption(caption);
                sendPhoto.setChatId(String.valueOf(update.getCallbackQuery().getFrom().getId()));

                execute(sendPhoto);
            }

            user.setState(UserState.SELECT_MENU);
            user.setQuestion(null);
            user.setRealTest(null);
            userdb.saveUser(user);

            registerUser.createMenu(update);
        } catch (Exception e) {
            log.error("Bot sendAllTestWithResult => ", e);
        }
    }

    public void updateChannelTest(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();

            List<PhotoSize> photoList = message.getPhoto();
            PhotoSize photoSize = photoList.get(0);

            String caption = message.getCaption().trim();

            EditMessageMedia sendPhoto = new EditMessageMedia();


            InputMedia photo3 = new InputMediaPhoto();
            photo3.setMedia(photoSize.getFileId());
            photo3.setCaption(caption + "\n\n✅\n\nfileId: " + photoSize.getFileId());
            sendPhoto.setMessageId(message.getMessageId());
            sendPhoto.setMedia(photo3);

            sendPhoto.setChatId(String.valueOf(channelId));

            execute(sendPhoto);
        } catch (Exception e) {
            log.error("BOT updateTest => ", e);
        }
    }

    public void updateChannelTestError(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();

            List<PhotoSize> photoList = message.getPhoto();
            PhotoSize photoSize = photoList.get(0);

            String caption = message.getCaption().trim();

            EditMessageMedia sendPhoto = new EditMessageMedia();


            InputMedia photo3 = new InputMediaPhoto();
            photo3.setMedia(photoSize.getFileId());
            photo3.setCaption(caption + "\n\n❌❌❌\n\nfileId: " + photoSize.getFileId());
            sendPhoto.setMessageId(message.getMessageId());
            sendPhoto.setMedia(photo3);

            sendPhoto.setChatId(String.valueOf(channelId));

            execute(sendPhoto);
        } catch (Exception e) {
            log.error("BOT updateTest => ", e);
        }
    }

}
