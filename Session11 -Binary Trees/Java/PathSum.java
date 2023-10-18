package sample.walmart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathSum {
	
	static TreeNode root =new TreeNode(5);
	public static class TreeNode {
		     int val;
		     TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	static Set<Integer> sums=new HashSet<>();
	
	//return list of sums of all paths
	public static void sumPath(TreeNode root,int sum) {
		if(root==null)
			return;
		if(root.left==null && root.right==null) {
			sums.add(sum+root.val);
			return;
		}
		
		sumPath(root.left,sum+root.val);
		sumPath(root.right,sum+root.val);
		
		
	}
	static List<List<Integer>> res=new ArrayList<>();
	
	//check if any path with sum of target exists
	public static boolean checkSum(TreeNode root,int target,int currSum){
		if(root==null)
            return false;
        if(root.left==null && root.right==null){
         currSum+=root.val;
        
        if(currSum==target)
        return true;
        }
       
        boolean leftSum=checkSum(root.left,target,root.val+currSum);
        boolean rightSum=checkSum(root.right,target,root.val+currSum);
        return leftSum||rightSum;
        
    }
	
	//Return list of all paths with given sum
	public static void addPaths(List<Integer> path,int targetSum,int currSum,TreeNode root){
        if(root==null)
        return;
        path.add(root.val);
        if(root.left==null && root.right==null){
            
            if(currSum+root.val==targetSum){
                res.add(new ArrayList<>(path));
                
            }
        }
        
        addPaths(path,targetSum,currSum+root.val,root.left);
        
        addPaths(path,targetSum,currSum+root.val,root.right);
        path.remove(path.size()-1);
    }
    public static void pathSum(TreeNode root, int targetSum) {
        addPaths(new ArrayList<Integer>(),targetSum,0,root);
        
    }
    static List<String> paths=new ArrayList<>();

    //Return list of all paths
    public static void traverse(List<Integer> path,TreeNode root){
        if(root==null)
        return;
        path.add(root.val);
        if(root.left==null && root.right==null){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<path.size();i++){
                if(i<path.size()-1)
                sb=sb.append(path.get(i)).append("->");
                else
                sb=sb.append(path.get(i));                
            }
            paths.add(sb.toString());
        }

        traverse(path,root.left);
        traverse(path,root.right);
        path.remove(path.size()-1);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        traverse(new ArrayList<Integer>(),root);
        return paths;
    }
	
	public static void main(String[] args) {
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11,new TreeNode(7),new TreeNode(2));
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4, new TreeNode(5), new TreeNode(1));
		System.out.println( checkSum(root,22,0));
		
		sumPath(root, 0);
		System.out.println(sums);
		pathSum(root,22);
		System.out.println(res);
		
		System.out.println(binaryTreePaths(root));
	}
}
