package tinyxiong.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tinyxiong.angular.mapper.HeroMapper;

@Service
public class HeroService {

    private HeroMapper heroMapper;



    @Autowired
    public void setHeroMapper(HeroMapper heroMapper) {
        this.heroMapper = heroMapper;
    }


}
