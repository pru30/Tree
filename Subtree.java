/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<TreeNode> res;
    private  void findNode(TreeNode s, TreeNode t){
        if(s == null)
            return;
        
        if(s.val == t.val)
            res.add(s);
        
        findNode(s.left,t);
        findNode(s.right,t);
    }
    
    private boolean compareTree(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        else if(s == null || t == null)
            return false;
        else
            return (s.val == t.val) &&   compareTree(s.left,t.left) && compareTree(s.right,t.right);  
        
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        if(t == null)
            return true;
        
        res = new ArrayList<TreeNode>();
        findNode(s,t);
        
        if(res == null || res.size() == 0)
            return false;
        
        Iterator<TreeNode> nodesIterator = res.iterator();
        while(nodesIterator.hasNext())
        {
            TreeNode n = nodesIterator.next();
            if(compareTree(n,t))
                return true;
        }
        return false;
            
    }
}