package project.shop.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.shop.constant.ItemSellStatus;

import java.time.LocalDateTime;

@Getter @Setter
public class ItemDto {

    private Long id;

    private String itemName;

    private Integer price;

    private String itemDetail;

    private String sellStatCd;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
