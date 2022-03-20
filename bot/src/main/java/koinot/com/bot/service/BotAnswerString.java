package koinot.com.bot.service;

public interface BotAnswerString {

    String time = "time";
    String cancel_client = "cancel_client";
    String koinot = "koinot";
    String KOINOT = "KOINOT";
    String _koinot_prev_ = "_koinot_prev_"; // _koinot_
    String _koinot_next_ = "_koinot_next_"; // _koinot_
    String order = "order";
    String get_order = "get_order";
    String get_time = "get_time";
    String get_month = "get_month";
    String get_stadium = "get_stadium";
    String stadium_name = "✅";
    String verify = "verify";
    String cancelBoss = "cancelBoss";
    String cancelOrder = "cancelOrder"; // _koinot_
    String cancelOrderBTN = "\uD83D\uDDD1"; // _koinot_

    //*************************************//
    String upload_photo = "✅\uD83D\uDC4D";
    String like = "\uD83D\uDC4D";
    String disLice = "\uD83D\uDC4E";
    String LIKE = "\uD83D\uDC4D ";
    String CLOCK = "\uD83D\uDD70 ";
    String NEXT = "➡️";
    String PREV = "⬅️";
    String SUCCESSFUL = "✅";
    String CANCEL = "❌";
    String NOT_FOUND = "❕    \uD83E\uDD37\u200D♂️";
    String MANY = " so'm \uD83D\uDCB8 ";
    String CREATE = "➕";
    String CHANGED = "\uD83D\uDCDD";
    String BACK = "\uD83D\uDD19";
    String GET_PHONE_STICKER = "CAACAgIAAxkBAAIigGBaTp_fA3UfiP7fKogU7SJaAAEO6wAC-QYAAkb7rAQF5n-88vDa9R4E";
    String GET_LOCATION_STICKER = "CAACAgIAAxkBAAIih2BaUO1O53-QWnoDRSXXs630QW3OAAKvAAPEq2gLwrqtVV2a-joeBA";
    String GET_ADDRESS_STICKER = "CAACAgIAAxkBAAIirWBaU3WmgsL3JLuIISmlEaP9ucokAAJcAANH-wkMQa_VBAzsDyceBA";
    String GET_NAME_STICKER = "CAACAgIAAxkBAAIjTWBaWKEbARS2uujp1NELU-YI6ffRAAJQAANH-wkMX9n9KsNqTyUeBA";
    String GET_OPEN_STICKER = "CAACAgIAAxkBAAIjXWBaWhrpZdtPrbz43sCSt-qrwR-5AAJbAANZu_wlZFKnU_pjnh4eBA";
    String GET_CLOSE_STICKER = "CAACAgIAAxkBAAIjXmBaWuOGtayvEyYYN4TpYUoSUfy1AAIkCQACGELuCHBUENT4WrkWHgQ";
    String GET_PHOTO_STICKER = "CAACAgIAAxkBAAIjrWBaZP5K4qkQx28AAbqPHsp-Nk7CGAACGAADTlzSKT5q3R61ronZHgQ";
    String GET_DAYLIGHT_PRICE_STICKER = "CAACAgIAAxkBAAIjYGBaXb8_OqhkpIpBAnivGbcYjYI2AAL8BgACRvusBG1XSZhZ24v-HgQ";
    String GET_NIGHT_PRICE_STICKER = "CAACAgIAAxkBAAIjYWBaXtJWQmMKytyZhQUYP-3VuWykAAJWAANH-wkMEwAB4K3LZ543HgQ";
    String GET_TIME_FOR_CHANGE_PRICE_STICKER = "CAACAgIAAxkBAAIjY2BaYAaut0ex7501Cuuir11FV5_MAAJOAANZu_wlDevP2fnQeCoeBA";
    String GET_SIZE_FOR_STADIUM_PHOTO = "AgACAgIAAxkBAAIdA2DtsXjqdSgztPJyLu8K8dquxaOPAAKZtDEb7m1ZS_v9agn7rQbIAQADAgADcwADIAQ";
    String VIDEO_FOR_EXPLAINING_BOT = "BAACAgIAAxkBAAInKWEXzFMnJ8QgNCr229q-pfedoOeWAAKqEAACscTASFdg82STM89rIAQ";
    //    String GET_SIZE_FOR_STADIUM_PHOTO = "https://img3.goodfon.ru/wallpaper/nbig/a/e4/moraine-lake-banff-national-6336.jpg";
    String GET_SUCCESSFUL_STICKER = "CAACAgIAAxkBAAIjZGBaYJfLSIgSvmr5WW6Mbf9-mHxpAAL-AANWnb0K2gRhMC751_8eBA";
    String GET_NEW_LINE_STICKER = System.lineSeparator() + "➖➖➖➖➖➖➖➖➖➖➖➖" + System.lineSeparator() + System.lineSeparator();
    String GET_CLIENT_TIME = System.lineSeparator() + "\uD83D\uDCDD" + System.lineSeparator() + System.lineSeparator();


    //*************************************//
    String CHANGE_LANGUAGE_RU = "язык";
    String CHANGE_LANGUAGE_EN = "language";
    String CHANGE_LANGUAGE_UZL = "til";
    String CHANGE_LANGUAGE_UZ = "тил";

    //**************************************//
    String uzl = "Uz\uD83C\uDDFA\uD83C\uDDFF";
    String uz = "Ўз\uD83C\uDDFA\uD83C\uDDFF";
    String ru = "Ру\uD83C\uDDF7\uD83C\uDDFA";
    String en = "En\uD83C\uDDEC\uD83C\uDDE7";


    //******************* REGISTER USER ***********************//
    String ASK_FIRST_LAST_NAME = "Hurmatli foydalanuvchi ism familiyangizni quyidagicha kiriting:\n\n" + "<code>fio*ism familiya</code>\n\n" + "<b>Misol:</b>\n" + "<code>fio*Alijonov Valijon</code>";
    String ASK_FIRST_NAME = "Botimizga xush kelibsiz. Botdan foydalanish uchun quyidagilarni " + "to'ldirishingiz lozim.\n\n<b>Ismizni</b> " + "kiriting:";
    String ASK_LAST_NAME = "<b>Familiyangizni</b> kiriting:";
    String ASK_PHONE_NUMBER = "<b>Telefon raqamingizni</b> yuboring:";
    String PHONE_NUMBER_BUTTON = "\uD83D\uDCDE Telefon raqamni yuborish";

    String MENU_ADD_TEST = "➕ Test yaratish";
    String MENU_CHECK_TEST = "✅ Javobni tekshirish";
    String MENU_SOLVE_TEST = "✍️ Test yechish";
    String MENU_SETTINGS = "⚙️ Sozlamalar";
    String MENU_TEXT = "Botdan foydalanishingiz mumkin:";

    String CREATE_TEST = "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 Yo'riqnoma.\n" + "\n" + "1️⃣ Test yaratish uchun\n" + "\n" + "+test*Fan nomi*to'g'ri javoblar \n" + "\n" + "ko`rinishida yuboring.\n" + "\n" + "Misol: \n" + "+test*Informatika*abbccdd...  \n" + "yoki\n" + "+test*Informatika*1a2d3c4a5b...";

    String CHECK_TEST = "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 Yo'riqnoma.\n" + "\n" + "1️⃣ Test javoblarini yuborish uchun \n" + "\n" + "test kodi*abbccdd... \n" + "yoki\n" + "test kodi*1a2d3c4a5b...\n" + "\n" + "kabi ko`rinishlarda yuboring.\n" + "\n" + "Misol: \n" + "1234*abbccdd... \n" + "yoki\n" + "1234*1a2d3c4a5b...";

    String ERROR_CHECK_TEST = "☝️☝️☝️Diqqat!\n" + "\n" + "Hurmatli foydalanuvchi javob yuborish formati o'zgargan.\n" + "Sizning yuborgan javobingiz yangi formatga mos kelmaydi.\n" + "\n" + "Yo'riqnoma bilan yana bir marta tanishib chiqib javobingizni qaytib yuborishingizni so'raymiz.\n" + "\n" + "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 Yo'riqnoma.\n" + "\n" + "1️⃣ Test javoblarini yuborish uchun \n" + "\n" + "test kodi*abbccdd... \n" + "yoki\n" + "test kodi*1a2d3c4a5b...\n" + "\n" + "kabi ko`rinishlarda yuboring.\n" + "\n" + "Misol: \n" + "1234*abbccdd... \n" + "yoki\n" + "1234*1a2d3c4a5b...";

    String ERROR_TEST_ID_NOT_FOUND = "Xatolik!\n" + "Test bazadan topilmadi.\n" + "Test kodini noto`g`ri yuborgan bo`lishingiz mumkin, iltimos tekshirib qaytadan yuboring.";

    String ERROR_TEST_DISABLED = "☹️☹️☹️\n" + "Afsuski siz javob yuborishga kechikdingiz!!!\n" + "Test yakunlangan.\n" + "\n" + "Keyingi testda chaqqonroq bo`ling hurmatli foydalanuvchi...";

    String ADD_CATEGORY = "/add_category";
    String GET_CATEGORY = "/categories";
    String TEST = "/test";
    String USER = "/user";

    String EMPTY_CATEGORY = "Kategoriyalar mavjud emas";
    String EXIST_THIS_CATEGORY = "❌ Bu kategoriya sizda mavjud";
    String NO_EXIST_THIS_CATEGORY = "❌ Bu kategoriya sizda mavjud emas";
    String NO_EXIST_THIS_GRADE = "Bunday sinf mavjud emas";
    String PLEASE_SEND_RIGHT_CATEGORY = "❌ Iltimos to'g'ri kiriting:\n\nMisol uchun:\n\n/add_category name             " + "     —       name faqat " + "bitta" + " " + "so'z " + "bo'lsin!";

    String SUCCESS_CATEGORY_ADDED = "✅ Kategoriya qo'shildi";
    String SUCCESS_QUESTION_ADDED = "✅ Test qo'shildi";

    String NOT_ENOUGH_CAPTION = "Testni kaliti katta harfda bo'lsin!";

    String START_TEST_SOLVE = "Test yechishni boshlash";
    String START_TEST_SOLVE_CALLBACK_DATA = "Test_yechishni_boshlash";
    String YOU_ARE_SOLVING_TEST = "Siz hali testni tugatmagansiz";
    String INVITE_CHANNEL = "Botdan to'liq foydalanishingiz uchun quyidagi kanallarga a'zo bo'lishingiz kerak:";
}
