package com.sise.botonpanico.shared;

public interface Callback<T> {
    void onSuccess(T result);
    void onFailure();
}
