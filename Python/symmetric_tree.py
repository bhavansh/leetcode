#https://leetcode.com/problems/symmetric-tree/

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#Solution Class
class Solution(object):

    def isSymmetric(self, root):

        if root == None:
            return True

        return self.helper(root.left, root.right)

    def helper(self, left, right):
        
        if left == None and right == None:
            return True

        if left == None or right == None:
            return False

        if left.val != right.val:
            return False

        return self.helper(left.left, right.right) and self.helper(left.right, right.left)