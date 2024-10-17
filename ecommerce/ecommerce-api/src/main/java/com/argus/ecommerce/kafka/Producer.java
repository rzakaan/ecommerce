package com.argus.ecommerce.kafka;

import java.util.Properties;

import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
    private Properties props;
    private KafkaProducer producer;
    private boolean isAvailable;

    public Producer() {
        isAvailable = false;
        init();
    }

    public void init() {
        props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(props);
        isAvailable = true;
    }

    public void sendMessage(String message) {
        if (!isAvailable)
            return;

        ProducerRecord record = new ProducerRecord("channel", "key", message);
        producer.send(record);
    }

    public void close() {
        if (!isAvailable)
            return;

        producer.close();
        isAvailable = false;
    }
}
