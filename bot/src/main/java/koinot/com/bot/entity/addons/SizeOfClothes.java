package koinot.com.bot.entity.addons;

import koinot.com.bot.entity.addons.Attachment;
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
@Entity(name="sizeOfClothes")
public class SizeOfClothes {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    @Column(nullable=false) private String name;

    @Column(nullable=false) private String iconCategory;

    @ManyToOne private Attachment image;
}