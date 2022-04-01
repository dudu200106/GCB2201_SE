package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 聊天室服务端_多线程
 */
public class Server_Thread {
    /**
     * java.net.ServerSocket
     * ServerSocket是运行在服务端上的。其主要有两个作用
     * 1:向服务端申请服务端口(客户端Socket就是通过这个端口与服务端建立连接的)
     * 2:监听服务端口，一旦客户端连接会立即常见一个Socket，通过该Socket与客户端交互
     *
     * 如果我们将Socket比喻为"电话"，那么ServerSocket相当于"总机"
     */
    private ServerSocket serverSocket;

    /*构造方法*/
    public Server_Thread() {
        try {

            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        while(true) {
            try {
                System.out.println("等待客户端连接");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端已连接");
                MySocketTask ms= new MySocketTask(socket);
                Thread t =new Thread(ms);
                t.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Server_Thread server = new Server_Thread();
        server.start();
    }

}

class MySocketTask implements Runnable{
    private Socket socket;

    public MySocketTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //通过socket获取输入流读取对方发送过来的消息
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("客户端说:" + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
