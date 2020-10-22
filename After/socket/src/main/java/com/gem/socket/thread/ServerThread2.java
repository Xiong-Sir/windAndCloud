package com.gem.socket.thread;

import com.gem.socket.po.SocketUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author jingmeng4
 * @date 2020/10/22 21:33
 */
public class ServerThread2 extends Thread{
    private SocketUser user;
    private List<SocketUser> list;

    public ServerThread2(SocketUser user, List<SocketUser> list) {
        this.user = user;
        this.list = list;
    }

    public void run() {
        try {
            while (true) {
                // 信息的格式：(add||remove||chat),收件人,...,收件人,发件人,信息体
                //不断地读取客户端发过来的信息
                String msg = user.getBr().readLine();
                System.out.println(msg);
                String[] str = msg.split(",");
                int i=str.length;
                System.out.println(i);
                //转发消息
                switch (str[0]) {
                    case "remove":
                        remove(user);// 移除用户，此处仅仅只是从list中移除用户
                        break;
                    case "chat":
                        // 转发信息给特定的用户，单发或群发
                        for (int a=1;a<=i-3;a++) {
                            sendToClient(str[a], msg);
                        }
                        break;
                    case "add":
                        addUser(user);//添加用户，此处仅仅是list中添加用户
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("消息回复异常");
        } finally {
            try {
                user.getBr().close();
                user.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //在用户列表中添加用户信息
    private void addUser(SocketUser user) {
        list.add(user);
        System.out.println(list);
    }

    //转发消息
    private void sendToClient(String username, String msg) {

        for (SocketUser user : list) {
            if (user.getName().equals(username)) {
                try {
                    PrintWriter pw =user.getPw();
                    pw.println(msg);
                    pw.flush();
                    System.out.println("消息转发成功！");
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从用户列表中删除用户
    private void remove(SocketUser user2) {
        list.remove(user2);
        System.out.println(list);
    }
}
