package koinot.com.bot.entity.addons;

import koinot.com.bot.entity.addons.Attachment;
import koinot.com.bot.enums.Futures;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Timestamp;

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
@Entity(name="addOptions")
public class AddOptions {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;


    @UpdateTimestamp @Column(nullable=false) private Timestamp updatedAt;

    @CreatedBy @Column(updatable=false) private Long createdBy;

    @LastModifiedBy private Long updatedBy;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionUz;//default use

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionRu;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionEn;

    @Column(nullable=false) private String nameUz;//default use

    @Column(nullable=false) private String nameRu;

    @Column(nullable=false) private String nameEn;

    @Column(nullable=false) private String icon;

    @ManyToOne private Attachment image;

    @Enumerated(EnumType.STRING)
    private Futures futures;


}
