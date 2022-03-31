package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室服务器
 */
public class Server {

    /**
     * SererSocket是运行在服务器端的
     *
     * ServerSocket的两个作用:
     * 1.向服务器申请服务端口(这个端口就是下面与客户端建立连接的服务器端口)
     * 2.监听服务端口, 一旦有客户端连接就立即创建一个Socket, 通过这个Socket与客户端交互
     * */
    private ServerSocket serverSocket;

    public Server( ) {
        try {
            //实例化ServerSocket申请一个固定端口用以客户端连接时,被操作系统里其他程序占用了会抛出异常

            System.out.println("正在启动服务器...");
            this.serverSocket =new ServerSocket(8088);
            System.out.println("服务器启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {

           while(true) {
                System.out.println("等待客户端连接");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端已连接");
            }

           /*
            InputStream in=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(in);
            BufferedReader br=new BufferedReader(isr);
            String line;
            //read.Line()是一个阻塞
            while((line=br.readLine()) != null){
                System.out.println("客户端说: " +line);
            }
            */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }

}
