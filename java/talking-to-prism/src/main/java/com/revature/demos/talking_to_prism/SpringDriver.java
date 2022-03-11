package com.revature.demos.talking_to_prism;

import com.revature.demos.talking_to_prism.dtos.NewOrgRequest;
import com.revature.demos.talking_to_prism.dtos.OrgAuthRequest;
import com.revature.demos.talking_to_prism.dtos.OrgRegistrationResponse;
import com.revature.demos.talking_to_prism.dtos.OrganizationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringDriver {

    private static String prismRoot = "http://localhost:5000/prism";
    public static RestTemplate prismClient = new RestTemplate();

    public static void main(String[] args) {
        try {
//            registerDummyOrg();
            authenticateDummyOrg();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static void registerDummyOrg() {

        // Set the content type for the request to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // prepare the request payload
        NewOrgRequest newOrgRequest = new NewOrgRequest("DummyOrg", "dummy-key");
        HttpEntity<NewOrgRequest> request = new HttpEntity<>(newOrgRequest, headers);

        // make the request by attaching the payload and parsing the response
        OrgRegistrationResponse response = prismClient.postForObject(prismRoot + "/organizations", request, OrgRegistrationResponse.class);
        System.out.println(response);


    }


    public static void authenticateDummyOrg() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        OrgAuthRequest authRequest = new OrgAuthRequest("28b115fb-40c5-4abe-a5ad-8b25e306b8ef", "81351291-7e76-483a-9f91-b77df71feaa7");
        HttpEntity<OrgAuthRequest> request = new HttpEntity<>(authRequest, headers);
        ResponseEntity<OrganizationResponse> response = prismClient.postForEntity(prismRoot + "/auth", request, OrganizationResponse.class);
        System.out.println(response);
        System.out.println("+----------------------------+");
        System.out.println(response.getStatusCode());
        System.out.println("+----------------------------+");
        System.out.println(response.getHeaders().get("Authorization"));
        System.out.println("+----------------------------+");
        System.out.println(response.getBody());

    }

}
