package koinot.com.bot.entity.products;

import koinot.com.bot.entity.addons.Attachment;
import koinot.com.bot.entity.products.template.ReadyProduct;
import koinot.com.bot.enums.TypeOfAgreement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * @className: BotMessage  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 6:35 AM $
 * @author: Qudratjon Komilov
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Job")
public class Job extends ReadyProduct {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    /*
     *
     * ishlamoqchimi yoki ish taklif qilyaptimi
     * agar false ishlamoqchi
     * */
    private Boolean offer=false;


    /*
     *
     * bandlik turi
     * agar false vaqtincha ish bo'ladi , true bo'lsa doimiy ishlaydi
     * */
    private Boolean typeOfBusy=false;

    private String phoneNumber;

    @Enumerated(EnumType.STRING) private TypeOfAgreement typeOfAgreement;

    private double starPrice;

    private double EnPrice;

    private Date startWorkTime;

    private Date endWorkTime;

    @OneToOne
    private Attachment resume;



}
