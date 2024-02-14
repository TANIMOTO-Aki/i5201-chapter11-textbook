public class BubbleSort {
    public static void main(String[] args) {
        int[] arrayScode = {102,800,201,101,283,430,181,550};
        String[] arraySname = {"事務机B型","応接机","会議用机","事務机A型",
                               "折り畳み机","木製机","脇机","学生机"};
        int i,j;
        boolean sortFlag;           //整列フラグ
        int tempScode;
        String tempSname;

        /* 交換法による整列 */
        i = 0;
        while(i < (arrayScode.length - 1)) {
            sortFlag = true;        //整列フラグtrue
            j = arrayScode.length - 1;
            while(i < j){
                if(arrayScode[j-1] > arrayScode[j]) {
                    /* 商品コードと商品名のそれぞれを交換 */
                    tempScode = arrayScode[j];
                    tempSname = arraySname[j];
                    arrayScode[j] = arrayScode[j-1];
                    arraySname[j] = arraySname[j-1];
                    arrayScode[j-1] = tempScode;
                    arraySname[j-1] = tempSname;
                    sortFlag = false;   //整列フラグfalse
                }
                j--;
            }
            /* スキャン中に一度も交換されなければ整列完了 */
            if(sortFlag) {
                break;
            }
            i++;
        }

        /* 整列後の内容表示 */
        i = 0;
        while (i < arrayScode.length) {
            System.out.println(arrayScode[i] + "\t" + arraySname[i]);
            i++;
        }
    }
}
