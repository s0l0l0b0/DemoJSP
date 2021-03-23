package com.example.demojsp.model;

public class ActionResponse {
    private boolean result;
    private String message;

    public ActionResponse result(boolean result) {
        this.result = result;
        return this;
    }

    public ActionResponse message(String message) {
        this.message = message;
        return this;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ActionResponse{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
