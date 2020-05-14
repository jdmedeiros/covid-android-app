package com.example.covid;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "new",
        "active",
        "critical",
        "recovered",
        "total"
})
public class Cases {

    @JsonProperty("new")
    private String _new;
    @JsonProperty("active")
    private int active;
    @JsonProperty("critical")
    private int critical;
    @JsonProperty("recovered")
    private int recovered;
    @JsonProperty("total")
    private int total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Cases() {
    }

    /**
     *
     * @param recovered
     * @param total
     * @param critical
     * @param active
     * @param _new
     */
    public Cases(String _new, int active, int critical, int recovered, int total) {
        super();
        this._new = _new;
        this.active = active;
        this.critical = critical;
        this.recovered = recovered;
        this.total = total;
    }

    @JsonProperty("new")
    public String getNew() {
        return _new;
    }

    @JsonProperty("new")
    public void setNew(String _new) {
        this._new = _new;
    }

    public Cases withNew(String _new) {
        this._new = _new;
        return this;
    }

    @JsonProperty("active")
    public int getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(int active) {
        this.active = active;
    }

    public Cases withActive(int active) {
        this.active = active;
        return this;
    }

    @JsonProperty("critical")
    public int getCritical() {
        return critical;
    }

    @JsonProperty("critical")
    public void setCritical(int critical) {
        this.critical = critical;
    }

    public Cases withCritical(int critical) {
        this.critical = critical;
        return this;
    }

    @JsonProperty("recovered")
    public int getRecovered() {
        return recovered;
    }

    @JsonProperty("recovered")
    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public Cases withRecovered(int recovered) {
        this.recovered = recovered;
        return this;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }

    public Cases withTotal(int total) {
        this.total = total;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Cases withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
