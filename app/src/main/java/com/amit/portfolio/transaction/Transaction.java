package com.amit.portfolio.transaction;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Transaction {
    private int id;
    private String instrument;
    private String type;
    private String isin;
    private String units;
    private String priceDate;
    private String price;
    private String mv;

}
