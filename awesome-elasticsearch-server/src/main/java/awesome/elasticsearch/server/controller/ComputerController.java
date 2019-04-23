package awesome.elasticsearch.server.controller;

import awesome.elasticsearch.server.entities.Computer;
import awesome.elasticsearch.server.serveice.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Andy
 * @time: 2019/4/22 18:04
 * @since
 */
@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/api/product/computers")
    public ResponseEntity<?> findComputers(@RequestParam(value = "name", required = false) String name,
                                                        @RequestParam(value = "brand", required = false) String brand,
                                                        @RequestParam(value = "startTime", required = false) Date startTime,
                                                        @RequestParam(value = "lowerPrice", required = false) Long lowerPrice,
                                                        @RequestParam(value = "upperPrice", required = false) Long upperPrice,
                                                        @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", required = false, defaultValue = "20") Integer size){
        try {
            Page<Computer> computerPage = computerService.findComputers(name, brand, startTime, lowerPrice, upperPrice, page, size);
            Map<String, Object> resultMap  = new HashMap<>();
            List<Computer> computerList = computerPage.get().collect(Collectors.toList());
            resultMap.put("computers", computerList);
            resultMap.put("total", computerPage.getTotalElements());
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            //todo : do something
            e.printStackTrace();
            return new ResponseEntity<>("搜索失败！", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
