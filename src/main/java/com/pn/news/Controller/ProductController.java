/*
package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.pn.news.Service.ProductService;
import com.pn.news.model.pojo.Product;
import com.pn.news.utils.R;
import org.springframework.web.bind.annotation.*;

*/
/**
 * 商品控制器
 *//*

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    */
/**
     * 列表
     * @param page
     * @param size       每页显示多少条
     * @param order      排序；0：综合（商品新增时间倒序），默认；10：价格降序，20：价格倒序，
      30：根据id从小到大排序，主要是方便客户端测试加载逻辑是否有问题，判断是否重复数据
     * @param categoryId 分类
     * @return
     *//*

    @GetMapping
    public Object index(@RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int size,
                        @RequestParam(defaultValue = "0") int order,
                        @RequestParam(name = "query", required = false) String query,
                        @RequestParam(name = "category_id", required = false) String categoryId) {

        return R.wrap(service.findAll(page, size, order, query, categoryId));
    }

    */
/**
     * 详情
     *
     * @param id
     * @return
     *//*

    @RequestMapping("/{id}")
    public Object show(@PathVariable("id") String id) {
        Product data = service.findDetail(id);
        ValidatorUtil.checkExist(data);

        return R.wrap(data);
    }

    @PostMapping
    public Object create(@RequestBody Product data) {
        StpUtil.checkLogin();

        data.setUserId(StpUtil.getLoginIdAsString());

        service.create(data);
        return R.wrap(data.getId());
    }

    @PatchMapping("/{id}")
    public Object update(@PathVariable String id, @RequestBody Product data) {
        StpUtil.checkLogin();

        data.setUserId(StpUtil.getLoginIdAsString());
        data.setId(id);

        service.update(data);
        return R.wrap(data.getId());
    }
}
*/
