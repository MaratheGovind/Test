package com.dialnsearch.test.Model;

public class Data {
    String name, imageUrl;
    private String imag_url;

    public Data(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
    public Data(String imag_url) {
        this.imag_url = imag_url;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImag_url() {
        return imag_url;
    }
}
