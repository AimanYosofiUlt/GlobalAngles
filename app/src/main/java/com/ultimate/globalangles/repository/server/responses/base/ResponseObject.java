package com.ultimate.globalangles.repository.server.responses.base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public abstract class ResponseObject<Data> implements Serializable {
    @SerializedName("messages")
    private List<String> messages;
    @SerializedName("data")
    private Data data;
    @SerializedName("errors")
    private List<String> errors;
    @SerializedName("code")
    private int code;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
