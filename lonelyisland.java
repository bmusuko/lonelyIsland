import java.io.*; 
import java.util.*; 

public class lonelyisland {

	public class Graph{ //class graph
		private int simpul;
		private LinkedList<Integer> sisi[];
		private int awal;		
		private boolean visited[];
		private boolean pulau[];
		
		Graph(int simpul,int awal){
			this.simpul = simpul;
			this.awal = awal;
			sisi = new LinkedList[simpul+1];
			for(int i=1;i<=simpul;i++){
				sisi[i] = new LinkedList<Integer>();
			}
			visited = new boolean[simpul+1];
			pulau = new boolean[simpul+1];
		}
		void addEdge(int simpulAwal,int simpulAkhir){
			sisi[simpulAwal].add(simpulAkhir);
		}
		void jelajahRekursif(int s,LinkedList<Integer> save){ 
			int l,c;
			save.add(s);
			visited[s] = true; 
			Iterator<Integer> maju = sisi[s].iterator();
			if(!maju.hasNext()){
				System.out.println("Lonely Island : "+s);
				System.out.println("Dengan Jalur : "+save);
				pulau[s] = true;
			} else{
				c =0;
				while(maju.hasNext()){
					l = maju.next();
					if(!visited[l]){
						jelajahRekursif(l,save);
						c++;
					} 
				}
				if(c==0){
					System.out.println("Lonely Island : "+s);
					System.out.println("Dengan Jalur : "+save);
					pulau[s] = true;
				}
			}
			visited[s] = false;
			save.remove(save.size()-1);
		}
		void printPulau(){
			System.out.println("Daftar Pulau yang dapat membuat pemain terjebak :");
			for(int i=1;i<=simpul;i++){
				if(pulau[i]){
					System.out.println(i);
				}
			}
		}
		void jelajah(){
			int l;
			LinkedList<Integer> save;
			save = new LinkedList<Integer>();
			save.add(awal);
			visited[awal] = true;
			Iterator<Integer> maju = sisi[awal].iterator();
			if (!maju.hasNext()){
				System.out.println("Lonely Island : "+awal);
				System.out.println("Dengan Jalur : "+save);
			}
			while(maju.hasNext()){
				l = maju.next();
				jelajahRekursif(l,save);
			}
			printPulau();
		}
	}

    public void start() throws Exception{ // membaca file dan memanggil rekursif
    	int n,m,r,u,v;
    	Scanner reader = new Scanner(new File("input.txt"));
        System.out.println("Welcome To Lonely Island");
        n = reader.nextInt();
        m = reader.nextInt();
        r = reader.nextInt();
        Graph g = new Graph(n,r);
        for(int i=1;i<=m;i++){
        	u = reader.nextInt();
        	v = reader.nextInt();
        	g.addEdge(u,v);
        }
        g.jelajah();
    }

	public static void main(String[] args) throws Exception{ // main program
		long startTime = System.nanoTime();
		lonelyisland lonelyisland = new lonelyisland();
		lonelyisland.start();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Total waktu runtime : " + (totalTime/1000000)+" ms");
	}

}