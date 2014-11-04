package com.twilio.sdk.deleters;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.Call;

public class CallDeleter extends SidDeleter<Call> {
    @Override
    public void execute(String sid, TwilioRestClient client) {
        Request request = new Request(HttpMethod.DELETE, "/Accounts/{AccountSid}/Calls/" + sid);
        Response response = client.request(request);

        if (response == null) {
            throw new RuntimeException("Call delete failed: Unable to connect to server");
        } else if (response.getStatusCode() != 204) {
            throw new RuntimeException("Call delete failed: [" + response.getStatusCode() + "] " + response.getContent());
        }
    }
}
