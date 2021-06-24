package com.innei.digital.service;

import com.innei.digital.entity.Product;
import com.innei.digital.entity.Type;
import com.innei.digital.repository.ProductRepository;
import com.innei.digital.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    public Page<Product> listProduct(Integer page, Integer size) {
        /**
         * @see: https://github1s.com/khoubyari/spring-boot-rest-example/blob/master/src/main/java/com/khoubyari/example/service/HotelService.java
         */
        var pr = this.productRepository.findAll(PageRequest.of(page, size));
        var types = this.typeRepository.findAll();
        var typeHashMap = new HashMap<Integer,Type>();
        types.forEach(type -> {
            typeHashMap.put(type.getId(), type);
        });
        for (Product product : pr.getContent()) {
//            product.setTypeId(this.typeRepository.findById(product.getType().getId()).get().getId());
            product.setTypeId(typeHashMap.get(product.getType().getId()).getId());
        }
        return pr;

    }

    public Iterable<Product> listAll() {
        return this.productRepository.findAll();
    }


    private Type CheckTypeValid(Product product) {
        var typeId = product.getTypeId();
        if (typeId == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "typeId 不能为空");
        }

        var type = this.typeRepository.findById(typeId);
        if (type.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "type 不存在");
        }

        return type.get();
    }

    public Product createProduct(Product product) {
        var type = this.CheckTypeValid(product);

        try {
            product.setType(type);

            var pr = this.productRepository.save(product);

            var id = pr.getId();

            return this.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "创建失败");
        }
    }


    public Product getById(Integer id) {
        var _pr = this.productRepository.findById(id);
        if (_pr.isEmpty()) {
            return null;
        }
        var pr = _pr.get();

        pr.setTypeId(pr.getType().getId());
//        var t = this.typeRepository.getTypeWithoutProduct(pr.getType().getId());
//        t.setProduct(null);
//        pr.setType(t);
        return pr;
    }

    public boolean updateProduct(Product product) {
        var type = this.CheckTypeValid(product);

        product.setType(type);
        var productId = product.getId();
        var _product = this.getById(productId);
        if (_product == null) {
            return false;
        }

        this.productRepository.save(product);

        return true;

    }


    public boolean deleteProduct(Integer id) {
        var pr = this.productRepository.findById(id);
        if (pr.isEmpty()) {
            return false;
        }

        this.productRepository.delete(pr.get());

        return true;

    }

}
