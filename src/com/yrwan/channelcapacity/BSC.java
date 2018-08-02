package com.yrwan.channelcapacity;
public class BSC {
    double errPr;//BSC�ŵ��Ĵ������
    public BSC(double Pr){
        errPr = Pr;
    }
//��BSC�����źţ����ش�����ֵ
    public int[] send(int[] data){
        boolean [] x=int2boolean(data);
        for(int i = 0; i<x.length;i++)
            if(Math.random()<errPr){
                x[i] = !x[i];
            }
        return boolean2int(x);
    }
 //��int������תΪboolean��
    private boolean[] int2boolean(int[] data){
        boolean [] x=new boolean[data.length];
        for (int i = 0; i < data.length; i++) {
            x[i] = data[i] == 1;
        }
        return x;
    }
 //��boolean������תΪint��
    private int[] boolean2int(boolean[] data){
        int[] x=new int[data.length];
        for (int i = 0; i < data.length; i++) {
            x[i]=data[i]?1:0;
        }
        return x;
    }
}