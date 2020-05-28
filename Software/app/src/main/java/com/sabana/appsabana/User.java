package com.sabana.appsabana;

import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {

    private String email;

    private String password;

    private String name;

    private String address;

    private String phone;

    private keyModel key;

    private String info;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public keyModel getKey() {
        return key;
    }

    public void setKey(keyModel key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

 class keyModel implements Serializable {
    private String algorithm;

    private String encoded;

    private String format;

    private boolean destroyed;

     public String getAlgorithm() {
         return algorithm;
     }

     public void setAlgorithm(String algorithm) {
         this.algorithm = algorithm;
     }

     public String getEncoded() {
         return encoded;
     }

     public void setEncoded(String encoded) {
         this.encoded = encoded;
     }

     public String getFormat() {
         return format;
     }

     public void setFormat(String format) {
         this.format = format;
     }

     public boolean isDestroyed() {
         return destroyed;
     }

     public void setDestroyed(boolean destroyed) {
         this.destroyed = destroyed;
     }
 }
