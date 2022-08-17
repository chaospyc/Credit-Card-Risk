package com.chaossnow.ms.util;



public class SaltUilt {
    private String salt;
    private String password;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     // = new SecureRandomNumberGenerator().nextBytes().toString();
}
