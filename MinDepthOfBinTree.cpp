/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
    
private:
    int minDepthVal = INT_MAX;
    int level = 1;
    void traverseTree(TreeNode* root) {
        
        if(root->left == NULL && root->right == NULL) {
            if(level < minDepthVal) {
                minDepthVal = level;
            }
        }
        if(root->left != NULL) {
            level++;
            traverseTree(root->left);
            level--;
        }
        if(root->right != NULL) {
            level++;
            traverseTree(root->right);
            level--;
        }
    }
    
public:
    int minDepth(TreeNode* root) {
        if(root == NULL) {
            return 0;
        }
        traverseTree(root);
        return minDepthVal;
    }
};
