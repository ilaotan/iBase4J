package org.ibase4j.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.ibase4j.core.support.mq.QueueSender;
import org.ibase4j.core.support.mq.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;

@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring-config.xml"})
public class MQTest {
    @Autowired
    private QueueSender queueSender;

    @Autowired
    private TopicSender topicSender;

    @Test
    public void test() {
        queueSender.send("iBase4J.queue", "test");
        topicSender.send("iBase4J.topic", "test");
    }
}
