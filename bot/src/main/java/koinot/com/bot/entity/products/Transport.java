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
@Entity(name="transport")
public class Transport extends ReadyProduct {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    /*
     *
     * maxsulot holati yani ishlatilga yoki yangimi
     * agar false bo'lsa ishlatilgan
     * */
    private Boolean condition=false;

    private String typeOfBody;

    private Date yearOfIssue;

    private Long mileage;
    /*
    * if typeOfTransmission is false, then Type of transmission is Manual Transmission
    * (Механика), if true is Automatic
     */
    private Boolean typeOfTransmission = false;

    private String colour;

    private Double engineCapacity;

    private String typeOfFuel;

    //here should be 2 more columns or tables

    @Enumerated(EnumType.STRING)
    private TypeOfAgreement typeOfAgreement;

    private double price;


}
