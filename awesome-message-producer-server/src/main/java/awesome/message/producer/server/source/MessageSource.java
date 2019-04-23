package awesome.message.producer.server.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author: Andy
 * @time: 2019/4/20 19:53
 * @since
 */
public interface MessageSource {

    String SMS_MESSAGE_PRODUCER = "sms_message_producer";

    @Output(SMS_MESSAGE_PRODUCER)
    MessageChannel smsMessage();

}
