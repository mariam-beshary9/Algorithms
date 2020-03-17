/*
 * Task 4 - problem 1  Algorithms
 * Mariam Ahmed Amin     
 * 20170279     CS G5 
 */
package disjointset;

import java.util.Scanner;

public class DisjointSet {

   private  int []rank;
   private  int []parent;
   private  int clustersNum;
   private  int [] network;
   private  int citizens;
    DisjointSet (int n)
    {
        citizens = n;
        clustersNum=n;
        rank   = new int [n];
        parent = new int [n];
        network = new int [n];
        for (int i=0 ; i< n ; i++)
        {
            parent[i]=i;
            rank[i]=1;
            network[i]=1;
        }
    }
    int getRoot(int n)
    {
      if (parent[n]!=n)
      {
         parent[n]=getRoot(parent[n]);
      }
      return parent[n];
    }
    void union (int n1,int n2)
    {
        int root1 = getRoot(n1-1);
        int root2 = getRoot(n2-1);
        
        if (root1==root2)
        {  // do not need to union because they both are in the same cluster and have same community
           // System.out.println(n1+" and "+n2+" already are in the same network.");
            
            return;
        }
        else{
            // if we need union
            
            //get the least rank to optimize the algorithm to let the height less
            if(rank[root1]<rank[root2])
            {
                parent[root1] = root2;
                network[root2]++;
            }
            else if(rank[root2]<rank[root1])
            {
                parent[root2] = root1;
                network[root1]++;
            }
            else { // now we choose any one to be the root
                
                parent[root2]= root1;
                rank[root1]++;
                network[root1]++;
            }
            
        }
    }
    
    int getClustersNum ()
    {
        return clustersNum;
    }
    int getMaxNetworkNum()
    {
        int max = network[0];
        for (int i=0 ; i<citizens ; i++)
        {
            if(network[i]>max)
            {
                max = network [i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int numOfCities=sc.nextInt();
        for(int i=0 ; i<numOfCities ; i++)
        {
            int numberOfCitizens = sc.nextInt();
            int numberOfFriendships=sc.nextInt();
            DisjointSet ds = new DisjointSet(numberOfCitizens);
            for (int j=0 ; j<numberOfFriendships ; j++)
            {
                int friend1 = sc.nextInt();
                int friend2 = sc.nextInt();
                ds.union(friend1, friend2);
            }
           
           System.out.println(ds.getMaxNetworkNum());
            
        }
  
    }
    
}
