package com.mitocode.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlayerPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlayerPosition;

    @ManyToOne
    @JoinColumn(name = "id_player", nullable = false, foreignKey = @ForeignKey(name = "FK_PP_PLAYER"))
    private Player player;

    @ManyToOne
    @JoinColumn(name = "id_position", nullable = false, foreignKey = @ForeignKey(name = "FK_PP_POSITION"))
    private Position position;
}
