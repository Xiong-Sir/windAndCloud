package com.gem.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author jingmeng4
 * @date 2020/10/23 13:54
 */
public class TcpRevice {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(7878);

        Socket client = ss.accept();//接收，建立跟发送端的链接
        System.out.println("接收到一个客户端的链接");
        //new Socket("192.168.0.107", 7878);这个的时候，会发送跟接受端建立连接的请求

        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream();

        Thread t = new Thread() {
            public void run() {
                Scanner scanner = new Scanner(System.in);

                while(true) {
                    if(client.isClosed())break;

                    String str = scanner.nextLine();
                    if(str.equals("end"))break;

                    try {
                        output.write(str.getBytes());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();

        byte[] buf = new byte[1024];
//		while(true) {
//			int length = input.read(buf);
//			System.out.println(length);
//			System.out.println(new String(buf,0,length));
//		}
        int length = -1;
        while( (length = input.read(buf))!=-1 ) {
            System.out.println(new String(buf,0,length));
        }

        client.close();
        ss.close();

    }
}
