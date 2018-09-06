package demo.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by liwei01 on 2018-03-23
 */
public class ServerHandler extends SimpleChannelInboundHandler<byte[]> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
//        System.out.println(BytesHexStrTranslate.bytesToHexFun1(msg));
        System.out.println("client msg is "+ BytesHexStrTranslate.bytesToHexFun1(msg));
        ctx.channel().writeAndFlush("i am server !");
//        ctx.writeAndFlush(msg);
//        ctx.channel().close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client active");
        byte bs [] = BytesHexStrTranslate.toBytes("28801805010001A0010004000200025529");
        ctx.writeAndFlush(bs);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connect is closed");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause);
        cause.printStackTrace();
        ctx.close();
    }
}
