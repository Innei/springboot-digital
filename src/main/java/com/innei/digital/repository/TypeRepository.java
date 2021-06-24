package com.innei.digital.repository;

import com.innei.digital.entity.Product;
import com.innei.digital.entity.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TypeRepository extends PagingAndSortingRepository<Type, Integer> {
//    @Query(value = "select id,name from Type t where t.id=?1", nativeQuery = true)
//    public Type getTypeWithoutProduct(Integer id);
}
