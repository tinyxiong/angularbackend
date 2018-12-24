package tinyxiong.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tinyxiong.angular.controller.dto.HeroDto;
import tinyxiong.angular.mapper.HeroMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hero")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {

    private HeroMapper heroMapper;

    @GetMapping("/list")
    public List<HeroDto> getHeroes() {
        return heroMapper.selectHeroes().stream()
                .map(HeroDto::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/get")
    public HeroDto getHero(int id) {
        return HeroDto.from(heroMapper.selectHeroById(id));
    }

    @Autowired
    public void setHeroMapper(HeroMapper heroMapper) {
        this.heroMapper = heroMapper;
    }


}
