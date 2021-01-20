package com.finalexam_Experimentation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class DogSort {

    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        String[] types=new String[]{"A","B","C","D"};
        String[] genders = new String[]{"男","女","other"};
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            float[] scores = new float[3];
            // scores[0]为毛质分、 scores[1]为灵活度分、 scores[2]为品种分, 分数均在 1-100 之间
            Dog dog = new Dog();
            int k = random.nextInt(4);
            int j = random.nextInt(3);
            dog.setType(types[k]); // 随机输入类型
            dog.setGender(genders[j]); // 随机输入性别

            for (int l = 0; l < 3 ; l++) {
                 float v =(float) (Math.random()*99+1); // 1~100的随机浮点数
                scores[l]=v;
            }

            dog.setScore(scores);
            dogs.add(dog);
        }

        // 输出dog对象未排序前的信息
        /*for (Dog dog : dogs) {
            System.out.println(dog.toString());
        }*/

        /*Dog{type='A', gender='女', score=[71.50768, 24.268774, 10.712902]}
        Dog{type='A', gender='男', score=[96.68368, 52.79601, 70.81889]}
        Dog{type='D', gender='other', score=[56.30693, 70.01389, 62.71995]}
        Dog{type='A', gender='other', score=[99.333084, 77.69403, 8.027348]}*/

        // Dog对象按毛质分降序排序
        dogs.sort(new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return Float.compare(o2.getScore()[0], o1.getScore()[0]);
            }
        });

        System.out.println("Dog对象按毛质分降序排序");

        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        /*Dog{type='C', gender='女', score=[99.9256, 8.990815, 3.1808834]}
        Dog{type='A', gender='女', score=[99.87861, 36.24722, 3.4064329]}
        Dog{type='A', gender='女', score=[99.7439, 56.24842, 58.50367]}
        ....
        Dog{type='B', gender='女', score=[1.4662446, 5.9690537, 40.31911]}
        Dog{type='D', gender='other', score=[1.0529964, 35.845978, 11.303398]}
        Dog{type='C', gender='男', score=[1.0458909, 78.87171, 48.95516]}
        Dog{type='C', gender='女', score=[1.0426209, 15.6578045, 28.323147]}
        */

        // Dog对象按灵活度分降序排序
        dogs.sort(new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
//                if (o2.getScore()[1] < o1.getScore()[1]) {
//                    return -1;
//                } else if (o2.getScore()[1] == o1.getScore()[1]) {
//                    return 0;
//                } else {
//                    return 1;
//                }
                return Float.compare(o2.getScore()[1], o1.getScore()[1]);
            }
        });

        System.out.println("Dog对象按灵活度分降序排序");

        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        /*Dog{type='A', gender='女', score=[58.566498, 99.43532, 6.53463]}
        Dog{type='B', gender='女', score=[53.426952, 99.41447, 25.820925]}
        Dog{type='C', gender='other', score=[59.896553, 99.22172, 93.54006]}
        Dog{type='A', gender='other', score=[10.76789, 99.15108, 22.38218]}
        ...
        Dog{type='A', gender='女', score=[1.8029338, 1.3476453, 24.97872]}
        Dog{type='B', gender='女', score=[28.151995, 1.3083955, 66.20561]}
        Dog{type='D', gender='男', score=[54.44567, 1.294794, 41.32025]}
        Dog{type='C', gender='男', score=[30.582512, 1.2383668, 32.08355]}*/

        // Dog对象按品种分降序排序
        dogs.sort(new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
//                if (o2.getScore()[2] < o1.getScore()[2]) {
//                    return -1;
//                } else if (o2.getScore()[2] == o1.getScore()[2]) {
//                    return 0;
//                } else {
//                    return 1;
//                }
                return Float.compare(o2.getScore()[2], o1.getScore()[2]);
            }
        });

        System.out.println("Dog对象按品种分降序排序");

        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        /*Dog{type='B', gender='男', score=[68.06976, 23.456198, 99.926125]}
        Dog{type='D', gender='男', score=[35.167435, 19.446037, 99.7695]}
        Dog{type='B', gender='女', score=[31.03559, 12.721747, 99.698044]}
        ....
        Dog{type='D', gender='女', score=[27.697186, 12.369672, 1.1138706]}
        Dog{type='B', gender='男', score=[13.21431, 62.532707, 1.032669]}
        Dog{type='A', gender='other', score=[48.47958, 62.76358, 1.0182062]}*/

    }
}
