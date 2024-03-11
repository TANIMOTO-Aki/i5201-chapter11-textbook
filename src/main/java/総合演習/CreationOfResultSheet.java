public class CreationOfResultSheet {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();
        FileOut fo = new FileOut();

        /* データ件数の指定 */
        int dataSize = ki.readInt("データの件数を入力してください(1~100):");
        if (dataSize <= 0 || dataSize > 100){
            System.out.println("エラー：データ件数が不正です");
            return;
        }

        /* 各配列生成 */
        int[] number = new int[dataSize];
        String[] name = new String[dataSize];
        int[] score = new int[dataSize];

        /* データ入力 */
        for (int i = 0; i < dataSize; i++){
            number[i] = validateNumber(ki.readInt("学籍番号:"));
            name[i] = validateName(ki.readKey("氏名:"));
            score[i] = validateScore(ki.readInt("試験点数:"));
        }

        /* number順に昇順ソート */
        sortData(number,name,score);

        /*ファイル出力 */
        final String COMMA = ",";
        boolean ret;
        String buf;
        try{
            fo.open(ki.readKey("出力ファイル名を指定してください:"));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ファイル名を指定してください");
            System.exit(1);
        }

        for(int i = 0; i < dataSize; i++){
            buf = number[i] + COMMA + name[i] + COMMA + score[i];
            fo.writeln(buf);
        }

        ret = fo.close();
        if (ret == false) {
            System.out.print("プログラムを異常終了します");
            System.exit(1);
        }

        System.out.println("ファイル出力が完了しました");
        System.out.println("----プログラム終了----");
    }

    /* 昇順でソートを行うメソッド (バブルソート)*/
    private static void sortData(int[] number, String[] name, int[] score){
        String tmpName;
        int tmpNumber,tmpScore;

        for(int i = 0; i < number.length-1;i++){
            for(int j = 0; j < number.length-1;j++){
                if(number[j] > number[j+1]){
                    tmpNumber = number[j];
                    number[j] = number[j+1];
                    number[j+1] = tmpNumber;

                    tmpName = name[j];
                    name[j] = name[j+1];
                    name[j+1] = tmpName;

                    tmpScore = score[j];
                    score[j] = score[j+1];
                    score[j+1] = tmpScore;
                }
            }
        }
    }

    /*入力したデータを確認するメソッド */
    private static int validateNumber(int input) {
        KeyIn ki = new KeyIn();
        while(input < 0 || input > 9999999){
            input = ki.readInt("学籍番号は7桁以内の数字で入力してください:");
        }
        return input;
    }

    private static String validateName(String input){
        KeyIn ki = new KeyIn();
        while(input.length() > 16){
            input = ki.readKey("氏名は16文字以内で入力してください:");
        }
        return input;
    }

    private static int validateScore(int input){
        KeyIn ki = new KeyIn();
        while(input < 0 || input > 100){
            input = ki.readInt("点数は0~100の間で入力してください:");
        }
        return input;
    }
}
