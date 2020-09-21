package org.caio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        try {
            request();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void request() throws JSONException {
        JSONObject object = new JSONObject();
        JSONObject sub = new JSONObject();
        object.put("orderId", 5362);
        sub.put("idProduct", 1);
        sub.put("quantity", 1);
        object.put("orderProductsDto", sub);
        Log.e("DTO", object.toString());

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.DELETE,
                "http://172.100.10.104:8181/order/mobile/removeItem",
                object,
                success -> {
                    Log.e("success", success.toString());
                },
                error -> {
                    Log.e("error", error.toString());
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvd25lciI6ZmFsc2UsInVzZXJfbmFtZSI6Imdob3N0bWFya2V0QGl0YmFtLm9yZy5iciIsImNvbXBhbnlOYW1lIjoiR2hvc3QgTWFya2V0IiwiY29tcGFueUNucGoiOiIwNDQwODkyOTAwMDEwNSIsImZpcnN0QWNjZXNzIjpmYWxzZSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9SRUFEX01PVkVNRU5UIiwiUk9MRV9WSUVXX0VESVRfQ09NUEFOWSIsIlJPTEVfUkVBRF9QUklOVEVSX1NUQVRVUyIsIlJPTEVfVVBEQVRFX05PVElGSUNBVElPTiIsIlJPTEVfVVBEQVRFX1NVUFBMWSIsIlJPTEVfUkVBRF9TVVBQTFkiLCJST0xFX1JFQURfVEVSTUlOQUwiLCJST0xFX0NSRUFURV9VU0VSIiwiUk9MRV9SRUFEX0NPTVBBTlkiLCJST0xFX1VQREFURV9QUk9EVUNUIiwiUk9MRV9SRUFEX0NFUlRJRklDQVRFIiwiUk9MRV9FRElUX1BIT1RPX0NPTVBBTlkiLCJST0xFX1JFQURfVVNFUiIsIlJPTEVfVVBEQVRFX1VTRVIiLCJST0xFX1JFQURfVEVSTUlOQUxfTU9ERUwiLCJST0xFX0NSRUFURV9QUk9EVUNUIiwiUk9MRV9SRUFEX05PVElGSUNBVElPTiIsIlJPTEVfQ1JFQVRFX0NFUlRJRklDQVRFIiwiUk9MRV9WSUVXX0RBU0hCT0FSRCIsIlJPTEVfUkVBRF9PUkRFUiIsIlJPTEVfREVMRVRFX1VTRVIiLCJST0xFX0RFTEVURV9OT1RJRklDQVRJT04iLCJST0xFX1JFQURfUFJPRFVDVCIsIlJPTEVfUkVBRF9DT05UQUlORVIiLCJST0xFX0RFTEVURV9QUk9EVUNUIl0sImNsaWVudF9pZCI6Imdob3N0bWFya2V0IiwiY29tcGFueUlkIjozNSwic2NvcGUiOlsicmVhZCIsInRydXN0Iiwid3JpdGUiXSwiaWQiOjEyOTAsImV4cCI6MTU5NzM0MDQ5NSwianRpIjoiNzI4MjkwMGEtNTU5OS00ZGZjLWIxMmQtNzg3ZTdjYWE1NGMzIiwiZW1haWwiOiJnaG9zdG1hcmtldEBpdGJhbS5vcmcuYnIifQ.hLseIQN9q3y1JCtQjQnh6AyZGUThtOaIaSk5E0Y609A");
                return headers;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                Log.e("response", response.statusCode + "");
                return super.parseNetworkResponse(response);
            }
        };
        queue.add(request);
    }
}