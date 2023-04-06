package com.ming.sort;

public class ShellSort extends BaseSort{
    @Override
    void sort(int[] ints) {
        //增量:gap
        //增量初始值为1/2长度，增量每次除二
        for (int gap = ints.length/2; gap > 0; gap /= 2) {
            //i = gap
            //循环次数为：长度-gap
            for (int i = gap; i < ints.length; i++) {
                int j = i;
                int target = ints[j];
                for (; j - gap >= 0 && target<ints[j - gap]; j -=gap) {
                    ints[j] = ints[j-gap];
                }
                ints[j] = target;
            }
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

//        for (int gap = ints.length/2; gap > 0; gap /= 2) {
//            for (int i = gap; i < ints.length; i++) {
//                int j = i;
//                int target = ints[i];
//                for (; j-gap > 0 && ints[j] < ints[j-gap] ;j -= gap ) {
//
//                }
//            }
//        }
    }
}
