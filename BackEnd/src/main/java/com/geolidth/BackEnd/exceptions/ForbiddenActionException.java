package com.geolidth.BackEnd.exceptions;

public class ForbiddenActionException extends RuntimeException {

    public static final  String MESSAGE = "Nana!!! Ilyet nem szabad csinálni!";

    public ForbiddenActionException() {
        super(MESSAGE);
    }
}
