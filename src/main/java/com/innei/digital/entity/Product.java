package com.innei.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EnableAutoConfiguration

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)

    private String code;

    @Column(unique = true)
    private String name;

    private String brand;


    private String pic;


    private Integer num;


    private Long price;


    private Integer status;


    @Column(name = "big_pic")
    private String bigPic;


    private String intro;

    /**
     * @see: https://blog.csdn.net/johnf_nash/article/details/80642581
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id")
    @JsonIgnore
    private Type type;

    @Min(1)
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer typeId;


}

