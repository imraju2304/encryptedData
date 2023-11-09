package com.emit.encrypted.data.service;// TimeSeriesService.java

import com.emit.encrypted.data.entity.TimeSeriesEntity;

import java.util.List;

public interface TimeSeriesService {

    void saveToTimeSeries(TimeSeriesEntity timeSeriesEntity);

    List<TimeSeriesEntity> getLatestData();
}
