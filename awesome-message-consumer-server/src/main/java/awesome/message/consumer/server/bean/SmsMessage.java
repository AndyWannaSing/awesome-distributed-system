package awesome.message.consumer.server.bean;

import java.io.Serializable;

/**
 * 短信消息
 *
 *
 * @author: Andy
 * @time: 2019/4/20 19:25
 * @since
 */
public class SmsMessage implements Serializable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new StringBuilder("SmsMessage[")
                .append("content").append(content)
                .append("]").toString();
    }
}
