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
        "country",
        "cases",
        "deaths",
        "tests",
        "day",
        "time"
})
public class Resposta {

    @JsonProperty("country")
    private String country;
    @JsonProperty("cases")
    private Cases cases;
    @JsonProperty("deaths")
    private Deaths deaths;
    @JsonProperty("tests")
    private Tests tests;
    @JsonProperty("day")
    private String day;
    @JsonProperty("time")
    private String time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Resposta() {
    }

    /**
     *
     * @param country
     * @param cases
     * @param tests
     * @param time
     * @param day
     * @param deaths
     */
    public Resposta(String country, Cases cases, Deaths deaths, Tests tests, String day, String time) {
        super();
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.tests = tests;
        this.day = day;
        this.time = time;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Resposta withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("cases")
    public Cases getCases() {
        return cases;
    }

    @JsonProperty("cases")
    public void setCases(Cases cases) {
        this.cases = cases;
    }

    public Resposta withCases(Cases cases) {
        this.cases = cases;
        return this;
    }

    @JsonProperty("deaths")
    public Deaths getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public Resposta withDeaths(Deaths deaths) {
        this.deaths = deaths;
        return this;
    }

    @JsonProperty("tests")
    public Tests getTests() {
        return tests;
    }

    @JsonProperty("tests")
    public void setTests(Tests tests) {
        this.tests = tests;
    }

    public Resposta withTests(Tests tests) {
        this.tests = tests;
        return this;
    }

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    public Resposta withDay(String day) {
        this.day = day;
        return this;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    public Resposta withTime(String time) {
        this.time = time;
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

    public Resposta withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
