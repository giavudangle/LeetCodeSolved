/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(num) {
    const symbol = {
  M: 1000,
  D: 500,
  C: 100,
  L: 50,
  X: 10,
  V: 5,
  I: 1
}
let a = 'LVIII';

  let temp = num.split('');
  let rs = 0;
  for(i = 0; i < temp.length; i++) {
    if(i < temp.length - 1) {
      if(symbol[temp[i]] >= 
        symbol[temp[i+1]])
        rs += symbol[temp[i]];
      else 
        rs -= symbol[temp[i]]
    } else {
      rs += symbol[temp[i]]
    }
  
  }
    return rs
};