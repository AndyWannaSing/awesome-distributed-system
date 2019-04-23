package awesome.message.consumer.server.consumer;

import awesome.message.consumer.server.bean.SmsMessage;
import awesome.message.consumer.server.sink.MessageSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @author: Andy
 * @time: 2019/4/20 20:39
 * @since
 */
@EnableBinding(MessageSink.class)
public class SmsConsumer {

    @StreamListener(MessageSink.SMS_MESSAGE_CONSUMER)
    public void consumeSmsMessage(Message<SmsMessage> message){
        System.out.println(String.format("Consumes message:[%s] ", message.getPayload().getContent()));
    }

}
