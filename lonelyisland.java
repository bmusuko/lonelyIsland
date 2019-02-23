import java.io.*; 
import java.util.*; 

public class lonelyisland {
	
	public LinkedList<Integer> copyList(LinkedList<Integer> list){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Iterator<Integer> maju = list.iterator();
		int x;
		while(maju.hasNext()){
			x = maju.next();
			temp.add(x);
		}
		return temp;
	}

	public class Graph{
		private int simpul;
		private LinkedList<Integer> sisi[];
		private int awal;		
		//ctor
		
		Graph(int simpul,int awal){
			this.simpul = simpul;
			this.awal = awal;
			sisi = new LinkedList[simpul+1];
			for(int i=1;i<=simpul;i++){
				sisi[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int simpulAwal,int simpulAkhir){
			sisi[simpulAwal].add(simpulAkhir);
		}
		
		void jelajahRekursif(int s,LinkedList<Integer> save){
			int l,c;
			LinkedList<Integer> save2 = copyList(save);
			save2.add(s);
			Iterator<Integer> maju = sisi[s].iterator();
			if(!maju.hasNext()){
				System.out.println("Lonely Island : "+s);
				System.out.println("Dengan Jalur : "+save2);
			} else{
				c =0;
				while(maju.hasNext()){
					l = maju.next();
					// System.out.println(l);
					if(save2.indexOf(l) == -1){
						jelajahRekursif(l,save2);
						c++;
					} 
				}
				if(c==0){
				System.out.println("Lonely Island : "+s);
				System.out.println("Dengan Jalur : "+save2);
				}
			}
		}
		void jelajah(){
			int l;
			LinkedList<Integer> save;
			save = new LinkedList<Integer>();
			save.add(awal);
			Iterator<Integer> maju = sisi[awal].iterator();
			if (!maju.hasNext()){
				System.out.println("Lonely Island : "+awal);
				System.out.println("Dengan Jalur : "+save);
			}
			while(maju.hasNext()){
				l = maju.next();
				jelajahRekursif(l,save);
			}
		}
	}
    public void start() throws Exception{
    	int n,m,r,u,v;
    	Scanner reader = new Scanner(new File("output.txt"));
        System.out.println("Welcome To Lonely Island");
        // System.out.print("Masukkan jumlah simpul: ");
        n = reader.nextInt();
        // System.out.print("Masukkan jumlah sisi: ");
        m = reader.nextInt();
        // System.out.print("Masukkan simpul awal: ");
        r = reader.nextInt();
        Graph g = new Graph(n,r);
        for(int i=1;i<=m;i++){
        	// System.out.print("Masukkan simpul (u v) ke - "+i+" : ");
        	u = reader.nextInt();
        	v = reader.nextInt();
        	g.addEdge(u,v);
        }
        g.jelajah();
    }

	public static void main(String[] args) throws Exception{
		long startTime = System.nanoTime();
		lonelyisland lonelyisland = new lonelyisland();
		lonelyisland.start();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Total waktu runtime : " + (totalTime/1000000)+" ms");
	}

}