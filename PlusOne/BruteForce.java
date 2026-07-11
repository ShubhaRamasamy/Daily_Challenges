class Solution {
    public int[] plusOne(int[] digits) {
        int digit=0;
        for(int i=0;i<digits.length;i++)
        {
           digit=digit*10+digits[i];
        }
        int ans=digit+1;
        String s = String.valueOf(ans);
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        return arr;
    }
}
