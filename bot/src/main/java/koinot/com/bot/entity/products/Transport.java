package koinot.com.bot.entity.products;

import koinot.com.bot.entity.addons.AddOptions;
import koinot.com.bot.entity.addons.Models;
import koinot.com.bot.entity.products.template.ReadyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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
@Entity(name = "transport")
public class Transport extends ReadyProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Kategoriya

    @ManyToOne
    private AddOptions transportCategory;

    //  Brand / Marka
    @ManyToOne
    private Models models;


    //  Kuzov

    @ManyToOne
    private AddOptions transportTypeOfBody;


    // Ishlab chiqarilgan yili

    private Date yearOfIssue;


    // Probeg

    private Double mileage;


    // transmissiya quttisi
    @ManyToOne
    private AddOptions typeOfTransmission;

    //  Moshina rangi
    private String colour;

    //  search/post by color code
    private String colourCode;

    //  dvigatel hajmi
    private Double engineCapacity;


    //  yoqilg'i turi
    private String typeOfFuel;


    // haydovchi birligi - > privod
    private String driveUnit;

    // tashqaridagi bor qulayliklar
    @ManyToMany
    private List<AddOptions> hasTransportOptionsOutside;

    // moshinada bor qulayliklar
    @ManyToMany
    private List<AddOptions> hasTransportOptions;

    // moshina salon
    @ManyToMany
    private List<AddOptions> hasTransportInteriorOptions;

    // moshina media qulayliklari
    @ManyToMany
    private List<AddOptions> hasTransportMediaOptions;


    // moshina media qulayliklari
    @ManyToMany
    private List<AddOptions> hasTransportOpticsOptions;

    // qoshimcha
    @ManyToMany
    private List<AddOptions> additionally;

   /*
   *
   * sotib olish opsiyasi bilan ijaraga
   * if false - sotib olish opsiyasi yoq
   * if true -  sotib olish opsiyasi bor
   *
   * */

    private Boolean hasLeasing = false;

    /******** Mototexnika (Moto technics) ********/

    // Transport texnika turi

    @ManyToOne
    private AddOptions typeOfMotoTechnics;

    // model (brand emas)
    private String serialModel;


    /******** Suv Transporti (Water Transport) ********/

    // suv texnika turi

    @ManyToOne
    private AddOptions typeOfWaterTechnics;

    /******** Tijorat Transport Turi (Commercial Type of Transport) ********/





}
