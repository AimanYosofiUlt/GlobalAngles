package com.ultimate.globalangles.utilities.state;

public interface OnValidateListener {
    default boolean onValidate() {
        return true;
    }
}