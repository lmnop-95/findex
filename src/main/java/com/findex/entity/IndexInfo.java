package com.findex.entity;

import com.findex.entity.base.BaseEntity;
import com.findex.enums.IndexSourceType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.findex.util.StringUtil.requireNonBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "index_info")
public class IndexInfo extends BaseEntity {

    private String indexClassification;

    private String indexName;

    private Integer employedItemsCount;

    private LocalDate basePointInTime;

    private BigDecimal baseIndex;

    @Enumerated(EnumType.STRING)
    private IndexSourceType sourceType;

    private boolean favorite;

    @OneToOne(
        mappedBy = "indexInfo",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private AutoSyncConfig autoSyncConfig;

    @Builder
    public IndexInfo(
        @NonNull String indexClassification,
        @NonNull String indexName,
        @NonNull Integer employedItemsCount,
        @NonNull LocalDate basePointInTime,
        @NonNull BigDecimal baseIndex,
        @NonNull IndexSourceType sourceType,
        @NonNull Boolean favorite
    ) {
        this.indexClassification = requireNonBlank(indexClassification);
        this.indexName = requireNonBlank(indexName);
        this.employedItemsCount = employedItemsCount;
        this.basePointInTime = basePointInTime;
        this.baseIndex = baseIndex;
        this.sourceType = sourceType;
        this.favorite = favorite;
        this.autoSyncConfig = new AutoSyncConfig(false, this);
    }

    public void update(
        Integer employedItemsCount,
        LocalDate basePointInTime,
        BigDecimal baseIndex,
        Boolean favorite
    ) {
        if (employedItemsCount != null) {
            this.employedItemsCount = employedItemsCount;
        }
        if (basePointInTime != null) {
            this.basePointInTime = basePointInTime;
        }
        if (baseIndex != null) {
            this.baseIndex = baseIndex;
        }
        if (favorite != null) {
            this.favorite = favorite;
        }
    }
}
