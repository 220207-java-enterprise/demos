package com.revature.demos.talking_to_prism.dtos;

public class OrgAuthRequest {

    private String orgId;
    private String authCode;

    public OrgAuthRequest() {
        super();
    }

    public OrgAuthRequest(String orgId, String authCode) {
        this.orgId = orgId;
        this.authCode = authCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "OrgAuthRequest{" +
                "orgId='" + orgId + '\'' +
                ", authCode='" + authCode + '\'' +
                '}';
    }

}
