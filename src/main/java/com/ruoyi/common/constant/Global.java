package com.ruoyi.common.constant;

import org.springframework.beans.factory.annotation.Value;

public class Global {
    @Value("${ruoyi.profile}")
    private static String profileUrl;

    public static String getProfileUrl() {
        return profileUrl;
    }

    public static void setProfileUrl(String profileUrl) {
        Global.profileUrl = profileUrl;
    }
}
