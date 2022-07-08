package com.projectpenguin.logviewer.general.responses;

public interface IMessage {
    default String obscureFieldValue(String value) {
        return value == null ? null : "***";
    }
}
