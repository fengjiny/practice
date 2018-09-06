package demo.netty.client;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * Created by liwei01 on 2018-04-24
 */
public class Server {

    public Server() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup);

        try {
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer() {

                @Override
                protected void initChannel(Channel socketChannel) throws Exception {
                    byte bs[] = {0x29};
                    ByteBuf delimiter = Unpooled.copiedBuffer(bs);
                    socketChannel.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(2048, delimiter));

                    socketChannel.pipeline().addLast("decoder", new ByteArrayDecoder());
                    socketChannel.pipeline().addLast("encoder", new ByteArrayEncoder());
                    socketChannel.pipeline().addLast("handler", new ServerHandler());
                }
            });
//            ChannelFuture f = serverBootstrap.bind(8808).sync();
            ChannelFuture f = serverBootstrap.bind(8080).sync();
            System.out.println("start netty server port = 8080");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            System.out.println("netty server boot start error");
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String args[]) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Server();
            }
        }).start();
    }
}
