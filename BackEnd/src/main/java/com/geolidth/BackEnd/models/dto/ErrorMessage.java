package com.geolidth.BackEnd.models.dto;

import lombok.Data;

@Data
public class ErrorMessage {

    private String status;
    private String message;

    public ErrorMessage(String message) {
        this.status = "error";
        this.message = message;

    }
}
