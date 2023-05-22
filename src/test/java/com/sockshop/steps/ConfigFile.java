package com.sockshop.steps;

import java.util.Random;

public class ConfigFile {

    private String baseURL = "http://localhost:/";
    private String driverPath = "driver/chromedriver.exe";

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURl(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public static int randomPortGenerator() {

        int min = 10000;
        int max = 60000;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void Timer(long a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

