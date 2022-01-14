package com.ShubhamWork;

import java.util.*;

public class DFS {
    private LinkedList<Integer> adj[];

    public DFS(int v){
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdges(int s, int d){
        adj[s].add(d);
        adj[d].add(s);
    }

    public boolean dfsUtil(int s, int d, boolean vis[]){
        if(s == d){
            return true;
        }

        for(int n : adj[s]){
            if(!vis[n]){
                vis[n] = true;
                boolean isConn = dfsUtil(n, d, vis);
                if(isConn){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsStack(int s, int d){
        boolean isVis[] = new boolean[adj.length];
        isVis[s] = true;

        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.isEmpty()){
            int cur = stack.pop();
            if(cur == d){
                return true;
            }

            for(int n: adj[cur]){
                if(!isVis[n]){
                    isVis[n] = true;
                    stack.push(n);
                }
            }
        }

        return false;
    }

    public boolean dfs(int s, int d){
        boolean isVis[] = new boolean[adj.length];
        isVis[s] = true;
        return dfsUtil(s, d, isVis);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vertics and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        DFS d = new DFS(v);
        System.out.println("Enter edges");
        for(int i = 1; i <= e; i++){
            try{
                System.out.println("Enter First point");
                int e1 = sc.nextInt();
                System.out.println("Enter second point");
                int e2 = sc.nextInt();

                d.addEdges(e1,e2);
            }
            catch (ArrayIndexOutOfBoundsException arr){

            }
        }

        System.out.println("Enter starting point");
        int sp = sc.nextInt();
        System.out.println("Enter ending point");
        int ep = sc.nextInt();

        System.out.println(d.dfsStack(sp, ep));

    }
}
