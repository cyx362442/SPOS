package com.duowei.spos.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MyStringRequest extends StringRequest {
    private String sql;

    private void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
        	// 解决json文件乱码问题
            parsed = new String(response.data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
	
	public MyStringRequest(int method, Listener<String> listener,ErrorListener errorListener,String sql) {
		super(method, Net.url, listener, errorListener);
        setSql(sql);
	}

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        HashMap<String, String> map = new HashMap<>();
        String base64Sql = Base64.getBase64(sql);
        map.put("State", "6");
        map.put("Ssql", base64Sql);
        return map;
    }
}
