package com.gem.socket.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author jingmeng4
 * @date 2020/10/23 13:53
 */
public class TcpSend {
    public static void main(String[] args) throws Exception {
        //Socket
        //TCP需要建立连接
        Socket s = new Socket("127.0.0.1", 7878);//建立跟指定ip port建立连接


        InputStream input = s.getInputStream();
        OutputStream output = s.getOutputStream();

        new Thread() {
            public void run() {
                int length = -1;
                byte[] buf = new byte[1024];
                try {
                    while(true) {
                        if(s.isClosed())break;
                        length = input.read(buf);
                        if(length==-1)break;
                        System.out.println(new String(buf,0,length));
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();



        Scanner scanner = new Scanner(System.in);

        while(true) {
            String str = scanner.nextLine();
            if(str.equals("end"))break;

            output.write(str.getBytes());
        }
        s.close();
    }
}
