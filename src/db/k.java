package db;

class Data {
	int w, v;

	Data(int nw, int nv) {
		w = nw;
		v = nv;
	}

	Data add(Data r) {
		return new Data(w + r.w, v + r.v);
	}

	boolean isEqual(Data r) {
		return (w == r.w) && (v == r.v);
	}
}

public class k {
	
	static int N = 10000;
	static int M = 1000000;
	static Data goods[] = new Data[N];
	static Data table[] = new Data[M];
	static int n,c;
	
	static int GKnapSack() {
		int i, k, j, l, r, next;
		Data temp;
		table[0] = new Data(0, 0);
		l = r = 0;
		next = 1;
		for (i = 1; i <= n; ++i) {
			k = l;
			for (j = l; j <= r; ++j) {
				if (table[j].w + goods[i].w > c)
					break;
				temp = table[j].add(goods[i]); // p[i]
				while (k <= r && table[k].w != 0) {
					table[next] = table[k];
					++next;
					++k;
				}
				if (k <= r && table[k].w == temp.w) {
					temp.v = Math.max(temp.v, table[k].v);
					++k;
				}
				if (temp.v > table[next - 1].v) {
					table[next] = temp;
					++next;
				}
				while (k <= r && table[k].v <= table[next - 1].v)
					++k;
			}
			while (k <= r) {
				table[next] = table[k];
				++next;
				++k;
			}

			l = r + 1;
			r = next - 1;
		}
		return table[next - 1].v;
	}

	public static void main(String[] args){
	    n = 5;
	    c = 10;
	    int[] weight = {2,2,6,5,4};
	    int[] value = {6,3,5,4,6};
	    
	    for(int i = 1 ; i <= n ; ++i)
	    {
	    	goods[i] = new Data(weight[i-1],value[i-1]);
	    }

	    System.out.println(GKnapSack());
	}
}
