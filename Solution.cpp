
#include <queue>
using namespace std;

class Solution {
    
public:

    string removeKdigits(string num, int k) {
        if (num.empty() || k == num.length()) {
            return "0";
        }

        deque<char> stack;
        for (const auto& digit : num) {
            while (k > 0 && !stack.empty() && digit < stack.front()) {
                stack.pop_front();
                k--;
            }
            stack.push_front(digit);
        }

        while (k-- > 0) {
            stack.pop_front();
        }

        removeLeadingZeros(stack);
        string smallestIntegerAfter_k_removals;

        while (!stack.empty()) {
            smallestIntegerAfter_k_removals.push_back(stack.back());
            stack.pop_back();
        }

        return smallestIntegerAfter_k_removals.length() > 0 ? smallestIntegerAfter_k_removals : "0";
    }

    void removeLeadingZeros(deque<char>& stack) {
        while (!stack.empty() && stack.back() == '0') {
            stack.pop_back();
        }
    }
};
