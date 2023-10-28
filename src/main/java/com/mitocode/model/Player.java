package com.mitocode.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlayer;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false, length = 80)
    private String teamName;
    @Column(nullable = false)
    private Integer shirtNumber;
}
