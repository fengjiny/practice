package demo.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by liwei01 on 2018-03-23
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<byte[]> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
        System.out.println("Server response is " + BytesHexStrTranslate.bytesToHexFun1(msg));
//        ChannelFuture future = ctx.channel().close();
//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) throws Exception {
//                System.out.println("==============channel--read==============");
//                System.out.println("Server response is " + BytesHexStrTranslate.bytesToHexFun1(msg));
//            }
//        });
        if (msg != null) {
            ctx.close();
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("active");
//        byte bs [] = BytesHexStrTranslate.toBytes("28901808080001A0020004080008001629");
        byte bs [] = BytesHexStrTranslate.toBytes("28801805010001A0010004000200025529");
        ctx.writeAndFlush(bs);
    }

//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("channelInactive");
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause);
    }
}
