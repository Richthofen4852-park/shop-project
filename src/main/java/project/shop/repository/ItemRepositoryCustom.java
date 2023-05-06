package project.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.shop.dto.ItemSearchDto;
import project.shop.dto.MainItemDto;
import project.shop.entity.Item;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
