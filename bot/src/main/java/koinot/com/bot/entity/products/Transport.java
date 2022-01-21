package koinot.com.bot.entity.products;

import koinot.com.bot.entity.addons.AddOptions;
import koinot.com.bot.entity.addons.Models;
import koinot.com.bot.entity.addons.TypeOfBody;
import koinot.com.bot.entity.products.template.ReadyProduct;
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

    @ManyToOne private TypeOfBody typeOfBody;

    private Date yearOfIssue;

    private Double mileage;
    /*
     * if typeOfTransmission is false, then Type of transmission is Manual Transmission
     * (Механика), if true is Automatic
     */
    private Boolean typeOfTransmission=false;

    private String colour;

    private String colourCode;

    private Double engineCapacity;

    private String typeOfFuel;

    private String subCategories;

    private String typeOfMoto;

    @ManyToOne private Models models;

    private Double ownerCount;

    @ManyToOne private AddOptions addOptions;



}
