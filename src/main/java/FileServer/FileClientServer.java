package FileServer;

import utils.MyThreadPool;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该类负责接收Client发出的请求，并将Socket对象传递给ThreadSupport，让线程异步处理请求
 * 自己则再次去等待新的连接链入
 * 服务器与客户端通信的主程序
 * Created by Sunny on 2017/7/6 0006.
 */
public class FileClientServer {
    public FileClientServer(int port, FCStrategy fcs){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("FileServer is ready!");
            while(!MyThreadPool.getInstance().isShutdownJudge()){
                Socket socket = serverSocket.accept();
                fcs.service(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
