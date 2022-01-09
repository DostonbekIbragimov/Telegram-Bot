package koinot.com.bot.entity;

import koinot.com.bot.entity.enums.Msg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
@Entity(name="messages")
public class Messages {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;

    @OrderBy @CreationTimestamp @Column(nullable=false, updatable=false) private Timestamp createdAt;

    @UpdateTimestamp @Column(nullable=false) private Timestamp updatedAt;

    @CreatedBy @Column(updatable=false) private Long createdBy;

    @LastModifiedBy private Long updatedBy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Msg name;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(columnDefinition="TEXT", nullable = false)
    private String textUz;

    @Column(nullable = false)
    private String descriptionRu;

    @Column(columnDefinition="TEXT", nullable = false)
    private String textRu;

    @Column(nullable = false)
    private String descriptionKr;

    @Column(columnDefinition="TEXT", nullable = false)
    private String textKr;

    @Column(nullable = false)
    private String descriptionEn;

    @Column(columnDefinition="TEXT", nullable = false)
    private String textEn;

    public Messages(Msg name,String descriptionUz,String textUz,String descriptionRu,String textRu,String descriptionKr,String textKr,String descriptionEn,String textEn) {
        this.name=name;
        this.descriptionUz=descriptionUz;
        this.textUz=textUz;
        this.descriptionRu=descriptionRu;
        this.textRu=textRu;
        this.descriptionKr=descriptionKr;
        this.textKr=textKr;
        this.descriptionEn=descriptionEn;
        this.textEn=textEn;
    }
}
