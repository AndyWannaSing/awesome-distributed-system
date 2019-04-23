package awesome.elasticsearch.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author: Andy
 * @time: 2019/4/22 15:43
 * @since
 */
@Document( indexName = "computer" , type = "doc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Computer {
    @Id
    private Long id;
    private String name;
    private String brand;
    private Long price;

    @JsonProperty("to_market_time")
    private Date toMarketTime;

    @JsonProperty("create_time")
    private Date createTime;

    @JsonProperty("update_time")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getToMarketTime() {
        return toMarketTime;
    }

    public void setToMarketTime(Date toMarketTime) {
        this.toMarketTime = toMarketTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
