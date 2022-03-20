package koinot.com.bot.service;


import koinot.com.bot.entity.just.Answers;
import koinot.com.bot.entity.just.CheckTests;
import koinot.com.bot.entity.User;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.DBservice.AnswersDB;
import koinot.com.bot.service.DBservice.CheckTestsDB;
import koinot.com.bot.service.DBservice.UserDB;
import koinot.com.bot.telegramBot.Bot;
import koinot.com.bot.util.Dictionary;
import koinot.com.bot.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Slf4j
public class CheckTest {

    @Autowired
    ExceptionSend exceptionSend;

    @Autowired
    UserDB userService;

    @Lazy
    @Autowired
    public Bot bot;

    @Autowired
    public WorkingALot workingALot;

    @Autowired
    UserDB userdb;

    @Autowired
    CheckTestsDB checkTestsDB;

    @Autowired
    AnswersDB answersDB;

    @Autowired
    BotMenu botMenu;

    public boolean isRightAddTest(Update update) {
        String text = update.getMessage().getText();
        if (!text.startsWith("+test*")) return false;
        String[] keysArr = text.trim().split("\\*");
        if (keysArr.length != 3) return false;
        if (keysArr[0].length() == 0) return false;
        if (keysArr[1].length() == 0) return false;
        if (keysArr[2].length() == 0) return false;
        return isRightTestKeys(keysArr[2]);
    }

    private boolean isRightTestKeys(String keys) {
        int length = keys.length();
        if (length > 298) return false;
        if (length < 1) return false;

        if (isNumbersKeys(keys)) {
            // raqamli kalitlar 1a2a3a4a...
            if (length < 18) {
                if (length % 2 != 0) return false;
                for (int i = 0; i < length; i++) {
                    if (i % 2 == 0) {
                        if (!isDigit(keys.charAt(i))) return false;
                    } else {
                        if (!isLetter(keys.charAt(i))) return false;
                    }
                }
            } else {
                if (length % 3 != 0) return false;
                for (int i = 18; i < length; i++) {
                    if (i % 3 == 0) {
                        if (!isDigit(keys.charAt(i))) return false;
                    } else if (i % 3 == 1) {
                        if (!isDigit(keys.charAt(i))) return false;
                    } else {
                        if (!isLetter(keys.charAt(i))) return false;
                    }
                }
            }
            return true;
        }

        return true;
    }

    public boolean isDigit(char number) {
        return number >= '0' && number <= '9';
    }

    public boolean isLetter(char letter) {
        return letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <= 'Z';
    }

    private boolean isNumbersKeys(String keys) {
        return keys.charAt(0) >= '0' && keys.charAt(0) <= '9';
    }

    public void addTest(Update update) {
        Long chat_id = update.getMessage().getFrom().getId();

        User user = new User();
        if (userdb.existsByTelegramId(chat_id)) {
            user = userdb.findAllByTelegramId(chat_id);
        }

        CheckTests tests = new CheckTests();
        tests.setActive(true);
        tests.setUsers(user);


        String text = update.getMessage().getText();
        String[] keysArr = text.trim().split("\\*");
        tests.setSubjectName(keysArr[1]);
        String answers = getTestAnswers(keysArr[2]);
        tests.setTestAnswer(answers);
        tests.setTestCount(answers.length());

        CheckTests newTest = checkTestsDB.saveTest(tests);

        String addedTest = new Dictionary().successfulTestAdded(newTest.getId(), newTest.getTestCount());
        SendMessage sendMessage = new Util().SendCustomMessage(addedTest, update);
        sendMessage.setParseMode(ParseMode.HTML);
        try {
            user.setState(UserState.SELECT_MENU);
            userService.saveUser(user);

            bot.execute(sendMessage);

        } catch (Exception e) {
            exceptionSend.senException("BotMenu createTest => ", e, null);
            log.error("BotMenu createTest => ", e);
        }

    }

    private String getTestAnswers(String keys) {
        int length = keys.length();
        if (isNumbersKeys(keys)) {
            // raqamli kalitlar 1a2a3a4a...
            StringBuilder newKeys = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (isLetter(keys.charAt(i))) {
                    newKeys.append(keys.charAt(i));
                }
            }
            return String.valueOf(newKeys);
        } else return keys;
    }

    public void isRightCheckTest(Update update) {
        Long chat_id = update.getMessage().getFrom().getId();
        User user = new User();
        if (userdb.existsByTelegramId(chat_id)) {
            user = userdb.findAllByTelegramId(chat_id);
        }

        String text = update.getMessage().getText();
        String[] keysArr = text.trim().split("\\*");
        if (keysArr.length != 2) {
            botMenu.errorCheckTest(update, BotAnswerString.ERROR_CHECK_TEST);
        } else if (keysArr[0].length() == 0) {
            botMenu.errorCheckTest(update, BotAnswerString.ERROR_CHECK_TEST);
        } else if (keysArr[1].length() == 0) {
            botMenu.errorCheckTest(update, BotAnswerString.ERROR_CHECK_TEST);
        }
        if (keysArr.length == 2) {
            CheckTests checkTests = new CheckTests();
            Long checkTestId = Long.valueOf(keysArr[0]);
            if (checkTestsDB.existsByCheckTestId(checkTestId)) {
                if (checkTestsDB.findById(checkTestId).isPresent())
                    checkTests = checkTestsDB.findById(checkTestId).get();

                String answers = checkTests.getTestAnswer();
                int testCount = checkTests.getTestCount();

                StringBuilder userTestAnswers = new StringBuilder();
                for (int i = 0; i < keysArr[1].length(); i++) {
                    if (isLetter(keysArr[1].charAt(i))) {
                        userTestAnswers.append(keysArr[1].charAt(i));
                    }
                }
                if (!checkTests.isActive()) {
                    botMenu.errorCheckTest(update, BotAnswerString.ERROR_TEST_DISABLED);
                } else if (testCount != userTestAnswers.length()) {
                    botMenu.errorCheckTest(update, new Dictionary().errorCheckTestNotEnough(checkTestId, testCount, userTestAnswers.length()));
                } else {
                    int rightCount = 0;
                    for (int i = 0; i < answers.length(); i++) {
                        if (answers.charAt(i) == userTestAnswers.charAt(i)) {
                            rightCount++;
                        }
                    }

                    Answers answers1 = new Answers();
                    answers1.setUsers(user);
                    answers1.setTests(checkTests);
                    answers1.setCorrectAnswer(rightCount);
                    answers1.setTestCount(testCount);
                    answers1.setCorrectRate(rightCount * 100 / testCount);
                    answersDB.saveAnswer(answers1);


                    sendResultsForUser(update, checkTests, answers1);
                    sendResultsForAdmin(update, user, answers1, checkTests);

                    user.setState(UserState.SELECT_MENU);
                    userdb.saveUser(user);

                }
            } else botMenu.errorCheckTest(update, BotAnswerString.ERROR_TEST_ID_NOT_FOUND);
        } else {
            user.setState(UserState.SELECT_MENU);
            userdb.saveUser(user);
        }
    }

    public void sendResultsForUser(Update update, CheckTests checkTests, Answers answers) {

        Long chatId = update.getMessage().getFrom().getId();

        User user = new User();
        if (userdb.existsByTelegramId(chatId)) {
            user = userdb.findAllByTelegramId(chatId);
        }

        SendMessage sendMessage = new Util().SendCustomMessage(new Dictionary().successfulSendForResult(user, checkTests, answers), update);
        sendMessage.setParseMode(ParseMode.HTML);

        try {
            user.setState(UserState.SELECT_MENU);
            userService.saveUser(user);

            bot.execute(sendMessage);

        } catch (Exception e) {
            exceptionSend.senException("BotMenu checkTest => ", e, null);
            log.error("BotMenu checkTest => ", e);
        }

    }

    public void sendResultsForAdmin(Update update, User user, Answers answers, CheckTests checkTests) {
        User owner = checkTests.getUsers();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(owner.getTelegramId()));
        sendMessage.setParseMode(ParseMode.HTML);
        sendMessage.setText(new Dictionary().sendResultForAdmin(user, checkTests, answers));

        try {
            bot.execute(sendMessage);
        } catch (Exception e) {
            exceptionSend.senException("BotMenu checkTest => ", e, null);
            log.error("BotMenu checkTest => ", e);
        }
    }

    public void checkTest(Update update) {

    }
}
