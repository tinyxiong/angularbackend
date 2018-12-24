package tinyxiong.angular.controller.dto;

import lombok.Data;
import tinyxiong.angular.domain.Hero;

@Data
public class HeroDto {

    private int id;
    private String name;

    public static HeroDto from(Hero hero) {
        HeroDto heroDto= newOne();
        heroDto.setId(hero.getId());
        heroDto.setName(hero.getName());
        return heroDto;
    }

    public static HeroDto newOne() {
        return new HeroDto();
    }
}
