package com.fujiyama.pulp.developerprofiler.rest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private String authToken;

    public AuthInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder builder = request.newBuilder()
                .addHeader("Authorization", "token " + authToken)
                .addHeader("User-Agent", "Gitpro");

        Request authenticatedRequest = builder.build();

        return chain.proceed(authenticatedRequest);
    }
}
