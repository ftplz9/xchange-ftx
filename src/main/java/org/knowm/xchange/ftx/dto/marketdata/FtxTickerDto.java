package org.knowm.xchange.ftx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FtxTickerDto {

    @JsonProperty("close")
    public Float close;
    @JsonProperty("high")
    public Float high;
    @JsonProperty("low")
    public Float low;
    @JsonProperty("open")
    public Float open;
    @JsonProperty("startTime")
    public Date startTime;
    @JsonProperty("volume")
    public Float volume;

}
