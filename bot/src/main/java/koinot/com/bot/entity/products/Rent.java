package koinot.com.bot.entity.products;

import koinot.com.bot.entity.Attachment;
import koinot.com.bot.enums.TypeCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.*;

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
@Entity(name="rent")
public class Rent {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    private Double livinigArea;

    private Double numberOfRooms;

    private Double kitchenArea;

    private Double totalArea;

    private Double floor;

    private Double totalFloors;

    private String typeOfBuilding;

    private String apartmentLayout;

//  private Date yearOfConstruction;

//  private Date starTime;

//  private Date endTime;

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

    @ManyToOne private Rent RealEstate;

    @ManyToOne private ConditionosNearby conditionosNearby;

}
