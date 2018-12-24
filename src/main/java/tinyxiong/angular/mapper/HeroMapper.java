package tinyxiong.angular.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tinyxiong.angular.domain.Hero;

import java.util.List;

@Mapper
@Repository
public interface HeroMapper {

    List<Hero> selectHeroes();

    Hero selectHeroById(int id);
}
