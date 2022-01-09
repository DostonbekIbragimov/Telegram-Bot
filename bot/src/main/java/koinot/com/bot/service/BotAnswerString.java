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
    String STADIUM_CHANGE_MESSAGE_RU = "нажмите кнопку ниже, чтобы получать уведомления об изменениях на стадионе";
    String STADIUM_CHANGE_MESSAGE_EN = "press the button below to be notified of changes in the stadium";
    String STADIUM_CHANGE_MESSAGE_UZL = "stadiondagi o'zgarishlardan xabardor bo'lish uchun pasdagi tugmani bosing";
    String STADIUM_CHANGE_MESSAGE_UZ = "стадиондаги ўзгаришлардан хабардор бўлиш учун пасдаги тугмани босинг";

    //*************************************//
    String STADIUM_DASHBOARD_RU = "мой стадион";
    String STADIUM_DASHBOARD_EN = "my stadium";
    String STADIUM_DASHBOARD_UZL = "mening stadionim";
    String STADIUM_DASHBOARD_UZ = "менинг стадионим";

    //*************************************//
    String STADIUM_LIKE_RU = "Вам понравился стадион";
    String STADIUM_LIKE_EN = "Did you like the stadium";
    String STADIUM_LIKE_UZL = "Stadion sizga yoqdimi";
    String STADIUM_LIKE_UZ = "Стадион сизга ёқдими";

    //*************************************//
    String CLIENT_CANCEL_ORDER_RU = "вы отменили заказ";
    String CLIENT_CANCEL_ORDER_EN = "you canceled the order";
    String CLIENT_CANCEL_ORDER_UZL = "siz buyurtmani bekor qildingiz";
    String CLIENT_CANCEL_ORDER_UZ = "сиз буюртмани бекор қилдингиз";


    //**************************************/
    String ALERT_CLIENT_LOCATION_UZL = "\uD83D\uDCCDMenga joylashuvingizni yuboring va men sizga yaqin bo’lgan stadionlar ro’yxatini taqdim etaman.⚽️\n" +
            "\n" +
            "Pastdagi tugmalardan qayerda ekanligingizni tanlang✅\uD83D\uDC47\uD83C\uDFFB";
    String ALERT_CLIENT_LOCATION_UZ = "\uD83D\uDCCDМенга жойлашувингизни юборинг ва мен сизга яқин бўлган стадионлар рўйхатини тақдим этаман.⚽️\n" +
            "\n" +
            "Пастдаги тугмалардан қаерда эканлигингизни танланг✅\uD83D\uDC47\uD83C\uDFFB";
    String ALERT_CLIENT_LOCATION_RU = "«Отправьте мне свое местоположение, и я предоставлю вам список ближайших стадионов».\n" +
            "\n" +
            "Выберите, где вы находитесь, с помощью кнопок ниже ✅\uD83D\uDC47\uD83C\uDFFB";
    String ALERT_CLIENT_LOCATION_EN = "\uD83D\uDCCDSend me your location and I will provide you with a list of nearby stadiums.⚽️\n" +
            "\n" +
            "Choose where you are from the buttons below ✅\uD83D\uDC47\uD83C\uDFFB";


    //*************************************//
    String ORDER_CANCEL_FOR_USER_RU = "Eсли вы хотите отменить свой заказ..." + System.lineSeparator() + " Hажмите кнопку ниже \uD83D\uDC47";
    String ORDER_CANCEL_FOR_USER_EN = "If you want to cancel your order..." + System.lineSeparator() + " Click the button below \uD83D\uDC47";
    String ORDER_CANCEL_FOR_USER_UZL = "Agar buyurtmangizni bekor qilmoqchi bo'lsangiz..." + System.lineSeparator() + " Quydagi tugmani bosing \uD83D\uDC47";
    String ORDER_CANCEL_FOR_USER_UZ = "Aгар буюртмангизни бекор қилмоқчи бўлсангиз..." + System.lineSeparator() + "қуйдаги тугмани босинг \uD83D\uDC47";


    //*************************************//
    String ORDER_CANCEL_CLIENT_RU = " заказ был отменен ❌";
    String ORDER_CANCEL_CLIENT_EN = " order has been canceled ❌";
    String ORDER_CANCEL_CLIENT_UZL = " buyurtman bekor qilindi ❌";
    String ORDER_CANCEL_CLIENT_UZ = " буюртман бекор қилинди ❌";


    //*************************************//
    String ORDER_NUMBER_RU = " номер заказа";
    String ORDER_NUMBER_EN = " order number";
    String ORDER_NUMBER_UZL = " Buyurtma raqami";
    String ORDER_NUMBER_UZ = " Буюртма рақами";


    //*************************************//
    String ALL_PHOTO_DELETE_RU = "барча расмлар ўчирилди";
    String ALL_PHOTO_DELETE_EN = "all pictures have been deleted";
    String ALL_PHOTO_DELETE_UZL = "barcha rasmlar o'chirildi";
    String ALL_PHOTO_DELETE_UZ = "все фотографии были удалены";


    //*************************************//
    String PLAY_FINISHED_RU = "игра окончена";
    String PLAY_FINISHED_EN = "game over";
    String PLAY_FINISHED_UZL = "o'yin tugadi";
    String PLAY_FINISHED_UZ = "ўйин тугади";

    //*************************************//
    String ORDER_CANCEL_BOSS_RU = "заказ был отменен";
    String ORDER_CANCEL_BOSS_EN = "the order was canceled";
    String ORDER_CANCEL_BOSS_UZL = "buyurtma bekor qilindi";
    String ORDER_CANCEL_BOSS_UZ = "буюртма бекор қилинди";


    //**************************************/
    String REGION_NAME_UZL = " markaziga nisbattan ";
    String REGION_NAME_UZ = "  марказига нисбаттан ";
    String REGION_NAME_RU = "Относительно центра ";
    String REGION_NAME_EN = "Relative to the center of ";

    //*************************************//
    String SELECT_DAY_RU = "\uD83D\uDC47 выберите день \uD83D\uDC47";
    String SELECT_DAY_EN = "\uD83D\uDC47 select the day \uD83D\uDC47";
    String SELECT_DAY_UZL = "\uD83D\uDC47 kunni tanlang \uD83D\uDC47";
    String SELECT_DAY_UZ = "\uD83D\uDC47 кунни танланг \uD83D\uDC47";

    //*************************************//
    String CHANGE_LANGUAGE_RU = "язык";
    String CHANGE_LANGUAGE_EN = "language";
    String CHANGE_LANGUAGE_UZL = "til";
    String CHANGE_LANGUAGE_UZ = "тил";

    //*************************************//
    String RESTART_RU = "запустить снова";
    String RESTART_EN = "restart";
    String RESTART_UZL = "boshidan boshlash";
    String RESTART_UZ = "қайта ишга тушириш";

    //*************************************//
    String ORDER_COUNT_RU = "заказ";
    String ORDER_COUNT_EN = "order";
    String ORDER_COUNT_UZL = "buyurtma";
    String ORDER_COUNT_UZ = "буюртма";

    //*************************************//
    String ORDER_RU = "заказ \uD83E\uDD1D";
    String ORDER_EN = "order \uD83E\uDD1D";
    String ORDER_UZL = "buyurtma \uD83E\uDD1D";
    String ORDER_UZ = "буюртма \uD83E\uDD1D";

    //*************************************//
    String CHANGED_RU = "измененный";
    String CHANGED_EN = "changed";
    String CHANGED_UZL = "o'zgardi";
    String CHANGED_UZ = "ўзгарди";

    //*************************************//
    String DISTANCE_RU = "расстояние";
    String DISTANCE_EN = "distance";
    String DISTANCE_UZL = "masofa";
    String DISTANCE_UZ = "масофа";

    //*************************************//
    String WHAT_DO_YOU_WANT_TO_CHANGE_THE_STADIUM_RU = "что ты хочешь изменить на стадионе";
    String WHAT_DO_YOU_WANT_TO_CHANGE_THE_STADIUM_EN = "what do you want to change the stadium";
    String WHAT_DO_YOU_WANT_TO_CHANGE_THE_STADIUM_UZL = "stadionni nimasini o'zgartirmoqchisiz";
    String WHAT_DO_YOU_WANT_TO_CHANGE_THE_STADIUM_UZ = "стадионни нимасини ўзгартирмоқчисиз";

    //*************************************//
    String TIME_OF_EVENING_PRICE_CHANGE_RU = "ночное_время";
    String TIME_OF_EVENING_PRICE_CHANGE_EN = "night_time";
    String TIME_OF_EVENING_PRICE_CHANGE_UZL = "tungi_vaqt";
    String TIME_OF_EVENING_PRICE_CHANGE_UZ = "тунги_вақт";

    //*************************************//
    String STADIUM_PHOTO_CHANGE_RU = "поменять_картинки";
    String STADIUM_PHOTO_CHANGE_EN = "change_pictures";
    String STADIUM_PHOTO_CHANGE_UZL = "rasmlarni_o'zgartirish";
    String STADIUM_PHOTO_CHANGE_UZ = "расмларни_ўзгартириш";

    //*************************************//
    String LOCATION_RU = "расположение";
    String LOCATION_EN = "location";
    String LOCATION_UZL = "joylashuvi";
    String LOCATION_UZ = "жойлашуви";

    //*************************************//
    String ADDRESS_RU = "\uD83D\uDCCDАдрес";
    String ADDRESS_EN = "\uD83D\uDCCDAddress";
    String ADDRESS_UZL = "\uD83D\uDCCDManzil";
    String ADDRESS_UZ = "\uD83D\uDCCDМанзил";

    //*************************************//
    String RATING_RU = "\uD83D\uDCCAРейтинг";
    String RATING_EN = "\uD83D\uDCCARating";
    String RATING_UZL = "\uD83D\uDCCAReyting";
    String RATING_UZ = "\uD83D\uDCCAРейтинг";

    //*************************************//
    String DELETE_SUCCESSFUL_RU = "успешное удаление";
    String DELETE_SUCCESSFUL_EN = "successful delete ";
    String DELETE_SUCCESSFUL_UZL = "muvaffaqiyatli o'chirish";
    String DELETE_SUCCESSFUL_UZ = "муваффақиятли ўчириш";

    //*************************************//
    String DELETE_FAILED_RU = "успешное удаление";
    String DELETE_FAILED_EN = "failed delete";
    String DELETE_FAILED_UZL = "o'chirib bo'lmadi";
    String DELETE_FAILED_UZ = "ўчириб бўлмади";

    //*************************************//
    String ALWAYS_OPEN_RU = "всегда время открыто";
    String ALWAYS_OPEN_EN = "always time open";
    String ALWAYS_OPEN_UZL = "har doim vaqt ochiq";
    String ALWAYS_OPEN_UZ = "ҳар доим вақт очиқ";

    //*************************************//
    String DELETE_RU = "Удалить";
    String DELETE_EN = "delete";
    String DELETE_UZL = "o'chirish";
    String DELETE_UZ = "ўчириш";

    //*************************************//
    String EDIT_RU = "редактировать";
    String EDIT_EN = "edit";
    String EDIT_UZL = "tahrirlash";
    String EDIT_UZ = "таҳрирлаш";

    //*************************************//
    String VERiFY_RU = "проверять";
    String VERiFY_EN = "verify";
    String VERiFY_UZL = "tasdiqlang";
    String VERiFY_UZ = "тасдиқланг";

    //*************************************//
    String PRICE_AFTER_RU = "Цена после ";
    String PRICE_AFTER_EN = "Price after ";
    String PRICE_AFTER_UZL = "dan keyin narxi";
    String PRICE_AFTER_UZ = "дан кейин нархи: ";

    //*************************************//
    String PRICE_BEFORE_RU = "Цена до ";
    String PRICE_BEFORE_EN = "Price until ";
    String PRICE_BEFORE_UZL = "gacha narxi";
    String PRICE_BEFORE_UZ = "гача нархи ";

    //*************************************//
    String NAME_RU = "⚽️ Название стадиона";
    String NAME_EN = "⚽️Stadium name";
    String NAME_UZL = "⚽️Stadion nomi";
    String NAME_UZ = "⚽️Стадион номи";

    //*************************************//
    String WORKING_HOURS_RU = "\uD83D\uDCC6Рабочие часы";
    String WORKING_HOURS_EN = "\uD83D\uDCC6Working hours";
    String WORKING_HOURS_UZL = "\uD83D\uDCC6Ish-vaqti";
    String WORKING_HOURS_UZ = "\uD83D\uDCC6Иш-вақти";

    //*************************************//
    String PHONE_NUMBER_RU = "\uD83D\uDCF1Для справки";
    String PHONE_NUMBER_EN = "\uD83D\uDCF1For reference";
    String PHONE_NUMBER_UZL = "\uD83D\uDCF1Murojat uchun";
    String PHONE_NUMBER_UZ = "\uD83D\uDCF1Мурожат учун";

    //*************************************//
    String ORDER_LIST_RU = "✅Список заказов:";
    String ORDER_LIST_EN = "✅List of orders:";
    String ORDER_LIST_UZL = "✅Buyurtmalar ro’yxati:";
    String ORDER_LIST_UZ = "✅Буюртмалар рўйхати:";

    //*************************************//
    String PRICE_RU = "\uD83D\uDCB5Цена";
    String PRICE_EN = "\uD83D\uDCB5Price";
    String PRICE_UZL = "\uD83D\uDCB5Narxi";
    String PRICE_UZ = "\uD83D\uDCB5Нархи";

    //*************************************//
    String SIZE_RU = "\uD83D\uDCCFРазмер";
    String SIZE_EN = "\uD83D\uDCCFSize";
    String SIZE_UZL = "\uD83D\uDCCFO’lchami";
    String SIZE_UZ = "\uD83D\uDCCFЎлчами";

    //*************************************//
    String SEND_ME_PHOTO_FOR_STADIUM_RU = "(10) отправить фотографию стадиона";
    String SEND_ME_PHOTO_FOR_STADIUM_EN = "(10) send a picture of stadium";
    String SEND_ME_PHOTO_FOR_STADIUM_UZL = "(10) stadion rasmini yuboring";
    String SEND_ME_PHOTO_FOR_STADIUM_UZ = "(10) стадион расмини юборинг";

    //*************************************//
    String DAYLIGHT_PRICE_RU = "сколько стоит стадион в светлое время суток ?";
    String DAYLIGHT_PRICE_EN = "what is the price of the stadium during daylight hours ?";
    String DAYLIGHT_PRICE_UZL = "kunduzgi soat davomida stadion narxi qancha ?";
    String DAYLIGHT_PRICE_UZ = "кундузги соат давомида стадион нархи қанча ?";

    //*************************************//
    String GET_NIGHT_TIME_FOR_CHANGE_PRICE_RU = "во сколько начинается эта цена";
    String GET_NIGHT_TIME_FOR_CHANGE_PRICE_EN = "what time does this price start";
    String GET_NIGHT_TIME_FOR_CHANGE_PRICE_UZL = "bu narx soat nechadan boshlanadi";
    String GET_NIGHT_TIME_FOR_CHANGE_PRICE_UZ = "бу нарх соат нечадан бошланади";

    //*************************************//
    String NIGHT_PRICE_RU = "какова цена стадиона в ночное время ?";
    String NIGHT_PRICE_EN = "what is the price of the stadium during night hours ?";
    String NIGHT_PRICE_UZL = "tungi soatlarda stadion narxi qancha ?";
    String NIGHT_PRICE_UZ = "тунги соатларда стадион нархи қанча ?";

    //*************************************//
    String GET_STADIUM_SIZE_RU = "Введите размеры стадиона " + System.lineSeparator() + "пример: (120x90)";
    String GET_STADIUM_SIZE_EN = "Enter the dimensions of the stadium " + System.lineSeparator() + "example: (120x90)";
    String GET_STADIUM_SIZE_UZL = "Stadion o'lchamlarini kiriting " + System.lineSeparator() + "misol: (120x90)";
    String GET_STADIUM_SIZE_UZ = "Стадион ўлчамларини киритинг " + System.lineSeparator() + "мисол: (120x90)";

    //*************************************//
    String FORMAT_PRICE_RU = "просто отправь номер";
    String FORMAT_PRICE_EN = "just send the number";
    String FORMAT_PRICE_UZL = "shunchaki raqamni yuboring";
    String FORMAT_PRICE_UZ = "шунчаки рақамни юборинг";

    //*************************************//
    String IS_THERE_ANOTHER_PICTURE_RU = "изображение принято✅" + System.lineSeparator() + "Отправьте, если у вас есть еще фотографии";
    String IS_THERE_ANOTHER_PICTURE_EN = "picture accepted✅" + System.lineSeparator() + "Send if you have more pictures";
    String IS_THERE_ANOTHER_PICTURE_UZL = "rasm qabul qilindi✅ " + System.lineSeparator() + "yana rasmi bo'lsa yuboring";
    String IS_THERE_ANOTHER_PICTURE_UZ = "расм қабул қилинди✅" + System.lineSeparator() + "яна расми бўлса юборинг";

    //*************************************//
    String NO_ANOTHER_PICTURE_RU = "нет другой картинки";
    String NO_ANOTHER_PICTURE_EN = "no other picture";
    String NO_ANOTHER_PICTURE_UZL = "boshqa rasm yo'q";
    String NO_ANOTHER_PICTURE_UZ = "бошқа расм йўқ";

    //*************************************//
    String SEND_THIS_PHONE_NUMBER_RU = "отправь этот номер телефона";
    String SEND_THIS_PHONE_NUMBER_EN = "send this phone number";
    String SEND_THIS_PHONE_NUMBER_UZL = "ushbu telefon raqamini yuboring";
    String SEND_THIS_PHONE_NUMBER_UZ = "ушбу телефон рақамини юборинг";

    //*************************************//
    String DATE_FORMAT_RU = "отправьте время следующим образом Пример: 09:30";
    String DATE_FORMAT_EN = "send the time as follows  Example: 09:30";
    String DATE_FORMAT_UZL = "vaqtni quyidagicha yuboring Misol: 09:30";
    String DATE_FORMAT_UZ = "вақтни қуйидагича юборинг Мисол: 09:30";

    //*************************************//
    String DATE_SIZE_RU = "отправьте размер следующим образом Пример: 120x90";
    String DATE_SIZE_EN = "send the size as follows  Example: 120x90";
    String DATE_SIZE_UZL = "o'lchamni quyidagicha yuboring Misol: 120x90";
    String DATE_SIZE_UZ = "ўлчамни қуйидагича юборинг Мисол: 120x90";

    //*************************************//
    String WHEN_THE_STADIUM_STARTS_TO_WORK_RU = "стадион будет открываться в какое время каждый день";
    String WHEN_THE_STADIUM_STARTS_TO_WORK_EN = "the stadium will open at what time every day";
    String WHEN_THE_STADIUM_STARTS_TO_WORK_UZL = "stadion har kuni qaysi vaqtda ochiladi";
    String WHEN_THE_STADIUM_STARTS_TO_WORK_UZ = "стадион ҳар куни қайси вақтда очилади";

    //*************************************//
    String WHEN_THE_STADIUM_CLOSE_TO_WORK_RU = "в какое время этот стадион закрывается каждый день";
    String WHEN_THE_STADIUM_CLOSE_TO_WORK_EN = "what time does this stadium close each day";
    String WHEN_THE_STADIUM_CLOSE_TO_WORK_UZL = "bu stadion har kuni soat nechida yopiladi";
    String WHEN_THE_STADIUM_CLOSE_TO_WORK_UZ = "бу стадион ҳар куни соат нечида ёпилади";

    //*************************************//
    String THIS_STADIUM_ALWAYS_OPEN_RU = "этот стадион всегда открыт";
    String THIS_STADIUM_ALWAYS_OPEN_EN = "this stadium always open";
    String THIS_STADIUM_ALWAYS_OPEN_UZL = "ushbu stadion har doim ochiq";
    String THIS_STADIUM_ALWAYS_OPEN_UZ = "ушбу стадион ҳар доим очиқ";

    //*************************************//
    String WHAT_TIME_TO_GO_RU = "в какое время ты хочешь пойти?"+ System.lineSeparator()+"Пример: 09:30";
    String WHAT_TIME_TO_GO_EN = "what time do you want to go?"+ System.lineSeparator()+"Example: 09:30";
    String WHAT_TIME_TO_GO_UZL = "soat nechida borishni xohlaysiz?"+ System.lineSeparator()+"Misol: 09:30";
    String WHAT_TIME_TO_GO_UZ = "соат нечида боришни хоҳлайсиз?"+ System.lineSeparator()+"Мисол: 09:30";

    //*************************************//
    String DAY_RU = "\uD83D\uDCC6День";
    String DAY_EN = "\uD83D\uDCC6Day";
    String DAY_UZL = "\uD83D\uDCC6Kuni";
    String DAY_UZ = "\uD83D\uDCC6Куни";

    //*************************************//
    String WHAT_TIME_PLAY_RU = "⏰Во сколько ты хочешь поиграть?"+ System.lineSeparator()+"Пример: 09:30";
    String WHAT_TIME_PLAY_EN = "⏰What time do you want to play?"+System.lineSeparator()+"Example: 09:30";
    String WHAT_TIME_PLAY_UZL = "⏰Soat nechigacha o’ynashni xoxlaysiz? "+ System.lineSeparator()+"Misol: 09:30";
    String WHAT_TIME_PLAY_UZ = "⏰Соат нечигача ўйнашни хохлайсиз?"+ System.lineSeparator()+"Мисол: 09:30";



    //*************************************//
    String BUSY_TIME_RU = "занят в это время";
    String BUSY_TIME_EN = "busy at this time";
    String BUSY_TIME_UZL = "bu vaqtda band";
    String BUSY_TIME_UZ = "бу вақтда банд";

    //*************************************//
    String ORDER_ACTIVE_RU = "заказ был подтвержден ✅";
    String ORDER_ACTIVE_EN = "the order was confirmed ✅";
    String ORDER_ACTIVE_UZL = "buyurtma tasdiqlandi ✅";
    String ORDER_ACTIVE_UZ = "буюртма тасдиқланди ✅";

    //*************************************//
    String ORDER_CANCEL_RU = "ваш заказ был отменен ❌";
    String ORDER_CANCEL_EN = "your order has been canceled ❌";
    String ORDER_CANCEL_UZL = "sizning buyurtmangiz bekor qilindi ❌";
    String ORDER_CANCEL_UZ = "сизнинг буюртмангиз бекор қилинди ❌";

    //*************************************//
    String ORDER_INSPECTION_RU = "заказ отправлен на проверку";
    String ORDER_INSPECTION_EN = "the order was sent for inspectiony";
    String ORDER_INSPECTION_UZL = "buyurtma tekshiruvga yuborildi";
    String ORDER_INSPECTION_UZ = "буюртма текширувга юборилди";

    //*************************************//
    String ORDER_CONNECT_RU = "⏰Свяжемся с вами в ближайшее время!";
    String ORDER_CONNECT_EN = "⏰Contact you soon!";
    String ORDER_CONNECT_UZL = "⏰Tez orada siz bilan bog’lanishadi!";
    String ORDER_CONNECT_UZ = "⏰Тез орада сиз билан боғланишади!";

    //*************************************//
    String WHAT_IS_NAME_THIS_STADIUM_RU = "как называется этот стадион?";
    String WHAT_IS_NAME_THIS_STADIUM_EN = "what is name this  stadium?";
    String WHAT_IS_NAME_THIS_STADIUM_UZL = "bu stadion nima deb nomlangan?";
    String WHAT_IS_NAME_THIS_STADIUM_UZ = "бу стадион нима деб номланган?";

    //*************************************//
    String ENTER_THE_ADDRESS_OF_THIS_STADIUM_MANUALLY_RU = "введите адрес этого стадиона вручную";
    String ENTER_THE_ADDRESS_OF_THIS_STADIUM_MANUALLY_EN = "enter the address of this stadium manually";
    String ENTER_THE_ADDRESS_OF_THIS_STADIUM_MANUALLY_UZL = "stadion manzilini yozma kiriting";
    String ENTER_THE_ADDRESS_OF_THIS_STADIUM_MANUALLY_UZ = "стадион манзилини ёзма киритинг";

    //*************************************//
    String ERROR_STADIUM_RU = "ошибка попробуйте еще раз";
    String ERROR_STADIUM_EN = "error try again";
    String ERROR_STADIUM_UZL = "xato qayta urinib ko'ring";
    String ERROR_STADIUM_UZ = "хато қайта уриниб кўринг";

    //*************************************//
    String ERROR_NAME_STADIUM_RU = "это имя занято" + System.lineSeparator() + "пожалуйста попробуйте еще раз";
    String ERROR_NAME_STADIUM_EN = "this name is busy" + System.lineSeparator() + "please try again";
    String ERROR_NAME_STADIUM_UZL = "bu ism band" + System.lineSeparator() + "iltimos qayta urinib ko'ring";
    String ERROR_NAME_STADIUM_UZ = "бу исм банд" + System.lineSeparator() + "илтимос қайта уриниб кўринг";

    //*************************************//
    String GET_PHONE_NUMBER_STADIUM_RU = "Дайте мне номер телефона, который работает на стадионе! " + System.lineSeparator() + "  пример: +998917797278  " + System.lineSeparator() + " или нажмите кнопку ниже";
    String GET_PHONE_NUMBER_STADIUM_EN = "Give me a phone number that works in the stadium! " + System.lineSeparator() + " example: +998917797278  " + System.lineSeparator() + " or click the button below";
    String GET_PHONE_NUMBER_STADIUM_UZL = "Menga stadionda ishlaydigan telefon raqamini bering! " + System.lineSeparator() + " misol: +998917797278 " + System.lineSeparator() + " yoki quyidagi tugmani bosing";
    String GET_PHONE_NUMBER_STADIUM_UZ = "Менга стадионда ишлайдиган телефон рақамини беринг! " + System.lineSeparator() + " мисол: +998917797278   " + System.lineSeparator() + " ёки қуйидаги тугмани босинг";

    //*************************************//
    String GET_CLIENT_PHONE_NUMBER_STADIUM_RU = "\uD83D\uDCF1 Отправьте свой контакт или номер телефона в формате " + System.lineSeparator() + "  +998901234567  " + System.lineSeparator() + " ⤵️<i> Нажмите кнопку ниже </i> \uD83D\uDC47\uD83C\uDFFB";
    String GET_CLIENT_PHONE_NUMBER_STADIUM_EN = "\uD83D\uDCF1Send your contact or phone number in format " + System.lineSeparator() + "  +998901234567  " + System.lineSeparator() + " ⤵️ <i>Click the button below </i>\uD83D\uDC47\uD83C\uDFFB";
    String GET_CLIENT_PHONE_NUMBER_STADIUM_UZL = "\uD83D\uDCF1Kontaktingizni yoki telefon raqamingizni formatda yuboring " + System.lineSeparator() + " +998901234567" + System.lineSeparator() + " ⤵️ <i>quyidagi tugmani bosing</i> \uD83D\uDC47\uD83C\uDFFB";
    String GET_CLIENT_PHONE_NUMBER_STADIUM_UZ = "\uD83D\uDCF1Контактингизни ёки телефон рақамингизни форматда юборинг " + System.lineSeparator() + "  +998901234567 " + System.lineSeparator() + " ⤵️ <i>қуйидаги тугмани босинг</i> \uD83D\uDC47\uD83C\uDFFB";

    //*************************************//
    String SEND_MY_CURRENT_LOCATION_RU = "📍 отправить мое текущее местоположение 📍";
    String SEND_MY_CURRENT_LOCATION_EN = "📍 send my current location 📍";
    String SEND_MY_CURRENT_LOCATION_UZL = "📍 hozirgi turgan joyimni yuborish 📍";
    String SEND_MY_CURRENT_LOCATION_UZ = "📍 ҳозирги турган жойимни юбориш 📍";

    //*************************************//
    String CHANGE_CLIENT_PHONE_NUMBER_RU = "☎️ сменить номер телефона ☎️";
    String CHANGE_CLIENT_PHONE_NUMBER_EN = "☎️ change phone number ☎️";
    String CHANGE_CLIENT_PHONE_NUMBER_UZL = "☎️ telefon raqamni o'zgartirish ☎️";
    String CHANGE_CLIENT_PHONE_NUMBER_UZ = "☎️ телефон рақамини ўзгартириш ☎️";

    //*************************************//
    String SEND_CLIENT_CAN_ORDER_RU = "✅Ваш номер телефона принят. Вы можете заказать прямо сейчас.";
    String SEND_CLIENT_CAN_ORDER_EN = "✅Your phone number is accepted. You can order now.";
    String SEND_CLIENT_CAN_ORDER_UZL = "✅Telefon raqamingiz qabul qilindi. Endi buyurtma berishingiz mumkun.";
    String SEND_CLIENT_CAN_ORDER_UZ = "✅Телефон рақамингиз қабул қилинди. Энди буюртма беришингиз мумкун.";


    //**************************************//
    String uzl = "Uz\uD83C\uDDFA\uD83C\uDDFF";
    String uz = "Ўз\uD83C\uDDFA\uD83C\uDDFF";
    String ru = "Ру\uD83C\uDDF7\uD83C\uDDFA";
    String en = "En\uD83C\uDDEC\uD83C\uDDE7";

    //***************************************//
    String yes_uzl = "ha";
    String yes_uz = "ҳа";
    String yes_ru = "да";
    String yes_en = "yes";

    //***************************************//
    String nope_uzl = "yoq";
    String nope_uz = "ёқ";
    String nope_ru = "нет";
    String nope_en = "no";

    //**************************************//
    String HAVE_YOU_STADIUM_EN = "⚽️do you have your own stadium?";
    String HAVE_YOU_STADIUM_RU = "⚽️у тебя есть личный стадион?";
    String HAVE_YOU_STADIUM_UZL = "⚽️o'zingizning stadioningiz bormi?";
    String HAVE_YOU_STADIUM_UZ = "⚽️ўзингизнинг стадионингиз борми?";

    //**************************************/
    String WHERE_IS_THE_STADIUM_EN = "where is the stadium?";
    String WHERE_IS_THE_STADIUM_RU = "где стадион?";
    String WHERE_IS_THE_STADIUM_UZL = "stadion qayerda?";
    String WHERE_IS_THE_STADIUM_UZ = "стадион қаерда?";

    //**************************************/
    String HELLO_CHOOSE_A_LANGUAGE_UZL = "\uD83C\uDDFA\uD83C\uDDFF salom til tanlang";
    String HELLO_CHOOSE_A_LANGUAGE_UZ = "\uD83C\uDDFA\uD83C\uDDFF салом тил танланг";
    String HELLO_CHOOSE_A_LANGUAGE_RU = "\uD83C\uDDF7\uD83C\uDDFA привет выберите язык";
    String HELLO_CHOOSE_A_LANGUAGE_EN = "\uD83C\uDDEC\uD83C\uDDE7 hello choose a language";

    //**************************************/
    String HELLO_MR_UZL = "salom ";
    String HELLO_MR_UZ = "салом ";
    String HELLO_MR_RU = "Здравствуйте ";
    String HELLO_MR_EN = "hello ";

}
