package com.test6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileIO {
    // 去除停用词
    void clearFile(HashMap<String, Integer> wordCount, String stopWord) {
        Scanner scanner = null;
        File file = new File(stopWord);
        ArrayList<String> tmp = new ArrayList<>();
        int i = 0;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //不区分大小写地去除词频中的停用词
        while (Objects.requireNonNull(scanner).hasNextLine()) {
            String str = scanner.nextLine();
            for (String key : wordCount.keySet()) {
                if (str.equalsIgnoreCase(key)) {
                    tmp.add(key);
                    i++;
                }
            }
        }
        while (i-- > 0) {
            wordCount.remove(tmp.get(i));
        }
    }

    // 读取文件路径
    File readFile(int num) {
        return new File("src/com/test6/Test_6_4_InData/Lincoln, Abraham - The Writings of Abraham Lincoln Volume " + num + ".txt");
    }

    // 将文件内容存入HashMap，记录词频
    void calWords(Scanner scanner, HashMap<String, Integer> wordCount) {
        String str = null;
        // 读出整篇文章，存入String类的str中，最后加空格防止最后一个单词与第一个单词连接
        while (scanner.hasNextLine()) {
            str += scanner.nextLine() + " ";
        }
        StringTokenizer st = new StringTokenizer(Objects.requireNonNull(str), " #$()/*&%_;\\,.!?:[]-\"'");

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.merge(word, 1, Integer::sum);// 记录词频，同下，好像要比下侧方法快
//                if (wordCount.get(word) == null) {
//                    wordCount.put(word, 1);
//                } else {
//                    wordCount.put(word, wordCount.get(word) + 1);
//                }
        }
    }

    // 以特定格式写入文件
    void writeFile(HashMap<String, Integer> wordCount) {
        PrintWriter pw = null;
        String[] str;

        try {
            pw = new PrintWriter("src/com/test6/Test_6_4_OutData/wordCount.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<HashMap.Entry<String, Integer>> list = MySort(wordCount);
        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
//            pw.write(String.format("%s\n", list.get(i)));
            str = String.format("%s", stringIntegerEntry).split("=");
            Objects.requireNonNull(pw).write(String.format("%-19s%s\n", str[0], str[1]));// 不有点问题
        }
        Objects.requireNonNull(pw).close(); // ！！！重要，否则会导致文件写入不全
    }

    //对取得的词按词频降序
    ArrayList<HashMap.Entry<String, Integer>> MySort(HashMap<String, Integer> wordCount) {
        ArrayList<HashMap.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        //升序排序
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - (o1.getValue());
            }
        });
        return list;
    }
}
