package FileServer;

import java.io.IOException;

/**
 * 与节点服务器的通信策略
 * Created by Sunny on 2017/7/14 0014.
 */
public interface CommunicateWithStorageStrategy {
    /**
     * 让节点服务器删除文件
     * @param uuid      要删除文件的uuid
     * @param nodeName  要让哪个节点服务器删除文件
     * @return      返回删除的结果
     * @throws IOException
     */
    int remove(String uuid, String nodeName) throws IOException;
}
