package com.geolidth.BackEnd.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class UserRolesDTO {
    private List<String> roles;

}