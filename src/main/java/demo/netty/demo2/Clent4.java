package demo.netty.demo2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class Clent4 {
    public static void main(String[] args) {

        //worker负责读写数据
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            //辅助启动类
            Bootstrap bootstrap = new Bootstrap();

            //设置线程池
            bootstrap.group(worker);

            //设置socket工厂
            bootstrap.channel(NioSocketChannel.class);

            //设置管道
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //获取管道
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    //字符串解码器
                    pipeline.addLast(new StringDecoder());
                    //字符串编码器
                    pipeline.addLast(new StringEncoder());
                    //处理类
                    pipeline.addLast(new ClientHandler4());
                }
            });

            //发起异步连接操作
            ChannelFuture future = bootstrap.connect(new InetSocketAddress("172.17.9.8",8080)).sync();

            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅的退出，释放NIO线程组
            worker.shutdownGracefully();
        }
    }

}

class ClientHandler4 extends SimpleChannelInboundHandler<String> {

    //接受服务端发来的消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("server response ： "+msg);
    }

    //与服务器建立连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //给服务器发消息
        ctx.channel().writeAndFlush("i am client !");

        System.out.println("channelActive");
    }

    //与服务器断开连接
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
    }

    //异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭管道
        ctx.channel().close();
        //打印异常信息
        cause.printStackTrace();
    }

}