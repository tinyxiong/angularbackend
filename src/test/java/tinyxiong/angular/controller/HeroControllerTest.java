package tinyxiong.angular.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tinyxiong.base.BaseControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("测试Hero的rest接口")
class HeroControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("获取列表")
    //tiny todo 数组中的内容怎么使用jsonpath
    void getHeroes() throws Exception {
        mockMvc.perform(get("/hero/list")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("").value(""));
    }

    @Test
    @DisplayName("获取一个Hero")
    void getHero() throws Exception {
        mockMvc.perform(get("/hero/get").param("id", "11")).andDo(print())
                .andExpect(status().isOk())
                .andExpect((jsonPath("$.name").value("Mr. Nice")));
    }
}