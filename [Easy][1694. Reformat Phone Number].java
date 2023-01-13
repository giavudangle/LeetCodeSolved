class Solution {
  public String reformatNumber(String number) {
    final int ODD_OFFSET = 3;
    final int EVEN_OFFSET = 2;

    String replaced = number.replace("-","").replace(" ","");
    int length = replaced.toCharArray().length;

    int div = length / ODD_OFFSET;
    int mod = length % ODD_OFFSET;

    if(length == 3) return replaced;
    if(length == 4) return replaced.substring(0,2) + '-' + replaced.substring(2,4);
    if(length == 5) return replaced.substring(0,3) + '-' + replaced.substring(3,5);

    StringBuilder result = new StringBuilder();
    switch (mod){
      case 0:
        mapByOffset(replaced,div,result,ODD_OFFSET,0);
        return result.substring(0,result.length() - 1);
      case 1:
        int pairCount = (length - ODD_OFFSET*(div - 1)) / EVEN_OFFSET;
        int tupleCount = (length - (EVEN_OFFSET* pairCount)) / ODD_OFFSET;
        mapByOffset(replaced,tupleCount,result,ODD_OFFSET,0);
        mapByOffset(replaced,pairCount,result,EVEN_OFFSET,tupleCount*ODD_OFFSET);
        return result.substring(0,result.length() - 1);
      case 2:
        mapByOffset(replaced, div, result, ODD_OFFSET,0);
        return result.append(replaced,length - 2, length).toString();
    }

    return result.toString();
  }

  private void mapByOffset(String base, int length, StringBuilder result,int offset,int start) {
    while(length > 0){
      result.append(base,start,start+offset);
      result.append('-');
      start+=offset;
      length--;
    }
  }
}