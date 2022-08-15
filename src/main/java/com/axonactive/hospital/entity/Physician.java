package com.axonactive.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//THIS IS NAMED QUERY
@NamedQueries({
        @NamedQuery(name ="Physician.findByFullName",
                    query ="select p from Physician p where p.fullName = ?1"),
        @NamedQuery(name ="Physician.findByPhysicianCode",
                    query = "select p from Physician p where p.physicianCode like concat('%',?1,'%')")
})
public class Physician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer physicianId;

    private String fullName;
    @Column(unique=true)
    private String physicianCode;

}
