package koinot.com.bot.entity.products;

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
@Entity(name="conditionsNearby")
public class ConditionosNearby {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    private String livingConditionsNearby;

    @ManyToOne private ConditionosNearby RealEstate;


}
