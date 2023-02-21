package com.wtd.feignClient.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eurekaclient")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();

    @RequestMapping(value = "/whoami/{username}")
    String whoami(@PathVariable("username") String username);
}
