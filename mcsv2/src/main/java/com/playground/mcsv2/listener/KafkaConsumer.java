package com.playground.mcsv2.listener;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @Autowired
    private Tracer tracer;

    @KafkaListener(topics = "mcsv", groupId = "911")
    public void consume(String message) {
        log.info("from Kafka: [{}]", message);
        log.warn("---------");
        printTrace();
        log.warn("---------");
    }


    private void printTrace () {
        String traceId = tracer.currentSpan().context().traceIdString();
        String spanId = tracer.currentSpan().context().spanIdString();
        log.info("--- Tracer ---  traceId: {} & spanId: {}", traceId, spanId);
    }
}
