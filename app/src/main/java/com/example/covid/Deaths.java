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
        "total"
})
public class Deaths {

    @JsonProperty("new")
    private Object _new;
    @JsonProperty("total")
    private int total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Deaths() {
    }

    /**
     *
     * @param total
     * @param _new
     */
    public Deaths(Object _new, int total) {
        super();
        this._new = _new;
        this.total = total;
    }

    @JsonProperty("new")
    public Object getNew() {
        return _new;
    }

    @JsonProperty("new")
    public void setNew(Object _new) {
        this._new = _new;
    }

    public Deaths withNew(Object _new) {
        this._new = _new;
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

    public Deaths withTotal(int total) {
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

    public Deaths withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
