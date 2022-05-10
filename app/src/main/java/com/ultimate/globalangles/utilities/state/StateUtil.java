package com.ultimate.globalangles.utilities.state;

import android.content.Context;

import com.ultimate.ecommerce.utilities.NetworkUtil;

public class StateUtil {
    public static Check validate(OnValidateListener listener) {
        return new Check(listener.onValidate());
    }

    public static class Check {
        private final boolean isValidate;

        public Check(boolean isValidate) {
            this.isValidate = isValidate;
        }

        public void checkNetwork(Context context, CheckNetworkListener listener) {
            if (isValidate) {
                boolean hasConnection = NetworkUtil.isConnectionAvailable(context);
                if (hasConnection)
                    listener.onConnect();
                else
                    listener.onDisconnect();
            }
        }
    }

}
