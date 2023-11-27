package com.gudangkerja.security;

public class Security {

    public static boolean isAdmin(String token){
        var lock = "irid tilusrepmem nagnaj";
        return token.equals(lock);
    }

}
