package fr.jdv.request;

import fr.ekinci.clientmodels.UserDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ulysse on 05/11/2017.
 */
public class UserRequest {

    //@Value("${data-access-service.url}")
    private final String serviceUrl = "http://localhost";

    //@Value("${data-access-service.port")
    private final String servicePort = "25002";

    private final String serviceBaseUri = "/data-access";

    public UserDto post(UserDto userDto) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(buildUrl("/users/"), userDto, UserDto.class);
    }

    public UserDto get(String id) {
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = null;
        userDto = restTemplate.getForObject(buildUrl("/users/"+id), UserDto.class);
        return userDto;
    }

    private String buildUrl(String args) {
        return serviceUrl + ":" + servicePort + serviceBaseUri +args;
    }
}
