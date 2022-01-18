package koinot.com.bot.entity.products;

import koinot.com.bot.entity.products.template.ReadyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
@Entity(name="electronics")
public class Electronics extends ReadyProduct {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    /*
    *
    * maxsulot holati yani ishlatilga yoki yangimi
    * agar false bo'lsa ishlatilgan
    * */
    private Boolean condition=false;

    private String phoneNumber;


}
