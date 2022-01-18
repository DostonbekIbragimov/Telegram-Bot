
package koinot.com.bot.entity.products;

import koinot.com.bot.entity.products.template.ReadyProduct;
import koinot.com.bot.enums.Futures;
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
@Entity(name="realEstate")
public class RealEstate extends ReadyProduct {


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    private Boolean typeOfHouse;


    private Double livinigArea;

    private Double numberOfRooms;

    private Double kitchenArea;

    private Double totalArea;

    private Double floor;

    private Double totalFloors;

    private String typeOfBuilding;

    private String apartmentLayout;

    private String appointment;

    private Double carPlaces;

    private String garageType;

    private Double square;

    /*
    *
    * Parkova bor/yoq
    * if true bor, if false yoq
    *
    * */
    private Boolean parking = false;

    private Date starTime;

    private Date endTime;

    private String bathroom;

    /*
     *
     * mebel qoyilgan yoki qoyilmagan statement
     * if true mebebl bor, if flase yoq
     *
     */

    private Boolean furniture = false;

    private Double ceilingHeight;

// Home repairs qoldi va rieltor xizmati qoshilganmi yoqmi

    @ManyToOne private AddOptions addOptions;

     /*
   *
   * rieltor xizmati
   * if true bor, if false rieltor xizmati yoq
   *
   * */

    private Boolean raeltor = false;

}
