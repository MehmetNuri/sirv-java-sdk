package com.mehmetnuri.statistic.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mehmetnuri.json.ZonedDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class StorageStatisticItem {
    private Long plan;
    private Long burstable;
    private Long extra;
    private Long used;
    private Long files;
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime quotaExceededDate;
}
