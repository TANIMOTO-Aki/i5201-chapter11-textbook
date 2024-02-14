public class SelectionSort {
    public static void main(String[] args) {
        int[] arrayScode = {102,800,201,101,283,430,181,550};
        String[] arraySname = {"事務机B型","応接机","会議用机","事務机A型",
                               "折り畳み机","木製机","脇机","学生机"};
        int i,j;
        int tempScode;      //交換用作業領域
        String tempSname;   //交換用作業領域

        /* 選択法による整列 */
        i = 0;
        while (i < (arrayScode.length-1)) {
            j = i+1;
            while (j < arrayScode.length) {
                if (arrayScode[i] > arrayScode[j]) {
                    /* 商品コードと商品名のそれぞれを交換 */
                    tempScode = arrayScode[i];
                    tempSname = arraySname[i];
                    arrayScode[i] = arrayScode[j];
                    arraySname[i] = arraySname[j];
                    arrayScode[j] = tempScode;
                    arraySname[j] = tempSname;
                }
                j++;
            }
            i++;
        }

        /* 整列後の内容の表示 */
        i = 0;
        while (i < arrayScode.length) {
            System.out.println(arrayScode[i] + "\t" + arraySname[i]);
            i++;
        }
    }
}
