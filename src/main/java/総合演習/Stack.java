/* スタック */

public class Stack {
    public static void main(String[] args) {
        final int STACK_EMPTY = -1;     //スタックが空の状態
        /* キーボード入力のインスタンスを生成する */
        KeyIn ki = new KeyIn();

        /* 入力された要素数のスタック領域を確保 */
        int element;
        while((element = Integer.parseInt(ki.readKey("スタック要素数"))) < 1);
        int[] arrayStack = new int[element];
        int sp = STACK_EMPTY;       //スタックポインタ Empty(空)から開始

        int kind;                   //0:表示,1:push,2:pop
        int inData;                 //スタックするデータ

        /* スタック処理の種別を入力する */
        while(0 <= (kind = Integer.parseInt(ki.readKey("種別(0:表示,1:push,2:pop)")))){
            switch (kind){
            case 0:         //表示
                if (sp == STACK_EMPTY) {
                    System.out.println("スタックされていません");
                } else {
                    for (int i = sp; i > STACK_EMPTY; i--) {
                        System.out.println("[" + i + "]" + arrayStack[i]);
                    }
                }
                break;

            case 1:         // push
                if (sp == element-1) {
                    System.out.println("スタックがいっぱいです");
                } else {
                    inData = Integer.parseInt(ki.readKey("データ"));
                    sp++;
                    arrayStack[sp] = inData;
                }
                break;

            case 2:         // pop
                if (sp == STACK_EMPTY) {
                    System.out.println("スタックされていません");
                } else {
                    System.out.println(arrayStack[sp]);
                    sp--;
                }
                break;

            default:        //種別エラー
                System.out.println("種別の入力エラーです");
                break;
            }
        }
        System.out.println("----プログラム終了----");
    }
}
