package com.home.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class TestMapperTest {
    @Autowired
    TestMapper testMapper;

    @Test
    void test01() {
        ADto a = new ADto();
        a.setName("테스트");

        BDto b = testMapper.toB(a);

        assertEquals("테스트", b.getName());
    }
}
