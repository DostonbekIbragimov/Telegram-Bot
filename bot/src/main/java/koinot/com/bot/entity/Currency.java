package koinot.com.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Currency")
public class Currency {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    @Column(unique=true) private String name;

    @Column(unique=true) private String ccy;


}
