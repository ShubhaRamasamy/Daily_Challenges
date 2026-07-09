class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length())
            return s;

        int n = s.length();
        char[][] ans = new char[numRows][n];

        int i = 0, j = 0;
        char[] ch = s.toCharArray();

        int ind = 0;

        while (ind < ch.length) {

            // Vertical
            if (i == 0) {

                int step = 0;

                while (step < numRows && ind < ch.length) {
                    ans[i][j] = ch[ind];
                    i++;
                    ind++;
                    step++;
                }

                i = numRows - 1;
            }

            // Diagonal
            if (i == numRows - 1) {

                while (i > 1 && ind < ch.length) {
                    i--;
                    j++;
                    ans[i][j] = ch[ind];
                    ind++;
                }

                i = 0;
                j++;
            }
        }

        StringBuilder str = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < n; c++) {

                if (ans[r][c] != '\0') {
                    str.append(ans[r][c]);
                }

            }
        }

        return str.toString();
    }
}
