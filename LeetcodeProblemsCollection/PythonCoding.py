"""
Name: Jump Game  No.55 Level: Medium  Selected: 13/150 

You are given an integer array nums. 
You are initially positioned at the array's first index, and each 
element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Examples:
Input: [2,4,2,0,1], [2,0,0], [0,1,0], [3,2,1,0,4]
Output: True, True, False, False 
"""
class canJump: 
    "nums: a list (in python data structure) of non-negative numbers"
    def Attempt3(self,nums):
        " Attempt 3 solution to the problem [correct version] " 
        lst = [False for i in range(len(nums))] # space comlexity: O(N)
        endIndex = len(nums) - 1
        lst[0] = True 
        for currIndex in range(len(nums)):
            steps = nums[currIndex]
            if lst[currIndex] == False:
                break # must-lose condition
            elif currIndex + steps >= endIndex:
                lst[endIndex] = True
                break # must-win condition
            else:
                for nextIndex in range (currIndex + 1, currIndex + steps + 1):
                    lst[nextIndex] = True  
        return lst[endIndex] == True 

    def Attempt4(self,nums):
        currPos = len(nums) - 1
        targetIndex = 0
        # Starts with the goal position 
        for i in range(len(nums)-2,-1,-1):
            # nums[i] + i means the maximum position you can jump to when 
            # standing at position i; if nums[i] + i >= currPos, it 
            # means that the current position at currPos can be achieved 
            # when standing at index i    
            if nums[i] + i >= currPos:
                currPos == i
        return currPos == targetIndex        
        
# Attempt 1:  use recursions 
#   ---> Maximum Recursion Limit or Time Limit Exceeds 
#   ---> MAXIMUM JUMP LENGTH doesn't mean the EXACT length of jumping 
# Attempt 2: while-loop + indicators via brute force 
#   ---> indicators taken: currVal:nums[i] & currSum: currSum-=nums[i]
#   ---> weakness: too many edge cases can not be covered  
# CHANGE WAY OF THINKING (Start at the back side):
# IDEAS: (from solution board)
# Attempt 3: If I started at index 0, searching for next available spots.
#   ---> nested for-loops should be BANNED or SIGNIFICANTLY IMPROVED
#   ---> Accepted! Results are not optimal
#   ---> (i): current spot is FALSE at lst, you can not Jump. For example:
#   --->   the current spot is 0 and the 0 can't be skipped 
#   ---> (ii): AVOID O(N^2) time consumption by mutating the last element
#   ---> in lst to be FALSE if you can jump to the end of the nums at the step
#   ---> (iii): the first spot at lst will always be TRUE 
#   ---> (iv):  
# Attempt 4: It is EXTREMELY HARD to solve in this way starting at index 0. 

"""
Name: Jump Game II Level: Medium No.45
You are given a 0-indexed array of integers nums of length n. 
You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump 
from index i. In other words, if you are at nums[i], you can jump to 
any nums[i + j] where:
    0<=j<=nums[i] and 
    i + j < n
Return the minimum number of jumps to reach nums[n - 1]. 
The test cases are generated such that you can reach nums[n - 1].
Constraints: 
    it is guaranteed that you can reach nums[n-1]
    0 <= nums[i] <= 1000
    1 <= nums.length <= 1000
Examples: 
    input: [2,4,1,1,3],[2,0,0],[2,3,0,1,4],[0],[7,0,9,6,9,6,1,7,9,0,2,9,0,3]
    output: 2, 1, 2, 0, 2
    
"""
class canJump2:
    def Attempt1(self,nums):
        steps = [nums[i] + i for i in range(len(nums))]
        index, Ind, jumps = 0,0,0
        # 1- jump condition:  can reach the last element of nums within on jump 
        if nums[0] >= len(nums) - 1 and len(nums) > 1:
            jumps = 1
        # 0 - jump condition: Born at Rome. The first element is the last element
        elif len(nums) == 1:
            jumps = 0 
        # General condition
        else:
            while index > 0:
                # Stopping condition of the while-loop 
                if index >= len(nums) - 1:
                    break 
                Ind = max(steps[index + 1: steps[index] + 1])
                jumps += 1 
                # case 1: Check whether it can achieve directly without more jumps
                if Ind >= len(nums) - 1 and index < len(nums) - 1:
                    jumps += 1
                    break
                # case 2: Update the index. It involves to search the next stepping stone  
                else:
                    for j in range(index+1,steps[index] + 1):
                        if steps[j] == Ind:
                            index = j
        return jumps 

# Attempt 1: Accepted with bad performance of space complexity. Submit 8 times to eliminate bugs 
#       2 times to optimize this problem. Space Complexity: O(N) ; Runtime Complexity : O(N)






