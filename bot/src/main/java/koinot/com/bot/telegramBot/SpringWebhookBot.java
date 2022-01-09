package koinot.com.bot.telegramBot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @className: SpringWebhookBot  $
 * @description: TODO
 * @date: 07 January 2022 $
 * @time: 12:00 AM $
 * @author: Qudratjon Komilov
 */
public abstract class SpringWebhookBot extends TelegramWebhookBot {

    @Value("${bot.token}") private String botToken;

    @Value("${bot.name}") private String botUsername;

    private SetWebhook setWebhook;

    public SpringWebhookBot(SetWebhook setWebhook) {
        super();
        this.setWebhook=setWebhook;
    }

    public SpringWebhookBot(DefaultBotOptions options,SetWebhook setWebhook) {
        super(options);
        this.setWebhook=setWebhook;
    }

    public SetWebhook getSetWebhook() {
        return setWebhook;
    }

    public class TestSpringWebhookBot extends SpringWebhookBot {

        public TestSpringWebhookBot(SetWebhook setWebhook) {
            super(setWebhook);
        }

        public TestSpringWebhookBot(DefaultBotOptions options,SetWebhook setWebhook) {
            super(options,setWebhook);
        }

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
        public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
                 AnswerBot(update);

            return null;
        }

        @Override
        public String getBotPath() {
            return "/";
        }
    }

    public void AnswerBot(Update update) throws TelegramApiException {

        SendChatAction sendChatAction=new SendChatAction();
        sendChatAction.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        sendChatAction.setAction(ActionType.TYPING);
        execute(sendChatAction);
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message=new SendMessage(update.getMessage().getChatId().toString(),update.getMessage().getText());
            try {
                 execute(message);// Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


}
