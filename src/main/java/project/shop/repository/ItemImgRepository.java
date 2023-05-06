package project.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.shop.entity.ItemImg;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);
}
