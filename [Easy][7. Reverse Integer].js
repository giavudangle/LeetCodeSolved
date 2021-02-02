/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    const INF = Math.pow(2,31);
    if(x >= INF - 1 || x <= -INF || x===0) return 0;
    let flag = x > 0 ? true : false 
    let t = Math.abs(x).toString().split('').reverse().join('')
    if(parseInt(t) >= INF - 1 || parseInt(t) <= -INF) return 0;
    if(flag) return t;
    else return '-' + t;
};