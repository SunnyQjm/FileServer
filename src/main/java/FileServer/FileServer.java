package FileServer;

import Data.FileInfoDAO;
import Data.FileStorageDAO;
import utils.MyThreadPool;

import java.io.IOException;
import java.util.Scanner;

/**
 * 服务器主程序，启动对客户端和存储节点的监听
 * Created by Sunny on 2017/7/6 0006.
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        //监听节点服务器发送的心跳包，以更新存储节点的状态信息
        MyThreadPool.getInstance()
                .submit(() -> new FileStorageServer(2534));

        //启动与客户端交互的程序，并在端口2533处监听来自客户端的请求
        MyThreadPool.getInstance()
                .submit(() -> new FileClientServer(2533, new FileClientThreadSupport(new FCStrategyImpl())));

        Scanner scanner = new Scanner(System.in);
        String lineText = null;
        while (!(lineText = scanner.nextLine().trim()).equals("quit")) {
            if(lineText.equals("save")){
                FileInfoDAO.recordToFile("./src/main/java/Data/FileInfoData.dat");
                FileStorageDAO.recordToFile("./src/main/java/data/FileStorageInfo.dat");
                System.out.println("保存信息成功");
            }
        }
        MyThreadPool.getInstance().shutDownNow();
    }
}
