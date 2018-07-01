package com.qwersoft.searchdemo.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IT02106 on 01/07/2018.
 */

public class MItem {
    @SerializedName("login")
    public String login;

    @SerializedName("avatar_url")
    public String avatarUrl;

    public MItem(String login, String avatarUrl)
    {
        this.login = login;
        this.avatarUrl = avatarUrl;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
