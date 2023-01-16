class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> result = new ArrayList();

        Arrays.sort(a);
        for(int i = 0; i < a.length; i++){
            int k = i + 1;
            int j = a.length - 1 ;

            if(i > 0 && a[i] == a[i -1]) continue;

            while(k < j) {
                if(j < a.length - 1 && a[j] == a[j+1]){
                    j--;
                    continue;
                }

                Integer sum = a[i] + a[j] + a[k];

                if (sum > 0) --j;
                else if (sum < 0) ++k;
                else {
                    result.add(Arrays.asList(a[i],a[j],a[k]));
                    k++;
                    j--;
                }
            }
        }
        return result;
    }
}