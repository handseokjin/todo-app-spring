package goorm.todo.config;


import goorm.todo.repository.mybatis.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final TodoMapper itemMapper;

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