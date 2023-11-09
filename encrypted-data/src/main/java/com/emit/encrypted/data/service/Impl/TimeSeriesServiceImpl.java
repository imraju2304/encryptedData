package com.emit.encrypted.data.service.Impl;// TimeSeriesServiceImpl.java

import com.emit.encrypted.data.entity.TimeSeriesEntity;
import com.emit.encrypted.data.repository.TimeSeriesRepository;
import com.emit.encrypted.data.service.TimeSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSeriesServiceImpl implements TimeSeriesService {

    @Autowired
    private TimeSeriesRepository timeSeriesRepository;

    @Override
    public void saveToTimeSeries(TimeSeriesEntity timeSeriesEntity) {
        timeSeriesRepository.save(timeSeriesEntity);
    }

    @Override
    public List<TimeSeriesEntity> getLatestData() {
        // Implement logic to retrieve the latest data from the repository
        // For example, you can return the last 10 records
        return timeSeriesRepository.findTop10ByOrderByTimestampDesc();
    }
}
