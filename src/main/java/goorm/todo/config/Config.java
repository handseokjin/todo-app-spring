package goorm.todo.config;


import goorm.todo.repository.mybatis.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final TodoMapper itemMapper; // MyBatis 적용
    private final EntityManager em; // jpa 적용

//    @Bean
//    public ItemService itemService() {
//        return new ItemServiceV1(itemRepository());
//    }
//
//    @Bean
//    public ItemRepository itemRepository() {
//        return new MyBatisItemRepository(itemMapper);
//    }
}