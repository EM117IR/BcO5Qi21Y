// 代码生成时间: 2025-09-16 20:51:49
package com.example.dataanalyzer;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * DataAnalyzer class to analyze data statistics.
 */
@Introspected
public class DataAnalyzer {

    /**
     * Analyze the given data list and calculate statistics.
     *
     * @param dataList The list of data to be analyzed.
     * @return A list of statistics for the data.
     */
    public List<Statistic> analyzeData(List<@NotNull Number> dataList) {
        // Check for null input
        if (dataList == null || dataList.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be null or empty");
        }

        // Calculate statistics
        double sum = dataList.stream().mapToDouble(Number::doubleValue).sum();
        double average = dataList.stream().mapToDouble(Number::doubleValue).average().orElse(0);
        double max = dataList.stream().max(Double::compare).map(Number::doubleValue).orElse(0);
        double min = dataList.stream().min(Double::compare).map(Number::doubleValue).orElse(0);

        // Create a list of statistics
        List<Statistic> statistics = new ArrayList<>();
        statistics.add(new Statistic("Sum", sum));
        statistics.add(new Statistic("Average", average));
        statistics.add(new Statistic("Max", max));
        statistics.add(new Statistic("Min", min));

        return statistics;
    }
}

/**
 * Statistic class to hold a name-value pair of statistics.
 */
@Introspected
class Statistic {
    private String name;
    private double value;

    public Statistic(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Statistic{"name":"" + name + "","value": " + value + "}";
    }
}