package com.ultimate.globalangles.repository.server.responses.get_all_notifications;

import com.google.gson.annotations.SerializedName;

public class NotificationData {
    @SerializedName("sent_at")
    private String sent_at;
    @SerializedName("is_read")
    private boolean is_read;
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private String id;

    public String getSent_at() {
        return sent_at;
    }

    public void setSent_at(String sent_at) {
        this.sent_at = sent_at;
    }

    public boolean getIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
