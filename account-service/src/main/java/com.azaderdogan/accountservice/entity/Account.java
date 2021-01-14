package com.azaderdogan.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * parametre vermezsek java referance ile iki nesneyi karşılatırırır.
 * com.azaderdogan.account@23ABCD falan. toString ile bunu ezdik.
 * 2. olarak dedikki referansa göre değil idlere göre kontrol et eşitse aynılar
 *
 */
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

  //  @Column(value = "uname")//bu tarz değerleri biz belirlersek daha sağlıklı olur. (eşleşme konusu db)
    private String username;


    private String email;


    private String passwd;


    private String  createdAt;

    @Column(value = "is_active")
    private Boolean active;

}
