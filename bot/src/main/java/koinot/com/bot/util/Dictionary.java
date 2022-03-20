package koinot.com.bot.util;

import koinot.com.bot.entity.User;
import koinot.com.bot.entity.just.Answers;
import koinot.com.bot.entity.just.CheckTests;

public class Dictionary {
    public String successfulTestAdded(Long testCode, int testCount) {
        return "✅Test bazaga qo`shildi.\n" + "\n" + "Test kodi: " + testCode + "\nSavollar soni: " + testCount + " ta\n" + "\n" + "Testda qatnashuvchilar quyidagi ko`rinishda javob yuborishlari mumkin:\n" + "\n" + "<code>" + testCode + "*abcdac... \n" + "</code>" + "yoki\n" + "<code>" + testCode + "*1a2b3c4d5a..." + "</code>";
    }

    public String errorCheckTestNotEnough(Long testId, int testCount, int userTestCount) {
        return testId + " kodli testda savollar soni " + testCount + " ta.\n" + "❌Siz esa " + userTestCount + " ta javob yozdingiz!";
    }

    public String successfulSendForResult(User user, CheckTests checkTests, Answers answers) {
        return "\uD83D\uDC64 Foydalanuvchi: " + "<a href=\"tg://user?id=" + user.getTelegramId() + "\">" + user.getFirstName() + " " + user.getLastName() + "</a>" + "\n\n" + "\uD83D\uDCDA Fan: " + checkTests.getSubjectName() + "\n" + "\uD83D\uDCD6 Test kodi: " + checkTests.getId() + "\n" + "✏️ Jami savollar soni: " + checkTests.getTestCount() + " ta \n" + "✅ To'g'ri javoblar soni: " + answers.getCorrectAnswer() + " ta\n" + "\uD83D\uDD23 Foiz : " + answers.getCorrectRate() + " %\n\n" + "\uD83D\uDD50 Sana, vaqt: " + answers.getCreatedAt();
    }

    public String sendResultForAdmin(User user, CheckTests checkTests, Answers answers) {
        return "<a href=\"tg://user?id=" + user.getTelegramId() + "\">" + user.getFirstName() + " " + user.getLastName() + "</a>" + " " + checkTests.getSubjectName() + " fanidan " + "<b><i>" + checkTests.getId() + "</i></b>" + " kodli testning javoblarini yubordi. \n\nTo'g'ri javoblari soni : " + answers.getCorrectAnswer() + " ta.";
    }

    public String beforeStartTest(int testCount, int minutes) {
        return "\uD83C\uDFB2 “Attestattsiyaga tayyorgarlik\" onlayn testi.\n" +
                "\n" +
                "Online testga xush kelibsiz! Testda " + testCount + " ta savolga javob berishingiz kerak. Xar bir " +
                "savol uchun " + minutes + " minut vaqt, umumiy " + testCount * minutes + " minut vaqt beriladi.\n" +
                "\n" +
                "\uD83D\uDD8A " + testCount + " ta savol\n" +
                "⏱ Har bir savol uchun " + minutes + " minut (umuman olganda ahamiyatsiz)\n" +
                "\n" +
                "\uD83C\uDFC1 Tayyor boʻlganingizda quyidagi tugmani bosing:";
    }

    public String finalResult(User user, int count, int right, int percentage, String time) {
        return "\uD83D\uDC64 Foydalanuvchi: " + "<a href=\"tg://user?id=" + user.getTelegramId() + "\">" + user.getFirstName() + " " + user.getLastName() + "</a>" + "\n\n" + "\uD83D\uDCDA Fan: " + "Informatika" + "\n" + "✏️ Jami savollar soni: " + count + " ta \n" + "✅ To'g'ri javoblar soni: " + right + " ta\n" + "\uD83D\uDD23 Foiz : " + percentage + " %\n\n" + "\uD83D\uDD50 Sana, vaqt: " + time;
    }

    public String getMe(User user) {
        return "\uD83D\uDC64 Foydalanuvchi: " + "<a href=\"tg://user?id=" + user.getTelegramId() + "\">" + user.getFirstName() + " " + user.getLastName() + "</a>" + "\n\n" +
                "\uD83D\uDCDE Telefon raqam: " + user.getPhoneNumber();
    }
}
