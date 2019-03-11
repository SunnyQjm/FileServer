package FileServer;

import java.io.IOException;
import java.net.Socket;

/**
 * 处理请求的策略（可能是客户端的请求，也可能是监控程序的请求）
 * Created by Sunny on 2017/7/6 0006.
 */
public interface FCStrategy {
    /**
     * 在service函数中处理来自客户端或监控程序的请求
     * 根据不同的code区分不同的请求，采取不同的响应
     * @param socket
     * @throws IOException
     */
    public void service(Socket socket) throws IOException;
}
