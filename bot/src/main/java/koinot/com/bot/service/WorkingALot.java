package koinot.com.bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WorkingALot {

    @Value("${upload.folder}")
    private String path;


    public SendMessage keyboard(Long chatId, List<String> stringList, String text) {
        SendMessage message = makeMessage(chatId, text);
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setOneTimeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row;
        for (int i = 0; i < stringList.size(); i++) {
            row = new KeyboardRow();
            row.add(stringList.get(i));
            if (i < stringList.size() - 1) {
                row.add(stringList.get(i + 1));
                i++;
            }
            keyboard.add(row);
        }
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    public SendMessage phoneNumber(Long chatId, String stringList, String text) {
        SendMessage message = makeMessage(chatId, text);
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setOneTimeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton(stringList);
        keyboardButton.setRequestContact(true);
        row.add(keyboardButton);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }


    public SendMessage inline(Long chatId, List<String> stringList, String text) {
        SendMessage sendMessage = makeMessage(chatId, text);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), stringList.get(i).replace(' ', '_')));
            if (i < stringList.size() - 1) {
                inlineKeyboardButton.add(makeMessage(stringList.get(i + 1), stringList.get(i + 1)));
            }
            listListRows.add(inlineKeyboardButton);
        }
        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage inlineClientList(Long chatId, List<String> stringList, String text, int prev, int next) {
        SendMessage sendMessage = makeMessage(chatId, text);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), BotAnswerString.koinot + stringList.get(i)));
            if (i < stringList.size() - 1) {
                inlineKeyboardButton.add(makeMessage(stringList.get(i + 1), BotAnswerString.koinot + stringList.get(i + 1)));
                i++;
            }
            listListRows.add(inlineKeyboardButton);
        }

        List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
        inlineKeyboardButton.add(makeMessage(BotAnswerString.PREV, BotAnswerString._koinot_prev_ + prev));
        inlineKeyboardButton.add(makeMessage(BotAnswerString.CANCEL, "cancel" + BotAnswerString.CANCEL));
        inlineKeyboardButton.add(makeMessage(BotAnswerString.NEXT, BotAnswerString._koinot_next_ + next));
        listListRows.add(inlineKeyboardButton);

        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public EditMessageText inlineClientListEdit(Long chatId, List<String> stringList, String text, int prev, int next, Integer msgId, int countNext) {
        EditMessageText sendMessage = new EditMessageText();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        sendMessage.setMessageId(msgId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), "koinot" + stringList.get(i)));
            if (i < stringList.size() - 1) {
                inlineKeyboardButton.add(makeMessage(stringList.get(i + 1), "koinot" + stringList.get(i + 1)));
                i++;
            }
            listListRows.add(inlineKeyboardButton);
        }

        List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
        inlineKeyboardButton.add(makeMessage(BotAnswerString.PREV + " " + prev, "_koinot_prev_" + prev));
        inlineKeyboardButton.add(makeMessage(BotAnswerString.CANCEL, "cancel" + BotAnswerString.CANCEL));
        inlineKeyboardButton.add(makeMessage((countNext < 0 ? "0" : countNext) + " " + BotAnswerString.NEXT, "_koinot_next_" + next));
        listListRows.add(inlineKeyboardButton);

        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage inlineOne(Long chatId, List<String> stringList, String text) {
        SendMessage sendMessage = makeMessage(chatId, text);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), stringList.get(i).replace(' ', '_')));
            listListRows.add(inlineKeyboardButton);
        }
        inlineKeyboardMarkup.setKeyboard(listListRows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public EditMessageText editInline(Long chatId, Integer msgId, List<String> stringList, String text) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(chatId));
        editMessageText.setText(text);
        editMessageText.setMessageId(msgId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), stringList.get(i).replace(' ', '_')));
            if (i < stringList.size() - 1) {
                inlineKeyboardButton.add(makeMessage(stringList.get(i + 1), stringList.get(i + 1)));
                i++;
            }
            listListRows.add(inlineKeyboardButton);
        }
        inlineKeyboardMarkup.setKeyboard(listListRows);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageText;
    }


    public EditMessageMedia editInlineMedia(Long chatId, Integer msgId, List<String> stringList, String text) {
        EditMessageMedia editMessageMedia = new EditMessageMedia();
        editMessageMedia.setChatId(String.valueOf(chatId));
//        editMessageMedia.setMedia(text);
        editMessageMedia.setMessageId(msgId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), stringList.get(i).replace(' ', '_')));
            if (i < stringList.size() - 1) {
                inlineKeyboardButton.add(makeMessage(stringList.get(i + 1), stringList.get(i + 1)));
                i++;
            }
            listListRows.add(inlineKeyboardButton);
        }
        inlineKeyboardMarkup.setKeyboard(listListRows);
        editMessageMedia.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageMedia;
    }

    public EditMessageText editInlineNotEditText(Long chatId, Integer msgId, List<String> stringList) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(chatId));
        editMessageText.setMessageId(msgId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listListRows = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<InlineKeyboardButton> inlineKeyboardButton = new ArrayList<>();
            inlineKeyboardButton.add(makeMessage(stringList.get(i), stringList.get(i).replace(' ', '_')));
            if (i < stringList.size() - 1) {
                inlineKeyboardButton.add(makeMessage(stringList.get(i + 1), stringList.get(i + 1)));
                i++;
            }
            listListRows.add(inlineKeyboardButton);
        }
        inlineKeyboardMarkup.setKeyboard(listListRows);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageText;
    }

    public SendMessage makeMessage(Long chat_id, String text) {
        SendMessage message = new SendMessage();
        try {
            message.setChatId(String.valueOf(chat_id));
            message.setText(text);
            message.setParseMode(ParseMode.HTML);
            return message;

        } catch (Exception e) {
            log.error("send ", e);
            return message;
        }
    }

    public SendMessage makeMessageReply(Long chat_id, String text, Integer replyId) {
        SendMessage message = new SendMessage();
        try {
            message.setChatId(String.valueOf(chat_id));
            message.setText(text);
            message.setReplyToMessageId(replyId);
            return message;

        } catch (Exception e) {
            log.error("send ", e);
            return message;
        }
    }

    public InlineKeyboardButton makeMessage(String text, String textInline) {
        InlineKeyboardButton message = new InlineKeyboardButton();
        try {
            message.setText(text);
            message.setSwitchInlineQuery("koinot");
            message.setCallbackData(textInline.replace(' ', '_'));
            return message;

        } catch (Exception e) {
            log.error("send ", e);
            return message;
        }
    }


}
