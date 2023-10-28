package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PlayerDTO {
    @EqualsAndHashCode.Include
    private Integer idPlayer;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private String teamName;

    @NotNull
    private Integer shirtNumber;

}
