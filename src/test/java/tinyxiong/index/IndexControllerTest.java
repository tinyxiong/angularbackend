package tinyxiong.index;

import org.junit.experimental.results.ResultMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import tinyxiong.base.BaseControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("IndexControlelr测试")
class IndexControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("主页测试")
    void home() throws Exception {
        mockMvc.perform(get("/resource"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}