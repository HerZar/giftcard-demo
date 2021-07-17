package com.libraapps.giftcard.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiftCardDto {

    private Integer discount;
    private Integer minValue;
    private Integer maxValue;
    private Integer value;

    public void addValue(Integer num){
        this.value = this.value+num;
    }

    public void subtractValue(Integer num){
        this.value = this.value-num;
    }

}
