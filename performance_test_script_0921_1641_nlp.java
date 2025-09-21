// 代码生成时间: 2025-09-21 16:41:29
package com.example.performancetest;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 性能测试脚本
 */
@Singleton
public class PerformanceTestScript {

    // 定义HTTP客户端，用于发送请求
    @Client("/")
    private HttpClient httpClient;

    // 定义线程池，用于并发执行性能测试
    private final ExecutorService executorService;

    // 构造函数，初始化线程池
    public PerformanceTestScript() {
        // 使用固定大小的线程池
        this.executorService = Executors.newFixedThreadPool(10);
    }

    /**
     * 执行性能测试
     *
     * @param url 测试的URL
     * @param requests 需要发送的请求总数
     * @param duration 测试的持续时间（秒）
     */
    public void executePerformanceTest(String url, int requests, int duration) {
        // 保存请求结果
        ConcurrentHashMap<Integer, Long> results = new ConcurrentHashMap<>();

        try {
            // 开始性能测试
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < requests; i++) {
                // 提交任务到线程池
                executorService.submit(() -> {
                    try {
                        // 发送HTTP请求
                        HttpRequest request = HttpRequest.GET(url);
                        long startTimeRequest = System.currentTimeMillis();
                        httpClient.toBlocking().exchange(request);
                        long endTimeRequest = System.currentTimeMillis();

                        // 记录请求结果
                        results.put(i, endTimeRequest - startTimeRequest);
                    } catch (Exception e) {
                        // 处理请求异常
                        e.printStackTrace();
                    }
                });
            }

            // 等待所有请求完成
            executorService.shutdown();
            executorService.awaitTermination(duration, TimeUnit.SECONDS);

            // 输出性能测试结果
            System.out.println("性能测试结果：");
            results.forEach((key, value) -> {
                System.out.println("请求 