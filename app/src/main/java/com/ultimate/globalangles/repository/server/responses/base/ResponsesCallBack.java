package com.ultimate.globalangles.repository.server.responses.base;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ResponsesCallBack<T extends ResponseObject> implements Callback<T> {
    public abstract void onSuccess(T response);

    public abstract void onFailure(String state, String errors);

    @Override
    public final void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) {
            ResponseObject responseObject = response.body();
            if (responseObject == null) {
                onFailure("0", "null response from the api");
            } else {
                if (responseObject.getErrors() != null) {
                    if (responseObject.getErrors().size() == 0) {
                        onSuccess(response.body());
                    } else {
//                        List<String> errors = responseObject.getErrors();
//                        String strList = "";
//                        for (String error : errors) {
//                            Log.d("ResponsesCallBack", "onResponse: " + error);
//                        }
                        //todo handle the errors here
                        onFailure("0", "error not handled yet");
                    }
                } else {
                    onFailure("0", "null response from the api");
                }
            }
        } else {
            onFailure("0", response.message());
        }
    }

    @Override
    public  final void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onFailure("0",t.getMessage());
    }
}