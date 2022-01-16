package koinot.com.bot.entity.products;

import koinot.com.bot.entity.products.template.ReadyProduct;
import koinot.com.bot.enums.TypeOfAgreement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
@Entity(name="fashionAndStyle")
public class FashionAndStyle extends ReadyProduct {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfAgreement typeOfAgreement;

    private double price;

}
