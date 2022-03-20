package koinot.com.bot.service.admin;

import koinot.com.bot.entity.Categories;
import koinot.com.bot.entity.Question;
import koinot.com.bot.enums.Subjects;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.BotAnswerString;
import koinot.com.bot.service.DBservice.CategoryDB;
import koinot.com.bot.service.DBservice.QuestionDB;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.service.WorkingALot;
import koinot.com.bot.telegramBot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
@Slf4j
public class AdminService {
    @Lazy
    @Autowired
    public Bot bot;
    @Autowired
    public WorkingALot workingALot;
    @Autowired
    ExceptionSend exceptionSend;
    @Autowired
    CategoryDB categoryDB;
    @Autowired
    QuestionDB questionDB;
    @Autowired
    UserDB userDB;

    public void adminManagement(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();
            String text = message.getText();
            List<PhotoSize> photoList = message.getPhoto();

            if (text != null) {
                if (text.startsWith(BotAnswerString.ADD_CATEGORY)) {
                    createCategory(update);
                }
                if (text.equals(BotAnswerString.GET_CATEGORY)) {
                    getCategory(update);
                }
                if (text.equals(BotAnswerString.TEST)) {
                    getTest(update);
                }
                if (text.equals(BotAnswerString.USER)) {
                    getUser(update);
                }
            }
            if (photoList != null && !photoList.isEmpty()) {
                savePhoto(update);
            }


        } catch (Exception e) {
            exceptionSend.senException("AdminService adminManagement => ", e, null);
            log.error("AdminService adminManagement => ", e);
        }
    }

    private void createCategory(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();
            String text = message.getText();
            if (text.trim().split(" ").length == 2 && text.trim().split(" ")[1].length() > 0) {
                String adminCategory = text.trim().split(" ")[1];

                if (categoryDB.existsByCategoryName(adminCategory)) {
                    bot.execute(workingALot.makeMessageReply(channelId, BotAnswerString.EXIST_THIS_CATEGORY, message.getMessageId()));
                } else {
                    Categories categories = new Categories();
                    categories.setName(adminCategory);
                    categories.setSubjectName(Subjects.INFORMATIKA.name());
                    categoryDB.saveCategory(categories);

                    bot.execute(workingALot.makeMessageReply(channelId, BotAnswerString.SUCCESS_CATEGORY_ADDED, message.getMessageId()));
                }
            } else {
                bot.execute(workingALot.makeMessageReply(channelId, BotAnswerString.PLEASE_SEND_RIGHT_CATEGORY, message.getMessageId()));
            }
        } catch (Exception e) {
            exceptionSend.senException("AdminService createCategory => ", e, null);
            log.error("AdminService createCategory => ", e);
        }
    }

    private void getTest(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();

            Long questionCount = questionDB.countList();

            bot.execute(workingALot.makeMessageReply(channelId, "Bazada jami " + questionCount + " " + "test bor", message.getMessageId()));

        } catch (Exception e) {
            exceptionSend.senException("AdminService getTest => ", e, null);
            log.error("AdminService getTest => ", e);
        }
    }

    private void getUser(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();

            Long userCount = userDB.countList();

            bot.execute(workingALot.makeMessageReply(channelId, "Bazada jami " + userCount + " " + "foydalanuvchi bor", message.getMessageId()));

        } catch (Exception e) {
            exceptionSend.senException("AdminService getUser => ", e, null);
            log.error("AdminService getUser => ", e);
        }
    }


    private void getCategory(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();

            List<Categories> categoriesList = categoryDB.findBySubjectName(Subjects.INFORMATIKA.name());
            if (categoriesList.isEmpty()) {
                bot.execute(workingALot.makeMessageReply(channelId, BotAnswerString.EMPTY_CATEGORY, message.getMessageId()));
            } else {
                StringBuilder categoryList = new StringBuilder();
                for (Categories item : categoriesList) {
                    categoryList.append(item.getId()).append(". ").append(item.getName()).append("\n");
                }
                bot.execute(workingALot.makeMessageReply(channelId, String.valueOf(categoryList), message.getMessageId()));
            }

        } catch (Exception e) {
            exceptionSend.senException("AdminService getCategory => ", e, null);
            log.error("AdminService getCategory => ", e);
        }
    }

    private void savePhoto(Update update) {
        try {
            Message message = update.getChannelPost();
            Long channelId = message.getChatId();
            List<PhotoSize> photoList = message.getPhoto();

            PhotoSize photoSize = photoList.get(0);
            String caption = message.getCaption().trim();
            if (!caption.isEmpty() && caption.charAt(0) >= 'A' && caption.charAt(0) <= 'Z') {
                Question question = new Question();
                question.setActive(true);
                question.setCategory(null);
                question.setPhotoId(photoSize.getFileId());
                question.setGrade("7");
                question.setAnswer(String.valueOf(caption.charAt(0)));

                questionDB.saveQuestion(question);

                bot.updateChannelTest(update);
            } else {
                bot.execute(workingALot.makeMessageReply(channelId, BotAnswerString.NOT_ENOUGH_CAPTION, message.getMessageId()));
            }
        } catch (Exception e) {
            try {
                bot.updateChannelTestError(update);
            } catch (Exception e1) {
                exceptionSend.senException("AdminService savePhoto => ", e, null);
                log.error("AdminService savePhoto => ", e);
            }

        }
    }


    public String getLetters(String text) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char item = text.charAt(i);
            if (isLetter(item)) {
                res.append(item);
            }
        }
        return res.toString();
    }


    public String getDigits(String text) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char item = text.charAt(i);
            if (isDigit(item)) {
                res.append(item);
            }
        }
        return res.toString();
    }


    public boolean isDigit(char number) {
        return number >= '0' && number <= '9';
    }

    public boolean isLetter(char letter) {
        return letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <= 'Z';
    }

}
