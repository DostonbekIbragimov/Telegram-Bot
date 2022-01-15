package koinot.com.bot.component;

import koinot.com.bot.entity.Messages;
import koinot.com.bot.entity.Role;
import koinot.com.bot.enums.Msg;
import koinot.com.bot.enums.RoleName;
import koinot.com.bot.repository.MessagesRepository;
import koinot.com.bot.repository.RoleRepository;
import koinot.com.bot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}") private String initialMode;

    @Autowired UserRepository userRepository;

    @Autowired RoleRepository roleRepository;

    @Autowired MessagesRepository messagesRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) {

        if (initialMode.equals("always")) {

            roleRepository.save(new Role(1,RoleName.USER));
            roleRepository.save(new Role(2,RoleName.ADMIN));
            roleRepository.save(new Role(3,RoleName.SUPPER_ADMIN));

            List<Messages> messages=new ArrayList<>();

            for (Msg value : Msg.values()) {

                messages.add(new Messages(value.name(),value.getDescription(),
                                          value.getTitleUz() == null ? value.getTitleEn() : value.getTitleUz(),
                                          value.getTitleRu() == null ? value.getTitleEn() : value.getTitleRu(),
                                          value.getTitleEn()));

            }

            messagesRepository.saveAll(messages);

        }
    }
    
    public String krill_latin(String text) {
        String str=text
                .replaceAll("yu","ю")
                .replaceAll("ya","я")
                .replaceAll("ng","нг")
                .replaceAll("a","а")
                .replaceAll("b","б")
                .replaceAll("d","д")
                .replaceAll("e","е")
                .replaceAll("f","ф")
                .replaceAll("g","г")
                .replaceAll("h","ҳ")
                .replaceAll("i","и")
                .replaceAll("j","ж")
                .replaceAll("k","к")
                .replaceAll("l","л")
                .replaceAll("m","м")
                .replaceAll("n","н")
                .replaceAll("o","о")
                .replaceAll("p","п")
                .replaceAll("q","қ")
                .replaceAll("r","р")
                .replaceAll("s","с")
                .replaceAll("t","т")
                .replaceAll("u","у")
                .replaceAll("v","в")
                .replaceAll("x","х")
                .replaceAll("y","й")
                .replaceAll("z","з")
                .replaceAll("o'","ў")
                .replaceAll("g'","ғ")
                .replaceAll("sh","ш")
                .replaceAll("ch","ч")
                .replaceAll("ye","е")
                .replaceAll("yo","ё")
                .replaceAll("e","э")
                .replaceAll("’","ъ")
                .replaceAll("\\s{2,}"," ");

        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

}
