package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.Messages;
import koinot.com.bot.enums.Msg;
import koinot.com.bot.repository.MessagesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: UserService  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 3:39 AM $
 * @author: Qudratjon Komilov
 */
@Service
@Slf4j
public class MessageDB {

    @Autowired MessagesRepository messageRepository;

    public Messages saveMessages(Messages message) {

        return messageRepository.save(message);

    }

    public Messages getMessage(String s) {

        return messageRepository.findByName(s);

    }

    public Messages getMessage(Msg s) {

        return messageRepository.findByName(s.name());

    }


}
