package demo.netty.demo3;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class ClientDemo {

    public static void connect(String url, String carId, String map_id, String parking_id) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new HttpClientHandler());
                }
            });
            URI uri = new URI(url + carId + "/");
            String host = uri.getHost();
            int port = uri.getPort();

            String requestBody = "{\"command\":\"auto_parking\", \"parameters\": {\"map_id\":"
                    + map_id + ", \"parking_id\":"
                    + parking_id + "}}";

            // Start the client.
            ChannelFuture f = b.connect(host,port).sync();

            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.PUT,
                    uri.toString());

            // 构建http请求
            request.headers().set(HttpHeaders.Names.HOST, host);
            request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
//            request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());

            request.headers().add(HttpHeaders.Names.CONTENT_TYPE, "application/json");
            ByteBuf bbuf = Unpooled.copiedBuffer(requestBody, StandardCharsets.UTF_8);
            request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, bbuf.readableBytes());
            request.content().clear().writeBytes(bbuf);
            // 发送http请求
            f.channel().writeAndFlush(request);
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {

        String url = "http://47.100.124.51:8000/controls/";
        String carId = "e100.car10.yw";
        String map_id = "1";
        String parking_id = "1";

        connect(url, carId, map_id, parking_id);
    }
}

class HttpClientHandler extends SimpleChannelInboundHandler<Object> {

    //接受服务端发来的消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("server response ： "+msg);
        if (msg instanceof HttpResponse)
        {
            HttpResponse response = (HttpResponse) msg;
            System.out.println("CONTENT_TYPE:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE));
        }
        if(msg instanceof HttpContent)
        {
            HttpContent content = (HttpContent)msg;
            ByteBuf buf = content.content();
            System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
//            buf.release();
        }
    }

    //与服务器建立连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //给服务器发消息
//        ctx.channel().writeAndFlush("i am client !");

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
