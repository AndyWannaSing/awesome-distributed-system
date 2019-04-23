package awesome.message.consumer.server.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageSink {
    String SMS_MESSAGE_CONSUMER = "sms_message_consumer";

    @Input(SMS_MESSAGE_CONSUMER)
    SubscribableChannel smsMessages();

}
