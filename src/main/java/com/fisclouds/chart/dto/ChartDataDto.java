package com.fisclouds.chart.dto;

import java.util.List;
import java.util.Map;

public record ChartDataDto(List<Map<String, Object>> datasets, Map<String, Object> config, String columns, String chartType ) {

}
