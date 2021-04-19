package assignment5;
public class TreeNode<T> {
	protected T data;
	protected TreeNode<T> left, right;

	public TreeNode(T dataNode) {
		this.data = dataNode;
	    this.left = this.right = null;
	  }

	public TreeNode(TreeNode<T> node) {
	    this.data = node.data;
	    this.left = node.left;
	    this.right = node.right;
	  }

	public T getData()
	{
	    return this.data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
	
	public TreeNode<T> getLChild()
	{
		return left;
	}
	
	public TreeNode<T> getRChild()
	{
		return right;
	}
	
	public void setLChild(TreeNode<T> L)
	{
		left = L;
	}
	
	public void setRChild(TreeNode<T> R)
	{
		left = R;
	}
}