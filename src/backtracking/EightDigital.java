package backtracking;

import java.util.Scanner;  

class Status{  
    char operation;  
    int number, index, previous;  
}  
  
public class EightDigital{  
    static int Max = 363000;  //总得状态数量， 9!=362880  
    static Status[] q;  
    static int head;  
    static int tail;  
    static int factorial[] = {1,1,2,6,24,120,720,5040,40320};  
    static int Pow[] = {100000000,10000000,1000000,100000,10000,1000,100,10,1};  
    static boolean[] vis;
    // 全排列的hash函数。  
    static int permutationToNumberHash(int num){   
        int i, j;  
        int[] n=new int[10];  
        for(i = 0; i < 9; i ++){  
            n[i] = num % 10;  
            num /= 10;  
        }  
        int c, key = 0;  
        for(i = 1; i < 9; i ++){  
            for(c = 0, j = 0; j < i; j ++)  
                if(n[j] < n[i])   
                    c ++;  
            key += c * factorial[i];  
        }  
        return key;  
    }  
      
    static void exchangeLocation(int num, int a, int b, char op){ // 操作：第a个数和第b个数交换。  
        int n1, n2;  
        n1 = num / Pow[a] % 10;  
        n2 = num / Pow[b] % 10;  
        num = num - (n1-n2)*Pow[a] + (n1-n2)*Pow[b]; //移动后的数字大小  
        int key = permutationToNumberHash(num);  
        if(!vis[key]){  
            vis[key] = true;  
            q[tail].operation = op;  
            q[tail].number = num;  
            q[tail].previous = head;  
            q[tail ++].index = b;  
        }  
    }  
    static int res = 0;
    static void output(int k){
    	res ++;
        if(q[k].operation != 0){  
           output(q[k].previous);  
        }  
    }  
  public static void main(String args[]){  
     Scanner sc=new Scanner(System.in);  
     while (sc.hasNext()) {
    	 q  =new Status[Max];
    	 vis=new boolean[Max];
    	 int min = Integer.MAX_VALUE;
    	 int i, num, id , t;  
         char c;  
         id = -1;  
         //读入数据，用9代替x,用一个十进制数表示读入数据。  
         for(num = i = 0; i < 9; i ++){  
             c=sc.next().charAt(0);  
             if(c == 'x'){  
                 t = 9;  
                 id = i;  
             }else   
                 t = c - '0';  
             num = 10 * num + t;//顺序存储  
         }  
         //初始化每一个状态  
         for(i=0;i<Max;i++){  
             q[i]=new Status();  
         }  
         boolean flag = false;  
         head = 0;  
         tail = 1;  
         //q[0]表示x所在的的id和状态数  
         q[0].index = id;  
         q[0].number = num;  
         //广度搜索找出一条路径，最后的数是123456789.  
         /*具体实现： 
          * 遍历每个状态从0开始，记录可以到达的状态（一次最多可以到达四个）。直到num=123456789。 
          * 例如，0可以到1、2、3，而1可以到4、5,2可以到6、7，...并用 q[tail].pre = head记录之前的的结点，这样到最后 
          * 的最终结点往前遍历就可以了。q[tail].op = op记录了操作，输出操作就可以了。 
          * */  
         while(tail > head && !flag){  
             int cnt = tail - head;  
             while(cnt --!=0){  
                 num = q[head].number;  
                 if(num == 123495678){  
                     flag = true;
                     res = 0;
                     output(head);
                     if(res < min){
                    	 min = res;
                     }
                     continue;  
                 }  
                 id = q[head].index;  
                 //注意这里的移动方向是指数的移动方向，不是X的移动方向  
                 //还有id的范围是0~8  
                 /* 0 1 2 
                  * 3 4 5 
                  * 6 7 8 
                  */  
                 if(id % 3 != 2)   //如果id不是2,5,8就可以向右移动  
                     exchangeLocation(num, id, id + 1, 'r');  
                 if(id % 3 != 0)   //如果id不是0,3,6就可以向左移动  
                     exchangeLocation(num, id, id - 1, 'l');  
                 if(id > 2)        //如果id大于2就可以向上移动  
                     exchangeLocation(num, id, id - 3, 'u');  
                 if(id < 6)         //如果id小于6就可以向下移动  
                     exchangeLocation(num, id, id + 3, 'd');  
                 head ++;  
             }  
         }  
         if(flag){ 
//            output(head);
         	System.out.println(min); 
         }
         else   
             System.out.println("-1");  
     }
        
  }   
}  