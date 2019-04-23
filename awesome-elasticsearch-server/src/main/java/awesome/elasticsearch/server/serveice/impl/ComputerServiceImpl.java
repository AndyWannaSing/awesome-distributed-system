package awesome.elasticsearch.server.serveice.impl;

import awesome.elasticsearch.server.entities.Computer;
import awesome.elasticsearch.server.repositories.ComputerRepository;
import awesome.elasticsearch.server.serveice.ComputerService;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.AliasQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: Andy
 * @time: 2019/4/22 15:55
 * @since
 */
@Service
public class ComputerServiceImpl implements ComputerService {


    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public Page<Computer> findComputers(String name, String brand, Date startTime, Long lowerPrice, Long upperPrice, Integer page, Integer size) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        //分词匹配
        if (StringUtils.isNotBlank(name)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", name));
        }

        //短语匹配
        if (StringUtils.isNotBlank(brand)) {
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("brand", brand));
        }

        //范围匹配
        if (startTime != null) {
            boolQueryBuilder.must(QueryBuilders.rangeQuery("to_market_time").gte(startTime));
        }
        if(lowerPrice != null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(lowerPrice));
        }
        if(upperPrice != null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").lte(upperPrice));
        }

        //按照时间降序排列
        SortBuilder sortBuilder = SortBuilders.fieldSort("to_market_time").order(SortOrder.DESC);

        //分页
        PageRequest pageRequest = PageRequest.of(page, size);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(boolQueryBuilder)
                .withSort(sortBuilder)
                .withPageable(pageRequest)
                .build();

        return computerRepository.search(searchQuery);
    }
}
