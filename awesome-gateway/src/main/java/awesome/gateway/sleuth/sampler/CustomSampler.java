package awesome.gateway.sleuth.sampler;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Andy
 * @time: 2019/4/19 22:00
 * @since
 */
@Configuration
public class CustomSampler {
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
