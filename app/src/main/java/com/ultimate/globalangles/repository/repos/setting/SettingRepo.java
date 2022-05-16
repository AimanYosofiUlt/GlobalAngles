package com.ultimate.globalangles.repository.repos.setting;

import com.ultimate.globalangles.repository.repos.base.BaseRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.info.GetInfoResponse;
import com.ultimate.globalangles.utilities.ValidateSt;

import javax.inject.Inject;

public class SettingRepo extends BaseRepo {
    @Inject
    public SettingRepo() {

    }

    public void getBasicInfo(ResponsesCallBack<GetInfoResponse> callBack) {
        api.getInfo(ValidateSt.bearerAccessToken,ValidateSt.languageCode)
                .enqueue(new ResponsesCallBack<GetInfoResponse>() {
                    @Override
                    public void onSuccess(GetInfoResponse response) {
                        callBack.onSuccess(response);
                    }

                    @Override
                    public void onFailure(String state, String errors) {
                        callBack.onFailure(state, errors);
                    }
                });
    }
}
