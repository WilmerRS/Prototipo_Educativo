package com.leonet.app.model.user;

public class UserRepository {
    private String nickname;
    private String name;
    private String email;
    private String password;
    private String date_birth;
    private String registration_date;
    private int level;
    private int coin;
    private int gem;

    public UserRepository(String nickname,
                          String name,
                          String email,
                          String password,
                          String date_birth,
                          String registration_date,
                          int level,
                          int coin,
                          int gem) {
        this.nickname = nickname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.date_birth = date_birth;
        this.registration_date = registration_date;
        this.level = level;
        this.coin = coin;
        this.gem = gem;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getGem() {
        return gem;
    }

    public void setGem(int gem) {
        this.gem = gem;
    }
}
