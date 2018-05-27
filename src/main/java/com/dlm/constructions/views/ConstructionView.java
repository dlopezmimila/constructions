package com.dlm.constructions.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ConstructionView implements Serializable {

    private Long idType;
    @NotEmpty (message = "Nombre Obligatorio")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date rowVersion;
}
