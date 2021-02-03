class Solution {
public:
    double findMedianSortedArrays(std::vector<int>& A, std::vector<int>& B) {

    int m = A.size();
    int n = B.size();


    if (m > n) {
        int temp = m;
        m = n;
        n = temp;

        std::vector<int> tempNums = A;
        A = B;
        B = tempNums;
    }

    int imin = 0; int imax = m; int halfLen = (m + n + 1) / 2;

    while (imin <= imax) {
        int i = (imin + imax) / 2;
        int j = halfLen - i;

        if (i < imax && B[j - 1] > A[i]) {
            imin = i + 1;
        }
        else if (i > imin && A[i - 1] > B[j]) {
            imax = i - 1;
        }
        else {
            int maxLeft = 0;
            if (i == 0) { maxLeft = B[j - 1]; }
            else if (j == 0) { maxLeft = A[i - 1]; }
            else { maxLeft = std::max(A[i - 1], B[j - 1]); }
            if ((m + n) % 2 == 1) { return maxLeft; }

            int minRight = 0;
            if (i == m) { minRight = B[j]; }
            else if (j == n) { minRight = A[i]; }
            else { minRight = std::min(A[i], B[j]); }

            return (maxLeft + minRight) / 2.0;
        }
    }

    return 0.0;
    }   
};