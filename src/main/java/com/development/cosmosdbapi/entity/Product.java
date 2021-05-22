package com.development.cosmosdbapi.entity;

public class Product {
    private String id;
    private String chipset;
    private String gpuFrequency;
    private String memory;
    private String type;
    private String frequency;
    private String supports;
    private String powerAuxiliary;
    private String deliveryType;
    private Integer count;

    public Product(String id, String chipset, String gpuFrequency, String memory, String type, String frequency, String supports, String powerAuxiliary, String deliveryType, Integer count) {
        this.id = id;
        this.chipset = chipset;
        this.gpuFrequency = gpuFrequency;
        this.memory = memory;
        this.type = type;
        this.frequency = frequency;
        this.supports = supports;
        this.powerAuxiliary = powerAuxiliary;
        this.deliveryType = deliveryType;
        this.count = count;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getGpuFrequency() {
        return gpuFrequency;
    }

    public void setGpuFrequency(String gpuFrequency) {
        this.gpuFrequency = gpuFrequency;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSupports() {
        return supports;
    }

    public void setSupports(String supports) {
        this.supports = supports;
    }

    public String getPowerAuxiliary() {
        return powerAuxiliary;
    }

    public void setPowerAuxiliary(String powerAuxiliary) {
        this.powerAuxiliary = powerAuxiliary;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
