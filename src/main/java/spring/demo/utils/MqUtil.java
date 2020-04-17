package spring.demo.utils;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * @Package: spring.demo.utils
 * @ClassName: MqUtil
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/30 16:34
 * @UpdateDate: 2019/8/30 16:34
 */
public class MqUtil {

    /**
     * 错误消息
     *
     * @param message
     * @param channel
     * @throws IOException
     */
    public static void dealFailMq(Message message, Channel channel, Object objMessage) {
//        saveFailMq(message, objMessage); 可以保存到redis后面重试发送
        try {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 存储错误信息到redis
     *      后边再定时任务去读取Redis中的信息，二次发送
     * @param message
     * @param objMessage
     */
//    public static void saveFailMq(Message message, Object objMessage) {
//        if (objMessage == null) {
//            objMessage = message;
//        }
//        String jsonObj = JSON.toJSONString(objMessage);
//
//        Map<String, Object> map = new HashMap<>();
//        String messageId = message.getMessageProperties().getMessageId();
//        if (messageId == null) {
//            messageId = MqUtil.createRandString();
//        }
//        map.put("exchangeName", message.getMessageProperties().getReceivedExchange());
//        map.put("routingKey", message.getMessageProperties().getReceivedRoutingKey());
//        map.put("createTime", System.currentTimeMillis());
//        map.put("className", objMessage.getClass());
//        map.put("jsonObj", jsonObj);
//
//        RedisUtils.hSet(MQ_FAIL_LIST, messageId, JSON.toJSONString(map));
//    }

    /**
     * 已消费消息放入redis，并手动确认消息
     *
     * @param message
     * @param channel
     * @param saveRedis 是否将消息id存入redis（用于消息去重）；true表示需要去重，false表示不需要去重
     * @throws IOException
     */
    public static void messageSuccess(Message message, Channel channel, boolean saveRedis) {
        String messageId = message.getMessageProperties().getMessageId();
//        if (saveRedis && messageId != null) {
//            RedisUtils.set(messageId, 1, 1, TimeUnit.DAYS); // 放1天过期
//        }
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
