import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();

        for (int d : digits) {
            sb.append(d);
        }

        BigInteger num = new BigInteger(sb.toString());
        num = num.add(BigInteger.ONE);

        String s = num.toString();

        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        return arr;
    }
}
