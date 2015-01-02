package org.sdancer.leetcode;
import java.util.*;
public class SimplifyPath {
	public static  String simplifyPath(String path){
		String[] paths = path.split("/");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<paths.length;i++){
			if(paths[i].equals("") || paths[i].equals(".")){
				;//skip
			}
			else if(paths[i].equals("..")){
				if(!list.isEmpty()){
					list.remove(list.size()-1);
				}
				else{
					//System.out.println("Invalid Path");
					;
				}
			}
			else{
				list.add(paths[i]);
			}
		}
		String result = "";
		for(int i=0; i< list.size(); i++){
			result = result + "/" + list.get(i);
		}
		if(result.equals("")) return "/";
		return result;
	}
	
	public static void main(String[] args){
		String test1 = "/home/";
		String test2 = "/a/./b/../../c/";
		System.out.println(simplifyPath(test1));
		System.out.println(simplifyPath(test2));
	}
}
