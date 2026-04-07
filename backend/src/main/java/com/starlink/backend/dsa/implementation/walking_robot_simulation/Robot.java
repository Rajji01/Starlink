package com.starlink.backend.dsa.implementation.walking_robot_simulation;

class Robot {
    int w;
    int h;
    int dir[][]={{1,0},{0,1},{-1,0},{0,-1}}; // E N W S
    int x,y;
    int curDir=0;
    public Robot(int width, int height) {
       this.w=width;
       this.h=height; 
       this.x=x;
       this.y=y;
    }
    
    public void step(int num) {
      int perimeter = 2*(w-1) + 2*(h-1);
    num = num % perimeter;
    
    if(num == 0) {
        // Full loop → direction South ho jaati hai
        // Lekin sirf agar (0,0) pe ho!
        // Actually: 1 step simulate karo direction fix ke liye
        num = perimeter; // pura loop simulate karo
        // Ya seedha: curDir ko track karo
    }

   
     calc(num,curDir);
    }
    
    private void calc(int n,int curDir){
        int i=0;
  
        while(i<n){
                //   System.out.println("x="+x+" y="+y+"curDir="+curDir+" w="+w+"  h="+h);
                //   System.out.println(dir[curDir][0]+" "+dir[curDir][1]);
            int newx=x+dir[curDir][0];
            int newy=y+dir[curDir][1];
            //    System.out.println("nx="+newx+" ny="+newy);
            if(newx<0|| newx>=w||newy<0||newy>=h){
                // System.out.println("case");
                curDir=(curDir+1)%4;
                //   System.out.println("curDir="+curDir);
            }
            // else{
             x+=dir[curDir][0];
            y+=dir[curDir][1];
             i++;
            // }
           
           
        }
         this.curDir = curDir; // ✅ loop ke baad update karo!
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        if(curDir==0) return "East";
        else if(curDir==1) return "North";
        else if(curDir==2)return "West";
        else return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */