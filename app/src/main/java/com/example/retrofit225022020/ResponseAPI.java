package com.example.retrofit225022020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAPI {
    private boolean success;

    @SerializedName("word")
    @Expose
    private List<Word> word;

    @SerializedName("message")
    @Expose
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Word> getWord() {
        return word;
    }

    public void setWord(List<Word> word) {
        this.word = word;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
