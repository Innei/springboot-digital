package com.innei.digital.service;

import com.innei.digital.entity.Type;
import com.innei.digital.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;


    public Page<Type> listType(Integer page, Integer size) {
        /**
         * @see: https://github1s.com/khoubyari/spring-boot-rest-example/blob/master/src/main/java/com/khoubyari/example/service/HotelService.java
         */
        return this.typeRepository.findAll(PageRequest.of(page, size));

    }

    public Iterable<Type> listAll() {
        return this.typeRepository.findAll();
    }

    public Type createType(Type type) {
        try {
            return this.typeRepository.save(type);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "创建失败");
        }
    }


    public Optional<Type> getById(Integer id) {
        return this.typeRepository.findById(id);
    }

//    public Type getByIdWithoutProduct(Integer id) {
//        return this.typeRepository.getTypeWithoutProduct(id);
//    }

    public boolean updateType(Type type) {
        var productId = type.getId();
        var _product = this.getById(productId);
        if (_product.isEmpty()) {
            return false;
        }

        this.typeRepository.save(type);

        return true;

    }


    public boolean deleteType(Integer id) {
        var pr = this.typeRepository.findById(id);
        if (pr.isEmpty()) {
            return false;
        }

        this.typeRepository.delete(pr.get());

        return true;

    }
}
