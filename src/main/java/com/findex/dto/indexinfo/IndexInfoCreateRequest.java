package com.findex.dto.indexinfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record IndexInfoCreateRequest(

    @NotBlank
    String indexClassification,

    @NotBlank
    String indexName,

    @NotNull
    Integer employedItemsCount,

    @NotNull
    LocalDate basePointInTime,

    @NotNull
    BigDecimal baseIndex,

    Boolean favorite
) {}
