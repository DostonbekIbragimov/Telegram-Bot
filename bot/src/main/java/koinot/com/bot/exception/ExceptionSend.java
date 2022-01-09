package koinot.com.bot.exception;

import koinot.com.bot.entity.User;
import koinot.com.bot.service.GetUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class ExceptionSend {
   @Lazy @Autowired GetUpdate getUpdate;


    public void senException(String msg,Exception error,User user) {
        try {


            if (user != null) {
                new Thread(() -> {
                    sendErrorForAdmin(-1001540481206L,("#" + msg).replace(" ","") + System.lineSeparator() +
                            (error == null ? "null" : error) + System.lineSeparator() + msg + user.getPhoneNumber() +
                            System.lineSeparator() + user.getFirstName() + System.lineSeparator() + user.getLastName() +
                            System.lineSeparator() + user.getId());
                }).start();
            } else {
                new Thread(() -> {
                    sendErrorForAdmin(-1001540481206L,("#" + msg).replace(" ","") + System.lineSeparator() +
                            (error == null ? "null" : error) + System.lineSeparator() + msg);
                }).start();
            }
        } catch (Exception e) {
            log.error(" my error => ",e);
        }

    }

    public void sendErrorFileNohup() {
        try {
            File file=new File("nohup.out");
            SendDocument sendDocumentRequest=new SendDocument();
            sendDocumentRequest.setChatId(String.valueOf(-1001540481206L));
//            sendDocumentRequest.setDocument( file );
            sendDocumentRequest.setCaption(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
            getUpdate.bot.execute(sendDocumentRequest);
            PrintWriter writer=new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (Exception e) {
            log.error(" send error file error => ",e);
        }
    }

    public void sendErrorForAdmin(Long id,String text) {
        try {
            getUpdate.send(id,text);
        } catch (Exception e) {
            log.error(" my error => ",e);
        }


    }

}
