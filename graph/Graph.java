/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import static graph.Graph.createG;
import static graph.Graph.insertNode;
import static graph.Graph.removeEdge;
import static graph.Graph.removeNode;
import static graph.Graph.setEdge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Graph {
    private static Map<Integer, List<Integer>> adjList;
    
    public Graph(int v){
        adjList = new HashMap<Integer, List<Integer>>();
        for(int i=1; i<=v; i++)
            adjList.put(i, new LinkedList<Integer>());
        
    }
    
    public static int insertNode(int v, int numV){
        int resetV = v;
        for(int i=v + 1; i<=v + numV; i++)
            adjList.put(i , new LinkedList<Integer>());
        resetV = v + numV ;
        return resetV;
    }
    
    public static int removeNode(int numV, int V, List keySet){
        int resetV = numV;
        List<Integer> v = adjList.get(V);
        if(v != null){
            for(int i=1; i<=keySet.size(); i++){
                List<Integer> vtemp = adjList.get(i);
                for(int j=1; j<=vtemp.size(); j++){
                    if(vtemp.contains(V) == true)
                        //System.out.println(vtemp);
                        removeEdge(i, V);
                }
            }
            adjList.remove(V);
            resetV = numV - 1;
        }else{
            System.out.println("The node isn't exist!");
        }
        
        return resetV;
    }
    public static void setEdge(int to, int from){
        List keySet = new ArrayList(adjList.keySet());
        if (to > adjList.size() || from > adjList.size() || keySet.contains(from) == false || keySet.contains(to) == false){
            System.out.println("The vertices does not exists");
            return;
        }
        List<Integer> sls = adjList.get(to);
        sls.add(from);
        /*List<Integer> dls = adjList.get(from);
        dls.add(to);*/
    }
    
    public static void removeEdge(int to, int from){
        if (to > adjList.size() || from > adjList.size())
            System.out.println("The vertices does not exists");
 
        List<Integer> sls = adjList.get(to);
        List<Integer> dls = adjList.get(from);
        //System.out.println(sls);
        //System.out.println(dls);
        for(int i=0; i<sls.size(); i++){
            if(sls.get(i) == from){
                sls.remove(i);
                break;
            }
        }
        for(int j=0; j<dls.size(); j++){
            if(dls.get(j) == to){
                dls.remove(j);
                break;
            }
        }
    }
    
    public static List<Integer> getEdge(int to){
        List keys = new ArrayList(adjList.keySet());
        //if(adjList.get(to) == null){
        if(keys.contains(to) == false){
            System.out.println("The vertices does not exists");
            return null;
        }
        return adjList.get(to);
    }
   
    public static void createG(int vertex){
        int v;
        Scanner input2 = new Scanner(System.in);
        //try{
            /*int minV = (int)Math.ceil((1 + Math.sqrt(1 + 8 * e)) / 2);
            int maxV = e+1;*/
            
            Random rand = new Random();
            //int v = Math.abs(rand.nextInt(maxV - minV) + minV);
            v = vertex;
            System.out.println("Random graph has " +v+ " vertices");
            
            Graph reg = new Graph(v);
            int count = 1, to, from;
            
            while(count <= v){
                to = Math.abs(rand.nextInt(v + 1 - 1) + 1);
                from = Math.abs(rand.nextInt(v + 1 - 1) + 1);
                
                reg.setEdge(to, from);
                count++;
            }
            
            
            if(v <= 5000){
                System.out.println("The adjacency List of the random graph is :");

                for(int i=1; i<=v; i++){
                    System.out.print(i + " -> ");
                    List<Integer> edgeListNorm = reg.getEdge(i);
                    if (edgeListNorm.size() == 0)
                        System.out.print("null");
                    else {
                        for (int j = 1;; j++) {
                            if (j != edgeListNorm.size())
                                System.out.print(edgeListNorm.get(j - 1) + " -> ");
                            else {
                                System.out.print(edgeListNorm.get(j - 1));
                                break;
                            }
                        }
                    }
                    System.out.println();
                }
            }else{
                System.out.println("The graph adj list is too big");
            }
            System.out.println();
            
            for(;;){
            System.out.println("Choose the function what you want :");
            System.out.println("1.insert node");
            System.out.println("2.delete node");
            System.out.println("3.insert edge");
            System.out.println("4.delete edge");
        
            int choose = input2.nextInt();
            System.out.println();
            
            switch(choose){
                case 1:
                    System.out.println("Please enter the number of vertex you want to insert:");
                    int insNode = input2.nextInt();
                    System.out.println(v);
                    v = insertNode(v, insNode);
                    System.out.println(adjList.size());
                    List key1 = new ArrayList(adjList.keySet());
                    System.out.println(key1);
                    for(int i=0; i<key1.size(); i++){
                        System.out.print(key1.get(i) + " -> ");
                        List<Integer> edgeList = reg.getEdge((int)key1.get(i));
                        if (edgeList.size() == 0)
                            System.out.print("null");
                        else {
                            for (int j = 1;; j++) {
                                if (j != edgeList.size())
                                    System.out.print(edgeList.get(j - 1) + " -> ");
                                else {
                                    System.out.print(edgeList.get(j - 1));
                                    break;
                                }
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Please enter the vertex you want to remove:");
                    int delNode = input2.nextInt();
                    List key2 = new ArrayList(adjList.keySet());
                    v = removeNode(v, delNode, key2);
                    key2 = new ArrayList(adjList.keySet());
                    System.out.println(key2);
                    for(int i=0; i<key2.size(); i++){
                        System.out.print(key2.get(i) + " -> ");
                        List<Integer> edgeList = reg.getEdge((int)key2.get(i));
                        if (edgeList.size() == 0)
                            System.out.print("null");
                        else {
                            for (int j = 1;; j++) {
                                if (j != edgeList.size())
                                    System.out.print(edgeList.get(j - 1) + " -> ");
                                else {
                                    System.out.print(edgeList.get(j - 1));
                                    break;
                                }
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Please enter the edge position(i, j)");
                    int start = input2.nextInt();
                    int end = input2.nextInt();
                    setEdge(start, end);
                    List key3 = new ArrayList(adjList.keySet());
                    System.out.println(key3);
                    for(int i=0; i<key3.size(); i++){
                        System.out.print(key3.get(i) + " -> ");
                        List<Integer> edgeList = reg.getEdge((int)key3.get(i));
                        if (edgeList.size() == 0)
                            System.out.print("null");
                        else {
                            for (int j = 1;; j++) {
                                if (j != edgeList.size())
                                    System.out.print(edgeList.get(j - 1) + " -> ");
                                else {
                                    System.out.print(edgeList.get(j - 1));
                                    break;
                                }
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Please enter the edge position(i, j) you want to delete");
                    int begin = input2.nextInt();
                    int dest = input2.nextInt();
                    removeEdge(begin, dest);
                    List key4 = new ArrayList(adjList.keySet());
                    System.out.println(key4);
                    for(int i=0; i<key4.size(); i++){
                        System.out.print(key4.get(i) + " -> ");
                        List<Integer> edgeList = reg.getEdge((int)key4.get(i));
                        if (edgeList.size() == 0)
                            System.out.print("null");
                        else {
                            for (int j = 1;; j++) {
                                if (j != edgeList.size())
                                    System.out.print(edgeList.get(j - 1) + " -> ");
                                else {
                                    System.out.print(edgeList.get(j - 1));
                                    break;
                                }
                            }
                        }
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }
        /*}catch(Exception E){
            System.out.println("Something went wrong");
        }*/
            System.out.println();
            }
        
    }
    

    public static void main(String[] args) {
        System.out.print("The number of vertex : ");
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        
        createG(v);
        
        
    }

}
