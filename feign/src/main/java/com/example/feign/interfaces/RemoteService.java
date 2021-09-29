package com.example.feign.interfaces;

import com.example.feign.FeignUser;
import feign.Headers;
import feign.RequestLine;

public interface RemoteService {
    @Headers({"Content-Type: application/json;charset:utf-8;","Accept: application/json"})
    @RequestLine("POST /info")
    FeignUser getInfo(FeignUser user);
}
