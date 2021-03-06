package FileServer;

import Data.FileInfoDAO;
import Info.TransProtocol;
import base.SocketSupport;

import java.io.IOException;

/**
 * 与节点服务器通信策略的实现
 * Created by Sunny on 2017/7/14 0014.
 */
public class CommunicateWithStorageStrategyImpl extends SocketSupport implements CommunicateWithStorageStrategy{

    public CommunicateWithStorageStrategyImpl(String ip, int port) throws IOException {
        super(ip, port);
    }

    /**
     * 让节点服务器删除文件
     * @param uuid      要删除文件的uuid
     * @param nodeName  要让哪个节点服务器删除文件
     * @return      返回删除的结果
     * @throws IOException
     */
    @Override
    public int remove(String uuid, String nodeName) throws IOException {
        dos.writeInt(TransProtocol.CODE_REMOVE_FILE);
        dos.writeUTF(uuid);
        int result = dis.readInt();
        close();
        if (result == -2)
            throw new IOException("删除文件失败");
        else{
            FileInfoDAO.query(uuid).removeNodeName(nodeName);
        }
        return result;
    }
}
