package com.dlm.constructions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


//Todo esto es para no tener mas codifgo
@Entity
@Table(name = "construction_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Construction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date rowVersion;


}
