package ru.vood.kafkatracer.request.meta.cache

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.listener.MessageListener
import org.springframework.stereotype.Service
import ru.vood.kafkatracer.appProps.TopicProp
import ru.vood.kafkatracer.request.meta.cache.dto.KafkaData


class KafkaMessageListener(val topic: TopicProp,) : MessageListener<String, String> {
    private val logger: Logger = LoggerFactory.getLogger(KafkaMessageListener::class.java)


    override fun onMessage(data: ConsumerRecord<String, String>) {
        val key = data.key()
        val headers = data.headers().toArray()
        val timestamp = data.timestamp()
        val value: String = data.value()
        val pip = data.topic()

       if(value.contains(topic.findStr)){
            logger.info("kafka key $key, value $value")
        }

//        KafkaData(key, headers, timestamp, value, pip)



    }
}