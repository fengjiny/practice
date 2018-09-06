package demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liwei01 on 2018-03-23
 */
public class Client {

    private static String host = "112.74.126.185";
    private static String localhost = "127.0.0.1";

    public Client() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.group(eventLoopGroup);
//            bootstrap.remoteAddress(host, 8808);
            bootstrap.remoteAddress(localhost, 8808);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    byte bs[] = {0x29};
                    ByteBuf delimiter = Unpooled.copiedBuffer(bs);
                    socketChannel.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(2048, delimiter));

                    socketChannel.pipeline().addLast("decoder", new ByteArrayDecoder());
                    socketChannel.pipeline().addLast("encoder", new ByteArrayEncoder());
                    socketChannel.pipeline().addLast("handler", new HelloClientHandler());
                }
            });
//            ChannelFuture future = bootstrap.connect(host, 8808).sync();
            //发起异步连接操作
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(localhost,8808)).sync();
//            if (future.isDone()) {
//                future.channel().close();
//            }
            if (future.isCancelled()){
                future.channel().close();
            }
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String args[]) throws Exception{
//        new Thread(()->new Client()).start();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
//        Thread.sleep(5000);
//        exec.shutdown();
    }
}