package com.yrwan.channelcapacity;
import java.util.Scanner;
public class DieDai {
    public static int M;
    public static int N;
    public static double C;
    public static void main(String[] args) {
        int t = 0; // 迭代次数
        Scanner input = new Scanner(System.in);
        System.out.println("输入状态转移矩阵的行列数M，N：");
        N = input.nextInt();
        M = input.nextInt();
        double[][] p = new double[N][M];
        double[] S = new double[N];
        double[] SS = new double[N];    // 存入迭代计算后的S
        System.out.println("输入状态转移矩阵：");
        // 输入转移矩阵
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                p[i][j] = input.nextDouble();
            }
        input.close();
        // 初始化数据
        for (int i = 0; i < N; i++)
            S[i] = (double) 1 / N;// 赋值
        // 迭代
        boolean flag = true;
        double[][] fa = new double[M][N];
        while (flag) {
            // 计算fa[j][i]
            for (int j = 0; j < M; j++) {
                double sum = 0;
                for (int i = 0; i < N; i++) {
                    sum = sum + S[i] * p[i][j];
                }
                for (int i = 0; i < N; i++)
                    fa[j][i] = (S[i] * p[i][j]) / sum;
            }
            // 迭代计算S
            // 计算分母
            double sum1 = 0;
            for (int i = 0; i < N; i++) {
                boolean flag3 = true;
                double sum2 = 0;
                for (int j = 0; j < M; j++) {
                    if (fa[j][i] != 0)
                        sum2 = sum2+ (p[i][j] * (Math.log(fa[j][i]) / Math.log(Math.E)));
                    else if (fa[j][i] == 0 && p[i][j] != 0) {
                        flag3 = false;
                    }// exp(log0)=0,下同
                    else if (fa[j][i] == 0 && p[i][j] == 0)
                        sum2 = sum2 + 0;// 0log0=0
                }
                if (flag3)
                    sum1 = sum1 + Math.exp(sum2);
                else
                    sum1 = sum1 + 0;
            }
            // 计算SS[i]4
            for (int i = 0; i < N; i++) {
                boolean flag1 = true;// 若有无穷比无穷
                double sum6 = 0;
                for (int j = 0; j < M; j++) {
                    if (fa[j][i] != 0)
                        sum6 = sum6 + p[i][j]* (Math.log(fa[j][i]) / Math.log(Math.E));
                    else if (fa[j][i] == 0 && p[i][j] != 0) {
                        flag1 = false;
                    } else if (fa[j][i] == 0 && p[i][j] == 0)
                        sum6 = sum6 + 0;
                }
                if (flag1)
                    SS[i] = Math.exp(sum6) / sum1;
                else
                    SS[i] = 0;
            }
            double epsilon = 0; //停止迭代的容差限
            for (int i = 0; i < N; i++) {
                epsilon = epsilon + Math.pow(SS[i] - S[i], 2);
            }
            if (epsilon < 0.00001)
                flag = false;
            else {
                for (int i = 0; i < N; i++)
                    S[i] = SS[i];
            }
            C = Math.log(sum1) / Math.log(2);
            t++;
        }
        System.out.println("迭代次数为：" + t);
        System.out.print("最佳信源分布为：");
        for (int i = 0; i < N - 1; i++)
            System.out.print(S[i] + "，");
        System.out.println(S[N - 1]);
        System.out.println("信道容量为：" + C);
    }
}