package com.zj.cms.web.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * describe:MQ消费者
 *
 * @author zj
 * @date 2019/01/25
 */
public class DefaultMessageQueueListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMessageQueueListener.class);

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void onMessage(final Message message) {
        // 使用线程池多线程处理
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    LOGGER.info("消费：{}", text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
