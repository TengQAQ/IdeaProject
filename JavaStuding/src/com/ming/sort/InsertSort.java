package com.ming.sort;

public class InsertSort extends BaseSort{
    @Override
    void sort(int[] ints) {
        for (int i = 1; i < ints.length ; i++) {
            //target:新插入的数据
            int target = ints[ i ];
            if (target < ints[ i - 1 ]){
                int j = i - 1;
                for (; j >= 0 && target < ints[ j ]; j--) {
                    ints[ i ] = ints[ i - 1 ];
                }
                ints[ j + 1 ] = target;
            }else {
                ints[ i ] = target;
            }
        }
//        System.out.println(Arrays.toString(ints));
    }
}
