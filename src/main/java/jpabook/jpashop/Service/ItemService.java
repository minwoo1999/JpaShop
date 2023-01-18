package jpabook.jpashop.Service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.Itemrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final Itemrepository itemrepository;

    @Transactional
    public void saveItem(Item item){
        itemrepository.save(item);
    }

    //변경감지기능사용
    //따라서 itemrepository에서 찾아온값에 설정만해준다면 ? 바로 update 가 된다.
    //flush() 를 날려줌
    //set을 까는것보다 의미있는 메소드를 entity에 넣어서 도메인 주도설계를 만들어라
    @Transactional //commit 역할 및 rollback 역할이 됨
    public void updateItem(Long itemId,String name, int price,int stockQuantity){
        Item findItem=itemrepository.findOne(itemId); //itemrepository에서 찾아와서 이미 영속상태
        //findItem.change(name,price,stockQuantity);
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems(){
        return itemrepository.findAll();
    }
    public Item findOne(Long ItemId){
        return itemrepository.findOne(ItemId);
    }




}
