package tinyxiong.angular.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tinyxiong.angular.domain.Hero;
import tinyxiong.base.BaseServiceTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Angular turtorial中的Hero测试")
class HeroMapperTest extends BaseServiceTest {

    @Autowired
    private HeroMapper heroMapper;

    @Test
    @DisplayName("获取Hero列表")
    void selectHeroes() {
        List<Hero> heroes = heroMapper.selectHeroes();
        assertEquals(10, heroes.size());
        assertAll(
                () -> {
                    assertEquals("Mr. Nice", heroes.get(0).getName());
                    assertEquals(11, heroes.get(0).getId());
                },
                () -> {
                    assertEquals("Narco", heroes.get(1).getName());
                    assertEquals(12, heroes.get(1).getId());
                });
    }

    @Test
    @DisplayName("根据id获取Hero")
    void selectHeroById() {
        Hero hero = heroMapper.selectHeroById(13);
        assertNotNull(hero, "hero is null.");
        assertEquals(13, hero.getId());
        assertEquals("Bombasto", hero.getName());
    }

    @Test
    @DisplayName("测试不存在的Hero")
    void selectNoneHero() {
        Hero hero = heroMapper.selectHeroById(-1);
        assertThrows(NullPointerException.class, () -> hero.getId(), "id为负数的Hero肯定是不存在的!");
    }
}