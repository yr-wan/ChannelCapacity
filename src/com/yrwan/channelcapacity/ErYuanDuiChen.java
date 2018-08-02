package com.yrwan.channelcapacity;
import java.util.Scanner;
public class ErYuanDuiChen {
    public static void main(String[] args){
        double errPr;
        int[] data;
        Scanner input = new Scanner(System.in);
        System.out.print("输入BSC信道的错误概率(0~1)：");
        errPr=input.nextDouble();
        System.out.print("输入要传输的二进制序列长度：");
        data=new int[input.nextInt()];
        System.out.print("输入要传输的二进制序列：");
        for (int i = 0; i < data.length; i++) {
            data[i]=input.nextInt();
        }
        input.close();
        BSC bsc=new BSC(errPr);
        int[] result=bsc.send(data);
        System.out.printf("传输后的二进制序列为：");
        for (int r:result) {
            System.out.printf(r+" ");
        }
    }
}