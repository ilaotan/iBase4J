package org.ibase4j.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.ibase4j.core.support.ftp.SftpClient;
import org.junit.Test;
import org.junit.runner.RunWith;

@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring-config.xml"})
public class SftpTest {

    @Test
    public void test() {
        SftpClient client = SftpClient.connect();
        client.put("C:/Users/xsit/Desktop/Sticker.zip", "/usr/test123.tet");
        client.disconnect();
    }
}
