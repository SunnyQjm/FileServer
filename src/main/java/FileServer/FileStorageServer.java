package FileServer;


import utils.MyThreadPool;
import utils.Tool;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 该类负责接收来自节点服务器的心跳包，并把它加入到等待队列，自己不处理
 * Created by Sunny on 2017/7/8 0008.
 */
public class FileStorageServer {
    private static final int BUFFER_SIZE = 1024;

    public FileStorageServer(int port) {
        System.out.println("FileStorageServer is ready！！");
        try {
            DatagramSocket ds = new DatagramSocket(port);
            DatagramPacket dp = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE,
                    InetAddress.getLocalHost(), port);
            FileStorageDataDealRunnable fsddr = new FileStorageDataDealRunnable();

            //在另一个线程异步处理节点服务器发上来的心跳包
            MyThreadPool.getInstance()
                    .submit(fsddr);

            while(!MyThreadPool.getInstance().isShutdownJudge()){
                ds.receive(dp);
                //收到一个心跳包就将它放到等待队列
                fsddr.add(Tool.subByteArray(dp.getData(), 0, dp.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
