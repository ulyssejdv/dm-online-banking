package fr.jdv.request;

import fr.ekinci.clientmodels.PhoneDto;
import fr.ekinci.clientmodels.UserDto;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ulysse on 05/11/2017.
 */
public class PhoneRequest {

    //@Value("${data-access-service.url}")
    private final String serviceUrl = "http://localhost";

    //@Value("${data-access-service.port")
    private final String servicePort = "25002";

    private final String serviceBaseUri = "/data-access";

    /**
     * Send a POST request to the data access service
     * @param phoneDto
     * @return
     */
    public PhoneDto post(PhoneDto phoneDto, String idUser) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(buildUrl("/users/"+idUser+"/phones"), phoneDto, PhoneDto.class);
    }

    private String buildUrl(String args) {
        return serviceUrl + ":" + servicePort + serviceBaseUri +args;
    }

}
