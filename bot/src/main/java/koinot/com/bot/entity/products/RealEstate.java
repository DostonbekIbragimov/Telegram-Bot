
package koinot.com.bot.entity.products;

import koinot.com.bot.entity.addons.AddOptions;
import koinot.com.bot.entity.products.template.ReadyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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
@Entity(name = "realEstate")
public class RealEstate extends ReadyProduct {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date yearOfIssue;

    private Double livingArea;

    private Double numberOfRooms;

    private Double kitchenArea;

    private Double totalArea;

    private Integer floor;

    private Integer totalFloors;


    @ManyToOne
    private AddOptions typeOfBuilding;

    @ManyToOne
    private AddOptions apartmentLayout;

    @ManyToMany
    private List<AddOptions> houseCondition;

    @ManyToOne
    private AddOptions typeOfProperty;

    @ManyToOne
    private AddOptions typeOfHouse;

    @ManyToMany
    private List<AddOptions> propertyHasWorkingConditions;

    @ManyToOne
    private AddOptions appointment;

    private Integer carPlaces;

    @ManyToOne
    private AddOptions typeOfGarage;

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

    @ManyToOne
    private AddOptions bathroom;


    @ManyToOne
    private AddOptions bathroomInHouse;


    @ManyToMany
    private List<AddOptions> hasHouse;

    @ManyToMany
    private List<AddOptions> hasHouseConditionsNearby;


    @ManyToMany
    private  List<AddOptions> hasHousePublicUtilities;




    @ManyToMany
    private List<AddOptions> hasGroundPublicUtilities;

    @ManyToOne
    private AddOptions groundWhereLocated;

    /*
     *
     * mebel qoyilgan yoki qoyilmagan statement
     * if true mebebl bor, if flase yoq
     *
     */

    private Boolean furniture = false;

    private Double ceilingHeight;

// Home repairs qoldi va rieltor xizmati qoshilganmi yoqmi

    @ManyToMany
    private List<AddOptions> hasFlat;

    @ManyToMany
    private List<AddOptions> hasConditionsNearby;

    @ManyToMany
    private List<AddOptions> hasRepairs;

    @ManyToOne
    private AddOptions whereLocated;

    /*
     *
     * rieltor xizmati
     * if true bor, if false rieltor xizmati yoq
     *
     * */

    private Boolean realtor = false;

}
