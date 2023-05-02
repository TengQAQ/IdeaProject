package M4D28;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/28-15:49
 * @description TODO
 */
public class Sort {
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] =  temp;
        }
        for (int a:arr
             ) {
            System.out.println(a);
        }
    }

//    冒泡排序法的实现
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        for (int a:arr
        ) {
            System.out.println(a);
        }
    }

//    快速排序法的实现
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
        return arr;
    }
    // 基数排序
    public static int[] radixSort(int[] arr) {
        int maxDigit = getMaxDigit(arr);
        for (int i = 1; i <= maxDigit; i++) {
            countingSort(arr, i);
        }
        return arr;
    }

    // 获取最大位数
    private static int getMaxDigit(int[] arr) {
        int maxDigit = 1;
        int radix = 10;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int temp = arr[i];
            int digit = 1;
            while (temp >= radix) {
                temp /= radix;
                digit++;
            }
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        return maxDigit;
    }

    // 按指定位数进行计数排序
    private static void countingSort(int[] arr, int digit) {
        int radix = 10;
        int len = arr.length;
        int[] count = new int[radix];
        for (int i = 0; i < len; i++) {
            int num = getDigit(arr[i], digit);
            count[num]++;
        }
        for (int i = 1; i < radix; i++) {
            count[i] += count[i - 1];
        }
        int[] temp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int num = getDigit(arr[i], digit);
            temp[--count[num]] = arr[i];
        }
        System.arraycopy(temp, 0, arr, 0, len);
    }

    // 获取指定位上的数字
    private static int getDigit(int num, int digit) {
        return (int) (num / Math.pow(10, digit - 1)) % 10;
    }

    public static void main(String[] args) {
        int[] arr= {12,2,16,30,8,28,4,10,20,6};
        selectionSort(arr);
        bubbleSort(arr);
        int[] ints = quickSort(arr, 0, arr.length - 1);
        for (int a:ints
        ) {
            System.out.println(a);
        }
        for (int i : radixSort(arr)) {
            System.out.println(i);
        }

    }
}
