package com.gem.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author jingmeng4
 * @date 2020/10/22 21:35
 */

public class ClientThread extends Thread{
    private Socket socket;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            try {
                // 信息的格式：(add||remove||chat),发送人,收发人,信息体
                while (true) {
                    String msg=br.readLine();
                    System.out.println(msg);
                    String[] str = msg.split(",");
                    int i=str.length;
                    switch (str[0]) {
                        case "chat":
                            System.out.println(str[i-2] + " 说: "
                                    + str[i-1]);
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
