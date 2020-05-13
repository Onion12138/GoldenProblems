package leetcode.simulation;

/**
 * @author onion
 * @date 2020/4/26 -2:16 下午
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class _43字符串相乘 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        for(int i=num1.length()-1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int b = num2.charAt(j)-'0';
                int sum = a*b + result[i+j+1];
                result[i+j+1] = sum % 10;
                result[i+j] += sum /10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<result.length;i++){
            if(i==0 && result[i] == 0)
                continue;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
