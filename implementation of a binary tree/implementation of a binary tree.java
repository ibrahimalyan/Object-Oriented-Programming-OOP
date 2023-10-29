

import java.util.ArrayList;
import java.util.List;

public class BTree <E> {
	
	private Node <E> root;
	
	
	public BTree(){
		
		this.root = null;
	}
	
	public void add(E data) {
		
		Node <E> Add = new Node<>(data);
		
		if(this.root == null) {
			this.root = Add;
		}
		
		else if (this.root.getLeftSon() == null) {
			
			this.root.setLeftSon(Add);	
		}
		else if (this.root.getRightSon() == null) {
			
			this.root.setRightSon(Add);
		}
		else {
			
			if((int) Math.abs(left(this.root, 1) - right(this.root, 1)) <= 1) {
				
				addHelp(this.root.getLeftSon(), data);	
			}
			
			else {
				
				addHelp(this.root.getRightSon(), data);}
			}}
	
	private void addHelp(Node<E> node, E data) {
		
		Node <E> Add = new Node<>(data);
		
		if(node.getLeftSon() == null) {
			
			node.setLeftSon(Add);
		}
		else if (node.getRightSon() == null) {
			
			node.setRightSon(Add);
		}
		else {
			
			if((int)Math.abs(left(node, 1) - right(node, 1)) <=1) {
				
				addHelp(node.getLeftSon(), data);	
			}
			
			else {
				
				addHelp(node.getRightSon(), data);}
			}}
	
	
	private int right(Node <E> node,int count) {
		
		if(node.getRightSon() != null) {
			
			return right(node.getRightSon(), count+ 1);	
		}
		return count;
	}
	
	private int left(Node <E> node, int count) {
		
		if(node.getLeftSon() != null) {
			
			return left(node.getLeftSon(), count+1);
		}
		return count;
	}
	
	public String pre() {
		
		String Return = "";
		
		if(this.root == null) {
			return Return;
		}
		
		Return += this.root.getData() + "\t";
		
		if(this.root.getLeftSon() != null) {
			
			Return += preHelp(this.root.getLeftSon(), "");
		}
		
		if(this.root.getRightSon() != null) {
			
			Return += preHelp(this.root.getRightSon(), "");
		}
		return Return;}
				
	
	public String preHelp(Node <E> node,String a) {
		
		a +=  "" + node.getData() + "\t";
		
		if(node.getLeftSon() != null) {
			
			a+= preHelp(node.getLeftSon(), "");
		}
		
		if(node.getRightSon() != null) {	
			a+= preHelp(node.getRightSon(), "");
		}
		return a;}
		
	
	
	
	public String in() {
		
		String Return = "";
		
		if(this.root == null) {
			
			return Return;
		}
		
		
		if(this.root.getLeftSon() != null) {
			
			Return += inHelp(this.root.getLeftSon(), "");
		}
		
		Return += this.root.getData() + "\t";
		
		if(this.root.getRightSon() != null) {
			
			Return += inHelp(this.root.getRightSon(), "");
		}
		
		return Return;
	}
	
	public String inHelp(Node <E>node, String a) {
		
			
		if(node.getLeftSon() != null) {
			
			a+= inHelp(node.getLeftSon(), "");
			
		}
		
		a+=  "" + node.getData() + "\t";
		
		
		if(node.getRightSon() != null) {
			
			a+= inHelp(node.getRightSon(), "");
		}
			
		return a;}
	
	public String post() {
		
	String Return = "";
		
		if(this.root == null) {
			
			return Return;
		}
		
		if(this.root.getLeftSon() != null) {
			
			Return += postHelp(this.root.getLeftSon(), "");
		}
		
		if(this.root.getRightSon() != null) {
			
			Return += postHelp(this.root.getRightSon(), "");
		}
		Return += this.root.getData() + "\t";
		
		return Return;
		
	}
	
	private String postHelp(Node <E>node, String a) {
		
		if(node.getLeftSon() != null) {
			
			a+= postHelp(node.getLeftSon(), "");	
		}
		
		if(node.getRightSon() != null) {
			
			a+= postHelp(node.getRightSon(), "");
		}
		
		a +=  "" + node.getData() + "\t";
		
		
		return a;
		
	}
	
public int height() {
		
		return left(this.root, 1);}
	
	
	public int size() {
		
		int count = 1;
		
		
		if(this.root == null) {
			
			return 0;
			
		}
		
		if(this.root.getLeftSon() != null) {
			
			count += sizeHelp(this.root.getLeftSon(), 1);
			
		}
		
		if(this.root.getRightSon() != null) {
			
			count += sizeHelp(this.root.getRightSon(), 1);
		}
		
		
		return count;}
	
	
	private int sizeHelp(Node <E>node, int count) {
		 
		if(node.getLeftSon() != null) {
			
			count += sizeHelp(node.getLeftSon(), 1);
			
		}
		if(node.getRightSon() != null) {
			
			count += sizeHelp(node.getRightSon(), 1);
		}
		
		return count;}
	
	
    public boolean findPath(Node<E> root, int currDepth, int reqDepth, List<E> list){
        
        if (root == null)   return false;
       
        if (currDepth == reqDepth)  {
           
            list.add(root.getData());
         
            return true;
        } else {
           
            if (findPath(root.getLeftSon(), currDepth + 1, reqDepth, list)) {
                
                list.add(root.getData());
               
                return true;
            } else if (findPath(root.getRightSon(), currDepth + 1, reqDepth, list)) {
               
                list.add(root.getData());
               
                return true;
            }
           
            return false;}
        }
        
        
    public String path(int level){
      
        StringBuilder sb = new StringBuilder();
      
        List<E> list = new ArrayList<>();
       
        findPath(root, 1, level, list);
       
        int N = list.size();
    
        for (int i = N - 1; i >= 0; --i) {
     
            sb.append(list.get(i));
        
            if (i > 0)  sb.append(",");
        }
     
        return sb.toString();
    }
    
	
}
