/**
 * @param {number[]} nums
 * @return {number}
 */

var singleNumber = function(nums) {
    const s = nums.reduce((prev, curr) => (prev[curr] = ++prev[curr] || 1, prev), {})
    for(let key in s){
        if(s[key] === 1) 
            return key;
    }
};


