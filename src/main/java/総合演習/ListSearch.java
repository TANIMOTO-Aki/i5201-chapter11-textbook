public class ListSearch {
    private static final int END_OF_LIST = -1;
    private int[] arrayNum =    {20, 40, 10,  0, 30,  0,  0,  0};
    private int[] arrayScore =  {22, 44, 11,  0, 33,  0,  0,  0};
    private int[] arrayNext =   { 4, -1,  0,  5,  1,  6,  7, -1};
    private int lip = 2;    //リストの先頭
    private int eip = 3;    //空きリストの先頭

    public static void main(String[] args) {
        int kind;
        KeyIn ki = new KeyIn();
        ListSearch listSearch = new ListSearch();

        System.out.println("実行する機能を選択してください");
        while(0 <= (kind = ki.readInt("0:リスト表示,1:探索,2:追加,3:更新,4:削除(終了= -1 ):"))){
            switch (kind) {
            case 0:     //リスト表示
                listSearch.listView();
            break;

            case 1:     //探索
            int num;
            while ((num = ki.readInt("番号(戻る=0):")) != 0) {
                listSearch.searchFromList(num);
            }
            break;

            case 2:     //追加
            while ((num = ki.readInt("追加番号(戻る=0):")) != 0) {
                listSearch.addToList(num);
            }
            break;

            case 3:     //更新
            while ((num = ki.readInt("更新番号(戻る=0):")) != 0)
                listSearch.updateList(num);
            break;

            case 4:     //削除
            while ((num = ki.readInt("削除番号(戻る=0):")) != 0)
                listSearch.deleteFromList(num);
            break;

            default:    //識別エラー
                System.out.println("識別の入力エラーです");
            break;
            }
        }
        System.out.println("---- プログラム終了 ----");
    }

    /* リスト表示を行うメソッド */
    private void listView(){
        int idx = lip;
        if(idx == END_OF_LIST){
            System.out.println("データがありません");
            return;
        }
        while(idx != END_OF_LIST){
            System.out.println("番号:" + arrayNum[idx] + "\t" + "点数:" + arrayScore[idx] );
            idx = arrayNext[idx];
        }
    }

    /* 探索を行うメソッド */
    private void searchFromList(int num) {        
        int idx = lip;

        while (idx != END_OF_LIST && num != arrayNum[idx]) {
            idx = arrayNext[idx];
        }

        if (idx != END_OF_LIST) {
            System.out.println(arrayScore[idx]); // 成功
        } else {
            System.out.println("見つかりませんでした"); // 失敗
        }
    }

    /* 追加を行うメソッド */
    private void addToList(int num) {
        KeyIn ki = new KeyIn();
        if(lip == END_OF_LIST) lip = eip;
        int idx = lip;
        int prevIdx = lip;
        int currentIdx = lip;
        int add = eip;

        while(idx != END_OF_LIST && num != arrayNum[idx]){
            idx = arrayNext[idx];
        }

        if(add == END_OF_LIST){
            System.out.println("リストに空きがありません");
        }else if(idx == END_OF_LIST){
            int score = ki.readInt("点数:");
            arrayNum[add] = num;
            arrayScore[add] = score;
            while (arrayNext[currentIdx] != END_OF_LIST) {
                prevIdx = currentIdx;
                currentIdx = arrayNext[prevIdx];
            }
            eip = arrayNext[add];
            arrayNext[add] = arrayNext[currentIdx];
            arrayNext[currentIdx] = add;
            if (lip == eip) eip = END_OF_LIST;
            System.out.println("追加しました:" + "番号=" + num + " 点数=" + score);
        }else{
            System.out.println("登録済みの番号です");
        }
    }

    /* 更新を行うメソッド */
    private void updateList(int num) {
        KeyIn ki = new KeyIn();
        int idx = lip;

        while (idx != END_OF_LIST && num != arrayNum[idx]) {
            idx = arrayNext[idx];
        }

        if (idx != END_OF_LIST) {
            int newScore = ki.readInt("点数:");
            arrayScore[idx] = newScore;
            System.out.println("要素を更新しました");
        } else {
            System.out.println("要素が見つかりません");
        }
    }

    /* 削除を行うメソッド */
    private void deleteFromList(int num) {
        int prevIdx = lip;

        if(prevIdx == END_OF_LIST){
            System.out.println("データがありません");
        }else{
            int currentIdx = arrayNext[prevIdx];
            if (arrayNum[prevIdx] != num){
                while (currentIdx != END_OF_LIST && arrayNum[currentIdx] != num) {
                    prevIdx = currentIdx;
                    currentIdx = arrayNext[currentIdx];
                }
            }else{          //リストの先頭を削除する場合の処理
                arrayNum[prevIdx] = 0;
                arrayScore[prevIdx] = 0;
                lip = arrayNext[prevIdx];
                arrayNext[prevIdx] = eip;
                eip = prevIdx;
                System.out.println("要素を削除しました");
                return;
            }

            if (currentIdx != END_OF_LIST) {
                arrayNum[currentIdx] = 0;
                arrayScore[currentIdx] = 0;
                arrayNext[prevIdx] = arrayNext[currentIdx];
                arrayNext[currentIdx] = eip;
                eip = currentIdx;
                System.out.println("要素を削除しました");
            } else {
                System.out.println("要素が見つかりません");
            }
        }
    }
}