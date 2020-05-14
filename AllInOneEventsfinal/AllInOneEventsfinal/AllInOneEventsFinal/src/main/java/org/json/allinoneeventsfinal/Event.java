/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json.allinoneeventsfinal;

/**
 *
 * @author rhiya
 */
public class Event {
    private String name;
    private String id;
    private String url;
    private String localDate;
    private String localTime;
    private String code;
    private String genreName;
    private String note;
    private String type;
    private String min;
    private String max;
    private String venName;
    private String venPostcode;
    private String city;

    public Event(String name, String id, String url, String localDate, String localTime, String code, String genreName, String note, String type, String min, String max, String venName, String venPostcode, String city) {
        this.name = name;
        this.id = id;
        this.url = url;
        this.localDate = localDate;
        this.localTime = localTime;
        this.code = code;
        this.genreName = genreName;
        this.note = note;
        this.type = type;
        this.min = min;
        this.max = max;
        this.venName = venName;
        this.venPostcode = venPostcode;
        this.city = city;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getVenName() {
        return venName;
    }

    public void setVenName(String venName) {
        this.venName = venName;
    }

    public String getVenPostcode() {
        return venPostcode;
    }

    public void setVenPostcode(String venPostcode) {
        this.venPostcode = venPostcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
