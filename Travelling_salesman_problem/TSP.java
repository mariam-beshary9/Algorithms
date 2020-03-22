package tsp;

//import java.util.Scanner;

class Edge {
    String left ;
    String right;
    double weight;

    Edge (String l , String r, double w)
    {
     left = new String ();
     right=new String ();
     left = l;
     right = r;
     weight = w;
    }
}
class Vertex {
   String name ; 
   String [] neighbourVertices ;
   double [] neighbourWeights;
   int num = 0;
   Vertex (String n , Edge [] edges, int len)
   {   // System.out.println("Here2");
       
       name = new String ();
       name = n;
      //  System.out.println("Here2");
       neighbourVertices = new String [len-1];
       neighbourWeights = new double [len-1];
      //  System.out.println("Here2");
       for (int i=0 ; i<edges.length ; i++)
       {
           if (name.equals(edges[i].left))
           {
             //   System.out.println("Here2");
               if(!name.equals(edges[i].right)){
               neighbourVertices[num]=edges[i].right;
               neighbourWeights[num]=edges[i].weight;
               num++;

           }}
       }
       
   }
}
class Graph {
    Vertex [] vertices ;
    String circuit;
    boolean []visited;
    Graph (String []v,Edge [] e)
    {// System.out.println("Here1");
        circuit = new String();
     //   System.out.println("Here1");
        circuit= "";
        vertices = new Vertex [v.length];
     //   System.out.println("Here1");
        visited = new boolean [v.length];
       //  System.out.println("Here1");
        for (int i=0 ; i<v.length ; i++)
        {
            
            vertices[i] = new Vertex (v[i],e,v.length);
            visited[i]=false;
           
        }
        //System.out.println("Here1");
    }
    int searchVertexByName(String vName)
    {
        for (int i=0 ; i<vertices.length ; i++)
        {
            if (vertices[i].name.equals(vName))
            {
                return i;
            }
        }
        
        return -1;
    }

     boolean finished ()
     {
        for (boolean visited1 : visited) {
            if (visited1==false) {
                return false;
            }
        }
         return true;
     }
    int getMin(Vertex v)
    {
        int index = 0;
        double min = v.neighbourWeights[0];
        for (int i=1 ; i<v.num ; i++)
        {
            System.out.println(v.neighbourWeights[i]);
            if ((v.neighbourWeights[i]<min)&&(!visited[searchVertexByName(v.neighbourVertices[i])])&&(v.neighbourWeights[i]!=0))
            {
                min = v.neighbourWeights[i];
                index = i;
            }
        }
        
        return index;
    }
    Vertex getFollowing(Vertex v)
    {
       int index = getMin(v);
       int indexOfFollowingVertex=searchVertexByName(v.neighbourVertices[index]);
       visited[indexOfFollowingVertex]=true ;
       return this.vertices[indexOfFollowingVertex];
    }

    String GetCircuit()
    {
        //System.out.println("Here0");
        Vertex temp, firstElement;
      //  System.out.println("Here1");
//        for (Vertex vertice : vertices) {
//            if ((vertice.num < (vertices.length/2)) && (vertices.length>2)) {
//                return "There is no Himlton circuit.";
//            }       
//        }
        //System.out.println("Here2");
        temp = vertices[0];
      //  System.out.println("Here3");
        firstElement=temp;
      //  System.out.println("Here4");
        visited[0]=true;
        circuit+=temp.name;
      //  System.out.println("Here5");
      int n3=0;
        while (!finished()){
        //   System.out.println("Here6");
            temp = getFollowing(temp);
            circuit+=" => "+ temp.name;
        //   System.out.println("Here7");
        n3++;
        if (n3>vertices.length)
        {
             return "There is no Himlton circuit.";
        }
        }
      //  System.out.println("Here8");
        for (int i=0 ; i<temp.num;i++)
        {
             if (temp.neighbourVertices[i].equals(firstElement.name))
             {
                 circuit+=" => "+ firstElement.name;
                 return circuit;
             }
        }
       
        return "There is no Himlton circuit.";
    }
    
}

public class TSP {

    
//    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        System.out.print("Enter number of vertices: ");
//        int nv = sc.nextInt();
//        String [] v = new String [nv];
//        for(int i=0 ; i<nv ; i++)
//        {
//            System.out.println("Enter vertices #"+(i+1)+" name: ");
//            v[i]=sc.next();
//        }
//        System.out.print("Enter number of Edges: ");
//        int ne = sc.nextInt();
//        Edge [] e = new Edge [ne];
//        for(int i=0 ; i<nv ; i++)
//        {
//            System.out.println("Enter Edge #"+(i+1) );
//            System.out.println("Enter left vertex of it:");
//            e[i].left = sc.next();
//            
//            System.out.print("Enter right vertex of it:");
//            e[i].right = sc.next();
//            System.out.print("Enter weight of it:");
//            e[i].weight = sc.nextDouble();
//            
//        }
//        Graph myGraph = new Graph (v, e);
//        System.out.println(myGraph.GetCircuit());
//        
//    }
//    
}
