package com.innei.digital.controller;

import com.innei.digital.entity.Product;
import com.innei.digital.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/products")
@Api(tags = "Product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Product> getProducts(
            @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size) {
        return this.productService.listProduct(page, size);
    }


    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return this.productService.getById(id);

    }

    @PostMapping(path = "")
    public Product createProduct(@RequestBody @Valid Product product) {
        return this.productService.createProduct(product);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody @Valid Product product, @PathVariable("id") Integer id) {
        var _id = product.getId();
        if (_id == null) {
            product.setId(id);
        }
        var res = this.productService.updateProduct(product);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "修改失败");
        }

    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        var res = this.productService.deleteProduct(id);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "删除失败");
        }

    }
}
