package com.emit.encrypted.data.repository;

import com.emit.encrypted.data.entity.TimeSeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeSeriesRepository extends JpaRepository<TimeSeriesEntity, Long> {

    @Query("SELECT COUNT(t) FROM TimeSeriesEntity t")
    int getTotalDataCount();
    List<TimeSeriesEntity> findTop10ByOrderByTimestampDesc();
}
