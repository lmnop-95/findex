package com.findex.dto.dashboard;

public record RankedIndexPerformanceDto(
    IndexPerformanceDto performance,
    int rank
) {}
