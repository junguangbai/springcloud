package com.atguigu.springcloud.entities;

/**
 * @author baijunguang
 * @date 2020/5/25-12:07
 */
public class Payment {
    private Long id;
    private String serial;

    public Payment() {
    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
