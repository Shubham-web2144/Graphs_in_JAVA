package com.ShubhamWork;
import java.util.*;

public class Main {
    private LinkedList<Integer> adj[];

    public Main(int v){
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }

//    BFS Algorithm
    public int BFS(int source, int dest){
        boolean isVis[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        parent[source] = -1;
        isVis[source] = true;

        while (!q.isEmpty()){
            int curDest = q.poll();
            if(curDest == dest){
                break;
            }

            for(int neighbor: adj[curDest]){
                if(!isVis[neighbor]){
                    isVis[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = curDest;
                }
            }
        }

        int cur = dest;
        int dist = 0;

        while (parent[cur] != -1){
            System.out.print(cur + "->");
            cur = parent[cur];
            dist++;
        }
        return dist;
    }

//    DFS Algorithm

    public boolean dfsUtil(int source, int destination, boolean isVis[]){
        if(source == destination){
            return true;
        }

        for(int neighbor: adj[source]){
            if(!isVis[neighbor]){
                isVis[neighbor] = true;
                boolean isConnected = dfsUtil(neighbor, destination, isVis);
                if(isConnected){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsStack(int source, int destination){
        boolean isVis[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        isVis[source] = true;
        parent[source] = -1;

        Stack<Integer> s = new Stack<>();

        s.push(source);
        while (!s.isEmpty()){
            int cur = s.pop();
            if(cur == destination){
                return true;
            }
            for(int neighbor: adj[cur]){
                if(!isVis[neighbor]){
                    isVis[neighbor] = true;
                    s.push(neighbor);
                }
            }

        }
        int curPoint = destination;
        int path = 0;
        while (parent[curPoint] != -1){
            System.out.println(curPoint + " => ");
            curPoint = parent[curPoint];
            path++;
        }
        System.out.println("Path is " + path);
        return false;
//        return path;
    }

    public boolean DFS(int source, int destination){
        boolean isVis[] = new boolean[adj.length];
        isVis[source] = true;

        return dfsUtil(source, destination, isVis);
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertics and edges :");
        int v = sc.nextInt();
        int e = sc.nextInt();

        Main m = new Main(v);
        System.out.println("Enter "+ e + "edges");
        for(int i = 1; i < e; i++){
            try{
                int source = sc.nextInt();
                int dest = sc.nextInt();

                m.addEdge(source, dest);
            }catch (ArrayIndexOutOfBoundsException err){
                System.out.println(err);
            }
        }

        System.out.println("Enter source and destination : ");
        int s = sc.nextInt();
        int d = sc.nextInt();
//        int path = m.BFS(s,d);
//        System.out.println("Min path is " + path);

        System.out.println("Possible path is " + " " + m.dfsStack(s,d));
    }
}
