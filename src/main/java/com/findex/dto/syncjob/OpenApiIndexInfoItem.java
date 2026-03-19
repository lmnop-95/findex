package com.findex.dto.syncjob;

import java.math.BigDecimal;

public record OpenApiIndexInfoItem(
    String idxCsf,
    String idxNm,
    Integer epyItmsCnt,
    String basPntm,
    BigDecimal basIdx
) {}
