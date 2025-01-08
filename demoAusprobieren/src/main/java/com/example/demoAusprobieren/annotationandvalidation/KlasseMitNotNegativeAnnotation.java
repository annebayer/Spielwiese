package com.example.demoAusprobieren.annotationandvalidation;

public class KlasseMitNotNegativeAnnotation {

    @NotNegative
    private int myNotNegativeNumber;

    public KlasseMitNotNegativeAnnotation() {}

    public KlasseMitNotNegativeAnnotation(int myNotNegativeNumber) {
        this.myNotNegativeNumber = myNotNegativeNumber;
    }

    public int getMyNotNegativeNumber() {
        return myNotNegativeNumber;
    }

    public void setMyNotNegativeNumber(int myNotNegativeNumber) {
        this.myNotNegativeNumber = myNotNegativeNumber;
    }
}
