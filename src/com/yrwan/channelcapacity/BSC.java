package com.yrwan.channelcapacity;
public class BSC {
    double errPr;//BSC信道的错误概率
    public BSC(double Pr){
        errPr = Pr;
    }
//经BSC传输信号，返回传输后的值
    public int[] send(int[] data){
        boolean [] x=int2boolean(data);
        for(int i = 0; i<x.length;i++)
            if(Math.random()<errPr){
                x[i] = !x[i];
            }
        return boolean2int(x);
    }
 //将int型数组转为boolean型
    private boolean[] int2boolean(int[] data){
        boolean [] x=new boolean[data.length];
        for (int i = 0; i < data.length; i++) {
            x[i] = data[i] == 1;
        }
        return x;
    }
 //将boolean型数组转为int型
    private int[] boolean2int(boolean[] data){
        int[] x=new int[data.length];
        for (int i = 0; i < data.length; i++) {
            x[i]=data[i]?1:0;
        }
        return x;
    }
}