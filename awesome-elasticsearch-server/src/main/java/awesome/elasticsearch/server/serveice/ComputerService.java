package awesome.elasticsearch.server.serveice;

import awesome.elasticsearch.server.entities.Computer;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ComputerService {

    /**
     * 查询符合条件的电脑列表
     *
     *
     * @param name 名称
     * @param brand 品牌
     * @param startTime 上市时间
     * @param lowerPrice 最低价
     * @param upperPrice 最高价
     * @param page 页码
     * @param size 页大小
     * @return: {@link Page<Computer> }
     * @author: Andy
     * @time: 2019/4/22 16:04
     * @since
     */
    Page<Computer> findComputers(String name, String brand, Date startTime, Long lowerPrice, Long upperPrice, Integer page, Integer size);
}
