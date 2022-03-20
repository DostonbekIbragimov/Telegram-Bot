package koinot.com.bot.service.solve;

import koinot.com.bot.entity.Question;
import koinot.com.bot.entity.RealTimeAnswers;
import koinot.com.bot.entity.User;
import koinot.com.bot.entity.real.RealTest;
import koinot.com.bot.enums.UserState;
import koinot.com.bot.exception.ExceptionSend;
import koinot.com.bot.service.BotAnswerString;
import koinot.com.bot.service.DBservice.*;
import koinot.com.bot.service.WorkingALot;
import koinot.com.bot.telegramBot.Bot;
import koinot.com.bot.util.Dictionary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
@Slf4j
public class StartSolvingTest {

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
    CheckTestsDB checkTestsDB;

    @Autowired
    AnswersDB answersDB;

    @Autowired
    QuestionDB questionDB;

    @Autowired
    RealTimeAnswersDB realTimeAnswersDB;

    @Autowired
    RealTestDB realTestDB;

    @Value("${total.question.count}")
    private int questionCount;

    public void solveTest(Update update) {
        try {
            Long chatId = update.getMessage().getFrom().getId();

            User user = new User();
            if (userdb.existsByTelegramId(chatId)) {
                user = userdb.findAllByTelegramId(chatId);
            }

            RealTest realTest1 = user.getRealTest();

            if (realTest1 != null) {
                Long whenClosed = realTest1.getCloseWhenTest();
                Long timeNow = System.currentTimeMillis();

                if (whenClosed - timeNow > 0) {
                    bot.execute(workingALot.makeMessage(chatId, BotAnswerString.YOU_ARE_SOLVING_TEST));
                } else if (user.getState().equals(UserState.SOLVING_TEST)) {
                    sendResult(update);
                }
            }

        } catch (Exception e) {
            exceptionSend.senException("StartSolvingTest solveTest => ", e, null);
            log.error("StartSolvingTest solveTest => ", e);
        }

    }

    public void startSolvingTest(Update update) {
        try {
            long chatId = getChatId(update);

            if (chatId == 0L) {
                return;
            }

            DeleteMessage deleteMessage = new DeleteMessage();

            try {
                deleteMessage.setChatId(String.valueOf(chatId));
                deleteMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            } catch (Exception e) {
                exceptionSend.senException("StartSolvingTest deleteMessage => ", e, null);
                log.error("StartSolvingTest deleteMessage => ", e);
            }


            User user = new User();
            if (userdb.existsByTelegramId(chatId)) {
                user = userdb.findAllByTelegramId(chatId);
            }

            if (user.getTelegramId() != null && user.getRealTest() != null) {
                RealTest realTest1 = user.getRealTest();

                Long whenClosed = realTest1.getCloseWhenTest();
                Long timeNow = System.currentTimeMillis();

                if (whenClosed - timeNow > 0) {
                    bot.execute(workingALot.makeMessage(chatId, BotAnswerString.YOU_ARE_SOLVING_TEST));
                } else if (user.getState().equals(UserState.SOLVING_TEST)) {
                    sendResult(update);
                }
            } else {

                List<Question> generation = questionDB.generation(questionCount);

                bot.execute(workingALot.makeMessage(chatId, "Test boshlandi.\nSizga omad tilaymiz. Testlar soni: " + generation.size() + " ta"));

                RealTest realTest = new RealTest();

                realTest.setFileId(generation);

                realTest.setUsers(user);

                realTest.setTestCount(generation.size());

                long timeMillis = System.currentTimeMillis() + generation.size() * 2 * 60 * 1000L;

                realTest.setCloseWhenTest(timeMillis);

                realTestDB.saveRealTest(realTest);

                int i = 0;
                for (Question question : generation) {
                    RealTimeAnswers r = new RealTimeAnswers();
                    r.setIndexation(i);
                    r.setQuestion(question);
                    r.setUsers(user);
                    r.setRealTest(realTest);
                    realTimeAnswersDB.saveRealTimeAnswer(r);
                    i++;
                }

                user.setRealTest(realTest);

                user.setQuestion(generation.get(0));

                user.setState(UserState.SOLVING_TEST);

                userdb.saveUser(user);

                bot.sendTestForUser(update, realTimeAnswersDB.getAnswer(user));

                bot.execute(deleteMessage);
            }


        } catch (Exception e) {
            exceptionSend.senException("StartSolvingTest startSolvingTest => ", e, null);
            log.error("StartSolvingTest startSolvingTest => ", e);
        }
    }

    public void startSolvingTestPrevious(Update update) {
        if (update.getCallbackQuery() != null) {
            long chatId = getChatId(update);

            if (chatId == 0L) {
                return;
            }

            User user = new User();
            if (userdb.existsByTelegramId(chatId)) {
                user = userdb.findAllByTelegramId(chatId);
            }

            if (user.getRealTest() != null) {
                RealTimeAnswers answers = realTimeAnswersDB.getPrevious(user);

                if (answers != null) {
                    Question question = answers.getQuestion();

                    user.setQuestion(question);

                    userdb.saveUser(user);

                    bot.sendTestById(update, answers);
                }
            }
        }
    }

    public void startSolvingTestNext(Update update) {
        long chatId = getChatId(update);
        if (chatId == 0L) {
            return;
        }


        User user = new User();
        if (userdb.existsByTelegramId(chatId)) {
            user = userdb.findAllByTelegramId(chatId);
        }

        if (user.getRealTest() != null) {
            RealTimeAnswers answers = realTimeAnswersDB.getNext(user);

            if (answers != null) {
                Question question = answers.getQuestion();

                user.setQuestion(question);

                userdb.saveUser(user);

                bot.sendTestById(update, answers);
            }
        }
    }

    public void selectedTest(Update update) {
        long chatId = getChatId(update);
        if (chatId == 0L) {
            return;
        }


        User user = new User();
        if (userdb.existsByTelegramId(chatId)) {
            user = userdb.findAllByTelegramId(chatId);
        }

        String data = update.getCallbackQuery().getData();
        String[] dataArr = data.split("_");

        String userSelectAnswer = dataArr[0];

        RealTimeAnswers answer = realTimeAnswersDB.getAnswer(user);

        answer.setWhichSelected(userSelectAnswer);

        answer.setCorrect(userSelectAnswer.equals(user.getQuestion().getAnswer()));

        realTimeAnswersDB.saveRealTimeAnswer(answer);


        bot.sendTestById(update, answer, userSelectAnswer);
    }

    public void sendResult(Update update) {
        try {
            long chatId = getChatId(update);

            if (chatId == 0L) {
                return;
            }


            User user = new User();
            if (userdb.existsByTelegramId(chatId)) {
                user = userdb.findAllByTelegramId(chatId);
            }

            DeleteMessage deleteMessage = new DeleteMessage();
            try {
                deleteMessage.setChatId(String.valueOf(chatId));
                deleteMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            } catch (Exception e) {
                exceptionSend.senException("StartSolvingTest deleteMessage => ", e, null);
                log.error("StartSolvingTest deleteMessage => ", e);
            }

            if (user.getRealTest() != null) {
                List<RealTimeAnswers> answers = realTimeAnswersDB.getAnswers(user);

                RealTest realTest1 = user.getRealTest();

                int rightCount = 0;
                Map<Question, Integer> wrongAnswers = new HashMap<>();
                for (RealTimeAnswers answer : answers) {
                    if (answer.isCorrect()) {
                        rightCount++;
                    } else {
                        wrongAnswers.put(answer.getQuestion(), answer.getIndexation());
                    }
                }
                int totalCount = realTest1.getTestCount();
                int percentage = (rightCount * 100) / totalCount;
                String timeStamp = getCurTime();
                String finalResult = new Dictionary().finalResult(user, totalCount, rightCount, percentage, timeStamp);

                SendMessage sendMessage = workingALot.makeMessage(chatId, finalResult);
                sendMessage.setParseMode(ParseMode.HTML);

                bot.execute(sendMessage);

                SendMessage sendAdmin = workingALot.makeMessage(-1001560114396L, finalResult);
                sendAdmin.setParseMode(ParseMode.HTML);
                bot.execute(sendAdmin);

                bot.sendAllTestWithResult(update, user, answers);
                bot.execute(deleteMessage);
            }
        } catch (Exception e) {
            exceptionSend.senException("StartSolvingTest sendResult => ", e, null);
            log.error("StartSolvingTest sendResult => ", e + String.valueOf(getChatId(update)));
        }
    }

    public String getCurTime() {
        String fromTimeZone = "GMT+5";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        format.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
        return format.format(date);
    }


    public void endTest(Update update) {
        try {
            long chatId = getChatId(update);

            if (chatId == 0L) {
                return;
            }


            User user = new User();
            if (userdb.existsByTelegramId(chatId)) {
                user = userdb.findAllByTelegramId(chatId);
            }

            if (user.getRealTest() != null) {
                List<RealTimeAnswers> answers = realTimeAnswersDB.getAnswers(user);

                if (user.getRealTest() != null) {
                    RealTest realTest1 = user.getRealTest();

                    if (realTest1 != null) {
                        Long whenClosed = realTest1.getCloseWhenTest();
                        Long timeNow = System.currentTimeMillis();

                        if (whenClosed - timeNow < 0) {
                            sendResult(update);
                        } else {

                            StringBuilder unSelected = new StringBuilder();
                            int cnt = 0;

                            for (RealTimeAnswers answer : answers) {
                                if (answer.getWhichSelected() == null) {
                                    unSelected.append(answer.getIndexation() + 1).append(" - , ");
                                    cnt++;
                                }
                            }

                            if (cnt != 0) {
                                String youDontFinished = "Siz hali hamma testni yakunlab bo'lmadingiz. Sizda ushbu raqamli testlar " + "qolgan:\n\n" + unSelected;
                                long leftTime = (whenClosed - timeNow) / 1000 / 60;
                                youDontFinished += "\n\nSizda " + leftTime + " minut vaqt qoldi!";
                                bot.execute(workingALot.makeMessage(chatId, youDontFinished));
                            } else {
                                sendResult(update);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

            exceptionSend.senException("StartSolvingTest endTest => ", e, null);
            log.error("StartSolvingTest endTest => ", e);
        }
    }

    private long getChatId(Update update) {
        long chatId = 0L;
        if (update.getCallbackQuery() != null) {
            if (update.getCallbackQuery().getFrom() != null) {
                chatId = update.getCallbackQuery().getFrom().getId();
            } else if (update.getCallbackQuery().getMessage() != null) {
                chatId = update.getCallbackQuery().getMessage().getChat().getId();
            }

        }

        return chatId;
    }

    private User getUser(long chatId) {
        User user = new User();
        if (userdb.existsByTelegramId(chatId)) {
            user = userdb.findAllByTelegramId(chatId);
        }

        return user;
    }
}