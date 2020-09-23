package com.alibaba.lcc.utils.BigDecimalUtils;

import java.math.BigDecimal;

/**
 * 高精度计算工具类
 *
 * @author Leon
 * @version 2018/4/18 11:56
 */
public class BigDecimalUtils {

    /**
     *
     * @param args
     *
     * public BigDecimal add(BigDecimal augend)
     * 加法
     *
     * public BigDecimal subtract(BigDecimal
     * subtrahend)
     * 减法
     *
     * public BigDecimal multiply(BigDecimal
     * multiplicand)
     * 乘法
     *
     * public BigDecimal divide(BigDecimal
     * divisor)
     * 除法
     *
     *
     */

    public static void main(String[] args) {
        String d1 = "100.22";
        String d2 = "320.11";
        System.out.println("加法 -》" + BigDecimalUtils.add(d1,d2,2) );
        System.out.println("减法 -》" + BigDecimalUtils.subtract(d1,d2,3) );
        System.out.println("乘法 -》" + BigDecimalUtils.multiply(d1,d2,2) );
        System.out.println("除法 -》" + BigDecimalUtils.round(d1,d2,2) );
    }

        /**
         * default divide scale
         */
        private static final int DEFAULT_DIVIDE_SCALE = 10;

        /**
         *default add scale
         */
        private static final int DEFAULT_ADD_SCALE = 4;

        /**
         *default subtract scale
         */
        private static final int DEFAULT_SUB_SCALE = 4;

        /**
         * default multiplicative default
         */
        private static final int DEFAULT_MULTI_SCALE = 10;

        /**
         * default scale
         */
        private static final int DEFAULT_SCALE = 2;

        /**
         * Return the result of tow number divide by default scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double divide(double arg1, double arg2){
            return divide(arg1, arg2, DEFAULT_DIVIDE_SCALE);
        }

        /**
         * Return the result of two string number divide by scale
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double divide(double arg1, double arg2, int scale){
            return divide(Double.toString(arg1), Double.toString(arg2), scale);
        }

        /**
         * Return the result of two string number divide by default scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double divide(String arg1, String arg2){
            return divide(arg1, arg2,DEFAULT_DIVIDE_SCALE);
        }

        /**
         * Return the result of two string number divide by scale
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double divide(String arg1, String arg2, int scale){
            BigDecimal var1 = new BigDecimal(arg1);
            BigDecimal var2 = new BigDecimal(arg2);
            return var1.divide(var2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        /**
         * Return the result of two number multiplicative by default scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double multiply(double arg1, double arg2){
            return multiply(arg1, arg2, DEFAULT_MULTI_SCALE);
        }

        /**
         * Return the result of two number multiplicative by scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double multiply(double arg1, double arg2, int scale){
            return multiply(Double.toString(arg1), Double.toString(arg2), scale);
        }

        /**
         * Return the result two string number multiplicative by default scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double multiply(String arg1, String arg2){
            return multiply(arg1, arg2, DEFAULT_MULTI_SCALE);
        }

        /**
         * Return the result of two number multiplicative by scale
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double multiply(String arg1, String arg2, int scale){
            BigDecimal var1 = new BigDecimal(arg1);
            BigDecimal var2 = new BigDecimal(arg2);
            return round(var1.multiply(var2).doubleValue(), scale);
        }

        /**
         * Return the result of two number subtract by scale
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double subtract(double arg1, double arg2 ,int scale){
            return subtract(Double.toString(arg1), Double.toString(arg2), scale);
        }

        /**
         * Return the result of two number subtract by default scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double subtract(double arg1, double arg2){
            return subtract(Double.toString(arg1), Double.toString(arg2), DEFAULT_SUB_SCALE);
        }
        /**
         * Return the result of two number subtract by default scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double subtract(String arg1, String arg2){
            return subtract(arg1, arg2, DEFAULT_SUB_SCALE);
        }

        /**
         * Return the result of two number subtract by scale
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double subtract(String arg1, String arg2, int scale){
            BigDecimal var1 = new BigDecimal(arg1);
            BigDecimal var2 = new BigDecimal(arg2);
            return round(var1.subtract(var2).doubleValue(), scale);
        }

        /**
         * Return two number sum by the param scale value
         *  加法
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double add(double arg1, double arg2, int scale){
            return add(Double.toString(arg1), Double.toString(arg2), scale);
        }

        /**
         * Return two number sum by default add scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double add(double arg1, double arg2){
            return add(Double.toString(arg1), Double.toString(arg2));
        }

        /**
         * Return two number sum by default add scale
         *
         * @param arg1
         * @param arg2
         * @return
         */
        public static double add(String arg1, String arg2){
            return add(arg1, arg2, DEFAULT_ADD_SCALE);
        }

        /**
         * Return two number sum by scale
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double add(String arg1, String arg2, int scale){
            BigDecimal var1 = new BigDecimal(arg1);
            BigDecimal var2 = new BigDecimal(arg2);
            return round(var1.add(var2).doubleValue(), scale);
        }

        /**
         * Return a result from arg1 by scale
         *
         * @param arg1
         * @param scale
         * @return
         */
        public static double round(double arg1, int scale){
            return round(Double.toString(arg1), scale);
        }

        /**
         * Return result by scale
         *
         * @param arg1
         * @param scale
         * @return
         */
        public static double round(String arg1, int scale){
            if (scale < 0){
                throw new IllegalArgumentException("The scale value must be an integer or zero");
            }
            BigDecimal var1 = new BigDecimal(arg1);
            BigDecimal var2 = new BigDecimal(1);
            return var1.divide(var2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        /**
         * 除法 运算保留 scale位小数
         *
         * @param arg1
         * @param arg2
         * @param scale
         * @return
         */
        public static double round(String arg1,String arg2, int scale){
            if (scale < 0){
                throw new IllegalArgumentException("The scale value must be an integer or zero");
            }
            BigDecimal var1 = new BigDecimal(arg1);
            BigDecimal var2 = new BigDecimal(arg2);
            return var1.divide(var2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        /**
         * Return a result from arg1 by default scale
         *   将arg1  保留两位小数
         * @param arg1
         * @return
         */
        public static double round(double arg1){
            return round(arg1, DEFAULT_SCALE);
        }


}
