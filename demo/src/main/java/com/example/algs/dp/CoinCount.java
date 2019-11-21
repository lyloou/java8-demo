package com.example.algs.dp;

/**
 * [什么是动态规划（Dynamic Programming）？动态规划的意义是什么？](https://mp.weixin.qq.com/s?__biz=MzA5ODUxOTA5Mg==&mid=2652570272&idx=2&sn=052eb5fbc33f6fa2c45dc4d1e1a8dbed&chksm=8b7ff3fbbc087aed394f91feb472c4795952f11d698ea71745433019eba9b2083a8d1332426a&mpshare=1&scene=1&srcid=&sharer_sharetime=1574236130099&sharer_shareid=971362146fda7fd9907e7f3d5a7e91f8&key=a561a906d89030b704a9ee8256350152d5b3a3a7bc537dccdececea7976b209f42d011608eac1ee7d529cb39c9bf82248f6929606b4d9c011607606f4c87fac592982aed25ae3c79752cd0263922f1fd&ascene=1&uin=MTkyMzA5MDIwNA%3D%3D&devicetype=Windows+10&version=62070152&lang=zh_CN&pass_ticket=Oc6d0jnub0gxAYT2Ax1YXV4Vq%2BvnT8dSbRD6zbgbuABYeQoKsfDBhOqKekn0GtQ5)
 *
 * @author lyloou
 * @date 2019/11/20
 */
public class CoinCount {
    public static void main(String[] args) {
        int[] f = new int[155];
        int n = 150;
        for (int i = 1; i <= n; i++) {
            f[i] = getMinCost(f, i);
            System.out.printf("f[%d]=%d\n", i, f[i]);
        }
    }

    private static int getMinCost(int[] f, int i) {
        int cost = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            cost = Math.min(cost, f[i - 1] + 1);
        }
        if (i - 5 >= 0) {
            cost = Math.min(cost, f[i - 5] + 1);
        }
        if (i - 11 >= 0) {
            cost = Math.min(cost, f[i - 11] + 1);
        }
        return cost;
    }
}
