package koinot.com.bot.entity.products;

import koinot.com.bot.entity.products.template.ReadyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name="childsInventory")
public class ChildsInventory extends ReadyProduct {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    /*
    * if condition is false then it's used (xolati ishlatilgan)
    * if true -> new (xolati yangi)
     */
    private Boolean condition = false;

}
