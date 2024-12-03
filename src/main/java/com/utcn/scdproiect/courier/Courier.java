package com.utcn.scdproiect.courier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Integer courier_id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "courier_id", nullable = true)
    private Courier manager;
}
