package com.touchsoft.model;

public enum Role /*implements GrantedAuthority */{
    ROLE_AGENT, ROLE_CLIENT;

    public String getAuthority() {
        return name();
    }

}
