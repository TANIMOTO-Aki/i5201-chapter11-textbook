/* キュー */

public class Queue {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();     //キーボード入力インスタンス

        /* 入力されたキューの要素数+１の配列を確保 */
        System.out.println("(指定した数－１)個のキューバッファが用意されます");
        int element;
        while ((element = ki.readInt("配列要素数:")) < 1);
        int[] arrayQueue = new int[element];
        System.out.println((element -1) + "個の要素を格納できます");

        int kind;           //種別(0:表示,1:格納,2:取出)
        int inData;         //格納するデータ

        int front = 0;      //先頭ポインタ
        int rear = 0;       //末尾ポインタ(次の要素位置を示す)

        /* スタックの処理の種別を入力する */
        while (0 <= (kind = ki.readInt("種別(0:表示,1:格納,2:取出):"))){
            switch (kind) {
                case 0:     //表示
                    if (front == rear){
                        System.out.println("データが格納されていません");
                    } else if (front < rear){
                        for (int i = front; i < rear; i++) {
                            System.out.println("[" + i + "]" + arrayQueue[i]);
                        }
                    } else {
                        for (int i = front; i != rear; i = (i + 1) % arrayQueue.length){
                            System.out.println("[" + i + "]" + arrayQueue[i]);
                        }
                    }
                    break;
            
                case 1:     //格納(enqueue)
                    if ((rear+1)%(arrayQueue.length) == front){
                        System.out.println("キューがいっぱいです");
                    } else {
                        inData = ki.readInt("データ:");
                        arrayQueue[rear] = inData;
                        rear++;
                        if(rear >= arrayQueue.length) rear=0;
                    }
                    break;

                case 2:     //取り出し(dequeue)
                    if(front == rear){
                        System.out.println("データが格納されていません");
                    } else {
                        System.out.println(arrayQueue[front]);
                        front++;
                        if(front >= arrayQueue.length) front=0;
                    }
                    break;
                    
                default:    //識別エラー
                    System.out.println("識別の入力エラーです");
                    break;
            }
        }
        System.out.println("---- プログラム終了 ----");
    }
}
