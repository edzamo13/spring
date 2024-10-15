package com.example.stream.cloud.config;


import com.example.stream.cloud.model.WordCount;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamConfig {

  @Bean
  public Function<
      KStream<Bytes,String>,
      KStream<Bytes, WordCount>> process(){
    return input -> input
        .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
        .map((key, value) -> new KeyValue<>(value, value))
        .groupByKey(Grouped.with(Serdes.String(), Serdes.String()))
        .windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
        .count(Materialized.as("WordCounts-1"))
        .toStream()
        .map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));


  }

}
