package awesome.elasticsearch.server.repositories;

import awesome.elasticsearch.server.entities.Computer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ComputerRepository extends ElasticsearchRepository<Computer, Long> {
}
