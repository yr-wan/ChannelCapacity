package com.yrwan.channelcapacity;
public class BSC2 {
    double errPr;//BSC�ŵ��Ĵ������
    public BSC2(double Pr){
        errPr = Pr;
    }
//��BSC�����źţ����ش�����ֵ
    public int[] send(int[] data){
    	int[] x=new int[data.length];
    	x = data;
        for(int i = 0; i<data.length;i++)
            if(Math.random()<errPr){
                x[i] = 1 - x[i];
            }
        return x;
    }
}