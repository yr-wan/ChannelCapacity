package com.yrwan.channelcapacity;
import java.util.Scanner;
public class ErYuanDuiChen {
    public static void main(String[] args){
        double errPr;
        int[] data;
        Scanner input = new Scanner(System.in);
        System.out.print("����BSC�ŵ��Ĵ������(0~1)��");
        errPr=input.nextDouble();
        System.out.print("����Ҫ����Ķ��������г��ȣ�");
        data=new int[input.nextInt()];
        System.out.print("����Ҫ����Ķ��������У�");
        for (int i = 0; i < data.length; i++) {
            data[i]=input.nextInt();
        }
        input.close();
        BSC bsc=new BSC(errPr);
        int[] result=bsc.send(data);
        System.out.printf("�����Ķ���������Ϊ��");
        for (int r:result) {
            System.out.printf(r+" ");
        }
    }
}