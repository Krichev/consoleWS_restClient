package com.touchsoft.dto;

import java.io.Serializable;

public class RoleTokenDTO implements Serializable {
    private String role;

    private String token;

    public RoleTokenDTO() {
    }

    public RoleTokenDTO(String role, String token) {
        this.role = role;
        this.token = token;
    }

    public String getRole() {
        return this.role;
    }

    public String getToken() {
        return this.token;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleTokenDTO)) return false;
        final RoleTokenDTO other = (RoleTokenDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoleTokenDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    public String toString() {
        return "RoleTokenDTO(role=" + this.getRole() + ", token=" + this.getToken() + ")";
    }
}
