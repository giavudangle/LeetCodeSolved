class Solution {
    public boolean canPlaceFlowers(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (n == 0)
                return true;
            if (a[i] == 1)
                continue;

            if (a.length == 1) {
                if (a[i] == 0 && n == 1)
                    return true;
                if (a[i] == 1 && n == 1)
                    return false;
            }

            if (i == 0 && a.length > 1) {
                if (a[i + 1] == 0) {
                    n--;
                    a[i] = 1;
                    continue;
                }
                continue;
            }

            if ((i - 1) >= 0 && (i + 1) <= a.length) {
                if (i == a.length - 1 && a[i - 1] == 0) {
                    n--;
                    a[i] = 1;
                    return n == 0;
                }
                if (a[i - 1] == 1 || a[i + 1] == 1) {
                    continue;
                }
            }
            n--;
            a[i] = 1;
        }

        if (n <= 0) {
            return true;
        }

        return false;
    }
}