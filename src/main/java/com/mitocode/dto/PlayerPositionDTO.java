package com.mitocode.dto;

import com.mitocode.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPositionDTO {
    private Integer idPlayerPosition;
    private PlayerDTO player;
    private PositionDTO position;

}
