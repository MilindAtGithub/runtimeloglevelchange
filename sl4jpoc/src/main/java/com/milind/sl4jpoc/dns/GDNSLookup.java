package com.milind.sl4jpoc.dns;


import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.resolver.dns.DnsNameResolver;
import io.netty.resolver.dns.DnsNameResolverBuilder;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class GDNSLookup {
    private static NioEventLoopGroup bossGroup = new NioEventLoopGroup();

    public void init() throws InterruptedException {

        while (true){
            try {
                DnsNameResolver res = new DnsNameResolverBuilder(bossGroup.next())
                        .channelType(NioDatagramChannel.class)
                        .build();
                InetAddress[] address = InetAddress.getAllByName("grpcdns");
                for(InetAddress address1:address){
                    System.out.println("Host:" + address1.getHostAddress());
                }
                address = InetAddress.getAllByName("yahoo.com");
                for(InetAddress address1:address){
                    System.out.println("Yahoo Host:" + address1.getHostAddress());
                }
                //bossGroup.shutdownGracefully();

            }catch (Exception e) {
                e.printStackTrace();
            }
            TimeUnit.SECONDS.sleep(30);
        }
    }
}
