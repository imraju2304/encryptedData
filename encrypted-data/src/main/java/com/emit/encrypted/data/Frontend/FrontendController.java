package com.emit.encrypted.data.Frontend;// FrontendController.java

import com.emit.encrypted.data.entity.TimeSeriesEntity;
import com.emit.encrypted.data.repository.TimeSeriesRepository;
import com.emit.encrypted.data.service.TimeSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontendController {

    @Autowired
    private TimeSeriesService timeSeriesService;

    @Autowired
    private TimeSeriesRepository timeSeriesRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<TimeSeriesEntity> dataList = timeSeriesService.getLatestData();
        int totalDataCount = timeSeriesRepository.getTotalDataCount();
        int successRate = calculateSuccessRate(dataList.size(), totalDataCount);

        model.addAttribute("dataList", dataList);
        model.addAttribute("successRate", successRate);

        return "index";
    }

    private int calculateSuccessRate(int validDataCount, int totalDataCount) {
        if (totalDataCount == 0) {
            return 0;
        }
        return (validDataCount * 100) / totalDataCount;
    }
}
