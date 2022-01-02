import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
  
public class game extends Applet implements KeyListener
{
		   String s,sc;
		   
	       Image img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
		   int j=0,y,i=1,k=0,l=0,x,xb=1500,yb=100,t,u,xbe,ybe,n=0,xbb1=0,xbb2=1250,b=0,ss=0,sx=0,sse=0,flag=0,xbbe,ybbe,z;
		   
           AudioClip au,au1,au2;   
		   
        public void init(){
			           y=50;
					   x=50;
                addKeyListener(this);
				au=getAudioClip(getCodeBase(),"soundmain.wav");
				au1=getAudioClip(getCodeBase(),"boom.wav");
				au2=getAudioClip(getCodeBase(),"sky.wav");
				img0=getImage(getCodeBase(),"background.jpg");
               			img1=getImage(getCodeBase(),"m.png");
				img2=getImage(getCodeBase(),"boom.jpg");
				img3=getImage(getCodeBase(),"eagle.png");
				img4=getImage(getCodeBase(),"connection.jpg");
				img5=getImage(getCodeBase(),"copter.png");
				img6=getImage(getCodeBase(),"fback.jpg");
				img7=getImage(getCodeBase(),"f1back.jpg");
				img9=getImage(getCodeBase(),"connection1.jpg");
				img10=getImage(getCodeBase(),"enemyjet.png");
			
			}
		
		 //key & our plane controll section!!!!!
		
	    public void keyPressed(KeyEvent m) {
		int keyCode=m.getKeyCode();
		if (keyCode==KeyEvent.VK_UP)
		{
		i=1;
		y=y-30;
		i=0;
		}
		if (keyCode==KeyEvent.VK_DOWN)
		{
		j=1;
		y=y+10;
		j=0;
		}
		if (keyCode==KeyEvent.VK_RIGHT)
		{			
		k=1;
		x=x+10;
		k=0;
		}
		if (keyCode==KeyEvent.VK_LEFT)
		{
		l=1;
		x=x-10;
		l=0;
		}
			
		
  }
   public void keyReleased(KeyEvent evt) {}

  public void keyTyped(KeyEvent evt) {}
  
     
	
		  public void paint(Graphics g){
			if(flag==0){
		 au.play();
		  update(g);
		  }
        }
				
        public void update(Graphics g){
			
			//score & level section!!!!!!!
			
		showStatus("score : "+s+"               "+"LEVEL : "+sc); 
		s=""+ss;
		sc=""+sse;
		ss++;
		sx++;
		
		if(sx>300)
		{		
	  		sse++;
			sx=0;
			}
	
		//background image section!!!!
			 
			 
			 g.drawImage(img6,xbb1,0,this);
			xbb1--;
			g.drawImage(img7,xbb2,0,this);
			xbb2--;
				if(xbb2==0){
					xbb1=1250;
				}
				if(xbb1==0){
					xbb2=1250;
				}
			
			// gamer plan image
	      	  g.drawImage(img1,x,y,this);
			  	y++;
			  
			  
			  //enemy planes and birds section!!!!!!
			  
			  	//bird
			   t=(int)(Math.random()*580);
			  	xb=xb-(4+sse);
				if(xb<0){
					yb=0;
					xb=1200;
					yb=yb+t;
				}
				 g.drawImage(img3,xb,yb,this);
				 
				 
				 //helicopter!!!!!!!!
				
				if(sse>4){				
			 u=(int)(Math.random()*600);
			  	xbe=xbe-(4+sse);
				if(xbe<10){
					ybe=0;
					xbe=1200;
					ybe=ybe+u;
				}
			 g.drawImage(img5,xbe,ybe,this);
				}
				
				//enemy jet!!!
				
					if(sse>7){				
			 z=(int)(Math.random()*600);
			  	xbbe=xbbe-(4+sse);
				if(xbbe<10){
					ybbe=0;
					xbbe=1200;
					ybbe=ybbe+z;
				}
			 g.drawImage(img10,xbbe,ybbe,this);
				}


			 		 	        	
										
				try{
					Thread.sleep(10);
				}
				catch(InterruptedException e){}
				
				//hit,out of range & crashed section!!!!!!!!!
										
				
				if(y>750||y<-100||((x+150>xb&&xb>x-150)&&(y+50>yb&&y-50<yb))){
							
					flag=1;
					if(y<-100)
					{
						 au.stop();
						 au2.play();
						g.drawImage(img4,0,0,this);
						
					}
					else{
						 au.stop();
						 au1.play();
					g.drawImage(img2,0,0,this);
					}
		 
				}
				else if(((x+150>xbe&&xbe>x-150)&&(y+50>ybe&&y-50<ybe))&&(sse>4)){
					
					 flag=1;
					 au.stop();
					 au1.play();
					g.drawImage(img2,0,0,this);
					}
					
					else if(((x+150>xbbe&&xbbe>x-150)&&(y+50>ybbe&&y-50<ybbe))&&(sse>7)){
					
					 flag=1;
					 au.stop();
					 au1.play();
					g.drawImage(img2,0,0,this);
					}
					
					
				else if(x>1300||x<-200)
					{	
				            flag=1;
							 au.stop();
							  au1.play();
						g.drawImage(img9,0,0,this);
					}
					
					
				else{
					  repaint();
					   }
			
              
        }
        }
/*
        <applet code = "game.class" width = 1250 height = 700>
             
        </applet>
*/