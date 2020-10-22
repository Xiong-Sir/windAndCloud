package com.gem.socket.web;

import com.gem.socket.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingmeng4
 * @date 2020/10/22 21:37
 */
@RestController
@RequestMapping("/test")
public class Controller {

    @Autowired
    SocketServer serverSocket1;

    @GetMapping("/test1")
    public void test1(){
        serverSocket1.ServerSocketDemo();
    }
}
