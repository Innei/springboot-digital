package com.innei.digital.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EnableAutoConfiguration
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(name = "username", unique = true)
    private String username;

    /**
     *
     * @see: https://stackoverflow.com/questions/1281952/what-is-the-easiest-way-to-ignore-a-jpa-field-during-persistence/41850392#41850392
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @Column(name = "real_name")
    private String realName;
    private String gender;
    private String address;
    private String question;
    private String answer;
    @NotBlank
    private String email;
    private String favourite;
    private Integer score;
    @Column(name = "created_at")
    private Date createdAt;
    private Integer status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String token;

}
