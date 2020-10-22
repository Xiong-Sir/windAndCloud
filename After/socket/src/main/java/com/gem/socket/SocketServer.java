package com.gem.socket;

import com.gem.socket.po.SocketUser;
import com.gem.socket.thread.ServerThread2;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jingmeng4
 * @date 2020/10/22 21:24
 */
@Repository
public class SocketServer {

    private ServerSocket serverSocket;

    public void ServerSocketDemo(){
        int count=0;
        try{
            //存放 连接上服务器的用户 列表
            List<SocketUser> list = new ArrayList<SocketUser>();
            serverSocket=new ServerSocket(5555);//开启服务的端口，需和客户端一致
            System.out.println("服务端已经启动，等待客户端连接");
            while (true){
                Socket socket=serverSocket.accept();
                count++;
                SocketUser user = new SocketUser("user" + count,socket);
                System.out.println(user.getName() + "正在登录。。。");
                list.add(user);//把新增的用户添加到list里面
                System.out.println(list);
                System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
                new ServerThread2(user,list).start();//开启输入和输出的多线程
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
