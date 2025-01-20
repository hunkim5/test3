package com.airpremia.eosh.common.query;

import java.util.Optional;

public class QueryService {
    public String formatLikeOperator(String field) {
        return Optional.ofNullable(field)
            .filter(f -> !f.isEmpty())
            .map(f -> "%" + f + "%")
            .orElse(field);
    }
}
