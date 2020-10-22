package com.gem.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author jingmeng4
 * @date 2020/10/22 20:46
 */
public class Client {
    public static void main(String [] args)
    {
        String serverName = "127.0.0.1";
        int port = Integer.parseInt("999");
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号1111122221：" + port);
            Socket client = new Socket(serverName, port);

            //输出服务器信息
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

            //给服务器发送消息
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //接收服务器响应
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
