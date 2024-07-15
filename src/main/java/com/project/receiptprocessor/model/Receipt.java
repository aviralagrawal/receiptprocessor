package com.project.receiptprocessor.model;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Receipt {
    private String id;

    @NotNull
    @Pattern(regexp = "^[\\w\\s\\-&]+$")
    private String retailer;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String purchaseDate;

    @NotNull
    @Pattern(regexp = "^\\d{2}:\\d{2}$")
    private String purchaseTime;

    @NotNull
    @Size(min = 1)
    private List<Item> items;

    @NotNull
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String total;

    private int points;

    @Data
    public static class Item {
        @NotNull
        @Pattern(regexp = "^[\\w\\s\\-]+$")
        private String shortDescription;

        @NotNull
        @Pattern(regexp = "^\\d+\\.\\d{2}$")
        private String price;
    }
}
