package spring.demo.arithmetic.day0723;

/**
 * @Package: spring.demo.arithmetic.day0723
 * @ClassName: SparseArr
 * @Description: 稀疏数组 && 二维数组 （主要应用于大部分数据都是相同/无效数据的情况下）
 * @Author: liangxin
 * @CreateDate: 2019/7/23 15:27
 * @UpdateDate: 2019/7/23 15:27
 */
public class SparseArr {

    public static void main(String[] args) {
        /**
         * 创建一个二维数组 11 * 11
         * 0-没有棋子；1-黑子；2-白子
         */
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[9][10] = 2;
        // 输出原始二维数组
        System.out.println("原始二维数组如下：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println(); // 换行
        }

        // 转成稀疏数组
        // 1、遍历，得到有效数据个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j < chessArr1.length; j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println();
        System.out.println("有效数据个数：" + sum);

        // 2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum +1][3];

        // 3、给稀疏数组第一行赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 4、其他动态的行赋值
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j < chessArr1.length; j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("输出稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
//====================================至此完成二维数组转稀疏数组=====================================================

        /**
         * 稀疏数组转回二维数组
         */
        int ofter[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1; i < sparseArr.length; i++){
            ofter[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : ofter) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println(); // 换行
        }

    }

}
