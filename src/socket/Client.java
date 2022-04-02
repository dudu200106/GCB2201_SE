package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    /*
        java.net.Socket
        Socket封装了TCP协议的通讯细节，使用它可以和服务端建立TCP连接，并基于两个流的
        读写完成数据交换。
     */
    private Socket socket;

    public Client( ) {
        try {

            System.out.println("正在连接服务器...");
            socket= new Socket("10.1.188.33",8088);
            System.out.println("与服务器建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端开始工作的方法
     */
    public void start(){
        try {

            //启动一个服务端处理线程
            ServerHandle serverHandle =new ServerHandle();
            Thread thread =new Thread(serverHandle);
            thread.start();

            /*多态的思想: 返回某种OutputStream的派生类对象
                      --不关心返回对象的具体派生类型,只要继承了OutputStream就行
              socket: getOutputStream() : OutputStream*/
            OutputStream out= socket.getOutputStream();
            //以上获得了一个低级流
            //再转换流
            OutputStreamWriter osw=new OutputStreamWriter(out, StandardCharsets.UTF_8);
            //接下来是缓冲流
            BufferedWriter bw=new BufferedWriter(osw);
            //最后是
            PrintWriter pw=new PrintWriter(bw,true);

            Scanner scn=new Scanner(System.in);
            while (true){
                String line= scn.nextLine();
                if ("exit".equalsIgnoreCase(line)){
                    break;
                }
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                /*
                    Socket提供了close方法，可以与远端计算机断开连接。
                    该方法调用时，也会自动关闭通过它获取的输入流和输出流。
                 */
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    /*
    * 该线程任务负责处理服务端发来的信息
    * */
    private class ServerHandle implements Runnable{

        @Override
        public void run() {
            try {
                /*输入流*/
                InputStream in= socket.getInputStream();
                InputStreamReader isr =new InputStreamReader(in,StandardCharsets.UTF_8);
                BufferedReader br =new BufferedReader(isr);

                while (true){
                    //读取服务端说的话, 输入到client控制台
                    String line= br.readLine();
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                    System.out.println("服务器崩溃...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
