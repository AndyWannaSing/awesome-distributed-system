package awesome.message.producer.server.controller;

import awesome.message.producer.server.bean.SmsMessage;
import awesome.message.producer.server.source.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Andy
 * @time: 2019/4/20 19:23
 * @since
 */
@RestController
@EnableBinding(MessageSource.class)
public class SmsController {

    @Autowired
    private MessageSource messageSource;

    /**
     * 发送短信消息
     *
     *
     * @param message
     * @return: {@link ResponseEntity<?> }
     * @author: Andy
     * @time: 2019/4/20 20:35
     * @since
     */
    @PostMapping("/api/message/sms_message")
    public ResponseEntity<?> sendSmsMessage(@RequestBody SmsMessage message){
        try {
            messageSource.smsMessage().send(MessageBuilder.withPayload(message).build());
        } catch (Exception e) {
            //todo: do something
            e.printStackTrace();
            return new ResponseEntity<>("消息 SMS 发送失败！", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("消息 SMS 发送成功！", HttpStatus.OK);
    }


}
