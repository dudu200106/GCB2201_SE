package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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
    private String host;
    //正好将ClientHandle是内部类, 可以访问外部类的成员变量
    private HashMap<String,PrintWriter> map =new HashMap<>();
    int count=1;

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
//                System.out.println("等待客户端连接");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端["+ socket.getInetAddress().getHostAddress()+"]已连接 " );

                //启动一个线程处理该客户端的处理
                ClientHandle clientHandle =new ClientHandle(socket);
                Thread thread =new Thread(clientHandle);
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Server_Thread server = new Server_Thread();
        server.start();
    }


    private class ClientHandle implements Runnable{
        private Socket socket;
        private String threadName;

        public ClientHandle(Socket socket) {
            this.socket = socket;
            threadName =socket.getInetAddress().getHostAddress()+"/"+count++;
        }

        @Override
        public void run() {
            try {
                //通过socket获取输入流读取对方发送过来的消息
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                //获取输出流
                OutputStream out= socket.getOutputStream();
                OutputStreamWriter osw =new OutputStreamWriter(out);
                BufferedWriter bw =new BufferedWriter(osw);
                PrintWriter pw = new PrintWriter(bw,true);

                //将输出流加入哈希表
                synchronized (Server_Thread.this) { //HashMap内部的存储结构是一个数组, put时对其扩容会有线程并发冲突
                    map.put(threadName, pw);
                }
                sendMessage("[" +threadName + "]上线了, 当前在线人数: " + map.size());

                String line;
                //若是客户端强行断开, 这里的br.readLine()会抛出一个SocketException异常
                while ((line = br.readLine()) != null) { //返回值为null断开连接
                    sendMessage("[" +threadName + "]说: " + line);
                }

            } catch (IOException e) {
//                e.printStackTrace();
            }finally {
                try {
                    sendMessage("[" +threadName+ "]下线了, 当前在线人数: " +(map.size()-1));
                    /*map.get(threadName).close();
                    br.close();   //不用关输出输入流了, 线程结束了, IO流自然关了*/

                    synchronized (Server_Thread.class) {
                        map.remove(threadName);
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 将消息广播给自己以外的所有人
         * @param line
         */
        private void sendMessage(String line){
            synchronized (Server_Thread.this) {
                //服务端控制台输出消息
                System.out.println(line);
                // 广播, 遍历哈希表, 将信息发给所有客户端
                for (Map.Entry<String, PrintWriter> entry:
                        map.entrySet()) {
                //    if (entry.getKey() != threadName)  //广播是否包含发给自己
                        entry.getValue().println( line);
                }
            }
        }
    }

}

