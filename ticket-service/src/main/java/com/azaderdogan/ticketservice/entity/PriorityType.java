package com.azaderdogan.ticketservice.entity;

import lombok.Getter;

/**
 * kullanıcı URGENT yerine ona atadığımız labeli görecek,
 * biz kodda URGENT ile  çalışacaz
 * veritabanında ise 0,1,2 ile çalışıyor olacağız
 */
@Getter
public enum PriorityType {

    URGENT("Acil"),
    LOW("Önemsiz"),
    HIGH("Yüksek Öncelikli");

    private String label;

    PriorityType(String label){
        this.label = label;
    }
}
