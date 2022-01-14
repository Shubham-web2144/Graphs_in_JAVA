package com.ShubhamWork;
import java.util.*;


public class BFS {
    private LinkedList<Integer> adj[];

    public BFS(int v){
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdges(int s, int e){
        adj[s].add(e);
        adj[e].add(s);
    }

//    BFS Algorithm

    public int bfsAlgo(int sp, int fp){
        int len = adj.length;
        int patrent[] = new int[len];
        boolean isVisted[] = new boolean[len];
        Queue<Integer> q = new LinkedList<>();

        q.add(sp);
        patrent[sp] = -1;
        isVisted[sp] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur == fp) break;

            for(int n : adj[cur]){
                if(!isVisted[n]){
                    isVisted[n] = true;
                    q.add(n);
                    patrent[n] = cur;
                }
            }
        }

        int curDest = fp;
        int path = 0;

        while (patrent[curDest] != -1){
            System.out.print(curDest + "=>");
            curDest = patrent[curDest];
            path++;
        }

        return path;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertics :");
        int vertics = sc.nextInt();
        System.out.println("Enter number of edges :");
        int edges = sc.nextInt();

        BFS bfs = new BFS(vertics);

        System.out.println("Enter " + edges + " edges");
        for(int i = 0; i < edges; i++){
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

         bfs.addEdges(e1,e2);
        }

        System.out.println("Enter starting destination : ");
        int sd = sc.nextInt();
        System.out.println("Enter final destinatio : ");
        int fd = sc.nextInt();

        int root = bfs.bfsAlgo(sd, fd);
        System.out.println("Minimum path is " + root);
    }
}
