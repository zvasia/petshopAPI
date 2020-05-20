package models;

import com.google.gson.annotations.SerializedName;

public class UserPostPutDeleteResponseModel {

    @SerializedName("code")
    private int code;

    @SerializedName("type")
    private String type;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return
                "UserPostOrPutResponceModel{" +
                        "code = '" + code + '\'' +
                        ",type = '" + type + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}