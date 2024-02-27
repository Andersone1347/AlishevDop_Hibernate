package ru.alishev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.models.Item;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.ItemRepository;

import javax.transaction.*;
import java.util.List;

@Service
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;
@Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findByItemName(String itemName) {
    return itemRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner) {
    return itemRepository.findByOwner(owner);
    }


}
