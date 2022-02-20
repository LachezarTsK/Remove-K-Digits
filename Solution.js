
/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function (num, k) {

    if (num === undefined || num === null || k === num.length) {
        return "0";
    }

    const stack = [];
    for (let digit of num) {
        while (k > 0 && stack.length > 0 && digit < stack[stack.length - 1]) {
            stack.length--;
            k--;
        }
        stack.push(digit);
    }

    while (k-- > 0) {
        stack.length--;
    }

    let size = stack.length;
    let index = jumpOverLeadingZeros(stack, size);
    let smallestIntegerAfter_k_removals = [];

    while (index < size) {
        smallestIntegerAfter_k_removals.push(stack[index++]);
    }
    return smallestIntegerAfter_k_removals.length > 0 ? smallestIntegerAfter_k_removals.join('') : "0";
};


/**
 * @param {string[]} stack
 * @param {number} size
 * @return {number}
 */
function jumpOverLeadingZeros(stack, size) {
    let index = 0;
    while (index < size && stack[index] === '0') {
        index++;
    }
    return index;
}
