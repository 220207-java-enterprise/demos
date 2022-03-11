package com.revature.demos.talking_to_prism.dtos;

public class NewOrgRequest {

    private String name;
    private String key;

    public NewOrgRequest() {
        super();
    }

    public NewOrgRequest(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "NewOrgRequest{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

}
