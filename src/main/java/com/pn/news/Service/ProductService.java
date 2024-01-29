/*
package com.pn.news.Service;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pn.news.Mapper.ProductMapper;
import com.pn.news.model.pojo.Product;
import com.pn.news.model.pojo.Spec;
import com.pn.news.model.pojo.Stock;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static Logger log = LoggerFactory.getLogger(ProductService.class);

    private ProductMapper mapper;

    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Cacheable(value = "v1/products_list", key = "T(.concat(#page).concat(#size).concat(#order).concat(#query == null ? 'q' : #query).concat(#categoryId == null ? 'c' : #categoryId)")
    public Page<Product> findAll(int page, int size, int order, String query, String categoryId) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(categoryId)) {
//            queryWrapper.eq()
        }

        //排序
        if (10 == order) {
            queryWrapper.orderByDesc(Product::getPrice);
        } else if (20 == order) {
            queryWrapper.orderByAsc(Product::getPrice);
        } else if (30 == order) {
            queryWrapper.orderByAsc(Product::getId);
        } else {
            queryWrapper.orderByDesc(Product::getCreatedAt);
        }

        if (StringUtils.isNotBlank(query)) {
            queryWrapper.like(Product::getTitle, query);
        }

        return mapper.selectPage(new Page<>(page, size), queryWrapper);
    }

    @Cacheable(value = "v1/products_detail", key = "T(com.ixuea.course.news.util.Constant).CACHE_KEY_V1_PRODUCT_DETAIL.concat(#data)")
    public Product findDetail(String data) {
        log.info("product detail {}", data);
        Product r = mapper.selectById(data);

        if (r != null && r.getStock() != null) {
            List<Stock> stocks = JSONUtil.parse(r.getStock(), new TypeReference<List<Stock>>() {
            });
            r.setStocks(stocks);

            List<Spec> specs = JSONUtil.parse(r.getSpec(), new TypeReference<List<Spec>>() {
            });
            r.setSpecs(specs);
        }

        return r;
    }

    public Product find(String data) {
        return mapper.selectById(data);
    }

    public Stock findSKU(Cart data) {
        Product r = findDetail(data.getProductId());

        if (r.getStocks() != null) {
            for (Stock i : r.getStocks()
            ) {
                if (i.getId().equals(data.getStockId())) {
                    return i;
                }
            }
        }
        return null;
    }

    @CacheEvict(value = "v1/products_list", key = "T(com.ixuea.course.news.util.Constant).CACHE_KEY_V1_PRODUCT_LIST", allEntries = true)
    public void create(Product data) {
        mapper.insert(data);
    }

    @Caching(evict = {
            //清除列表缓存
            @CacheEvict(value = "v1/products_list", key = "T(com.ixuea.course.news.util.Constant).CACHE_KEY_V1_PRODUCT_LIST", allEntries = true),

            //清除对应详情缓存
            @CacheEvict(value = "v1/products_detail", key = "T(com.ixuea.course.news.util.Constant).CACHE_KEY_V1_PRODUCT_DETAIL.concat(#data.id)")
    })
    public void update(Product data) {
        mapper.updateById(data);
    }


    public Page<Product> findAll(PageRequest data) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(data.getKeyWord()), "title", data.getKeyWord())
                .or()
                .like(StringUtils.isNotBlank(data.getKeyWord()), "highlight", data.getKeyWord())
                .or()
                .like(StringUtils.isNotBlank(data.getKeyWord()), "detail", data.getKeyWord());

        return mapper.selectPage(new Page<>(data.getPage(), data.getSize()), wrapper);
    }

    public void batchDelete(List<String> ids) {
        mapper.deleteBatchIds(ids);
    }

}
*/
