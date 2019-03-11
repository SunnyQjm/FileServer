package FileServer;

import utils.MyThreadPool;

import java.net.Socket;

/**
 * 该类实现了处理请求的策略，同时提供线程异步处理支持，将不同的请求放到不同的线程处理
 * Created by Sunny on 2017/7/6 0006.
 */
public class FileClientThreadSupport implements FCStrategy{
    private FCStrategy fcs;

    public FileClientThreadSupport(FCStrategy fcs) {
        this.fcs = fcs;
    }

    @Override
    public void service(Socket socket) {
        //将处理socket的工作交给线程池，让线程池处理
        MyThreadPool.getInstance().submit(new FileClientRunnable(socket, fcs));
    }
}
