package com.revature.demos.talking_to_prism.dtos;

public class OrganizationResponse {

    private String orgId;
    private String orgName;
    private String authCode;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "OrganizationResponse{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", authCode='" + authCode + '\'' +
                '}';
    }

}
