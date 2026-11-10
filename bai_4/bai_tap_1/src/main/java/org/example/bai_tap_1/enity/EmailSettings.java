package org.example.bai_tap_1.enity;

public class EmailSettings {
    private String languageId;
    private Integer pageSize;
    private Boolean spamFilter;
    private String signature;

    public EmailSettings() {
    }

    public EmailSettings(String languageId, Integer pageSize, Boolean spamFilter, String signature) {
        this.languageId = languageId;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(Boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
