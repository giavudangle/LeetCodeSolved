class Solution {
  public int countLargestGroup(int n) {
    int[] countTable = new int[37];
    int maxGroup = 0, result = 0;

    for (int i = 1; i <= n; i++) {
      int sumOfDigit = 0;
      int numberIterator = i;
      while (numberIterator > 0) {
        sumOfDigit += numberIterator %10;
        numberIterator/=10;
      }

      ++countTable[sumOfDigit];

      if (maxGroup < countTable[sumOfDigit]) {
        maxGroup = countTable[sumOfDigit];
        result = 1;
      } else if (maxGroup == countTable[sumOfDigit]) {
        result++;
      }
    }
    return result;
  }
}
