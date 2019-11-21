package com.example.algs.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长上升子序列
 * <p>
 * [什么是动态规划（Dynamic Programming）？动态规划的意义是什么？](https://mp.weixin.qq.com/s?__biz=MzA5ODUxOTA5Mg==&mid=2652570272&idx=2&sn=052eb5fbc33f6fa2c45dc4d1e1a8dbed&chksm=8b7ff3fbbc087aed394f91feb472c4795952f11d698ea71745433019eba9b2083a8d1332426a&mpshare=1&scene=1&srcid=&sharer_sharetime=1574236130099&sharer_shareid=971362146fda7fd9907e7f3d5a7e91f8&key=a561a906d89030b704a9ee8256350152d5b3a3a7bc537dccdececea7976b209f42d011608eac1ee7d529cb39c9bf82248f6929606b4d9c011607606f4c87fac592982aed25ae3c79752cd0263922f1fd&ascene=1&uin=MTkyMzA5MDIwNA%3D%3D&devicetype=Windows+10&version=62070152&lang=zh_CN&pass_ticket=Oc6d0jnub0gxAYT2Ax1YXV4Vq%2BvnT8dSbRD6zbgbuABYeQoKsfDBhOqKekn0GtQ5)
 *
 * @author lyloou
 * @date 2019/11/20
 */
public class LongestRiseSubSequence {
    public static void main(String[] args) {
        int[] a = new int[]{10, 5, 10, 8, 9, 17, 8};
        int[] f = new int[a.length];
        Arrays.fill(f, 1);
        int len = a.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) f[i] = Math.max(f[i], f[j] + 1);
            }
            System.out.printf("f[%d]=%d\tlength=%d\n", i, a[i], f[i]);
        }

        int maxIndex = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (f[i] > maxLen) {
                maxIndex = i;
                maxLen = f[i];
            }
        }
        System.out.println(String.format("最长的长度：%d, 最大值：%d, 最大值所在位置：%d", maxLen, a[maxIndex], maxIndex));

        // 获取最长上升序列
        List<Integer> list = new ArrayList<>();
        int current = f[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (f[i] == current) {
                list.add(a[i]);
                current--;
            }
        }

        System.out.println("最长上升序列是：" + list);

    }
}
