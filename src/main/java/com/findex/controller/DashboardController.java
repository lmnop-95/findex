package com.findex.controller;

import com.findex.dto.dashboard.IndexChartDto;
import com.findex.dto.dashboard.IndexPerformanceDto;
import com.findex.dto.dashboard.RankedIndexPerformanceDto;
import com.findex.enums.ChartPeriodType;
import com.findex.enums.PeriodType;
import com.findex.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/index-data")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/performance/favorite")
    public ResponseEntity<List<IndexPerformanceDto>> getFavoriteIndexPerformances(
        @RequestParam(defaultValue = "DAILY") PeriodType periodType
    ) {
        List<IndexPerformanceDto> result = dashboardService.getFavoriteIndexPerformances(periodType);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/chart")
    public ResponseEntity<IndexChartDto> getChartData(
        @PathVariable Long id,
        @RequestParam(defaultValue = "MONTHLY") ChartPeriodType periodType
    ) {
        IndexChartDto result = dashboardService.getChartData(id, periodType);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/performance/rank")
    public ResponseEntity<List<RankedIndexPerformanceDto>> getPerformanceRank(
        @RequestParam(required = false) Long indexInfoId,
        @RequestParam(defaultValue = "DAILY") PeriodType periodType,
        @RequestParam(defaultValue = "10") int limit
    ) {
        List<RankedIndexPerformanceDto> result = dashboardService.getPerformanceRank(indexInfoId, periodType, limit);
        return ResponseEntity.ok(result);
    }
}
