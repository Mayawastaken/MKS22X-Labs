import java.util.*; //ummm its doing smth LOL fix at home
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private Queue<int[]> frontier = new ArrayDeque<int[]>(); //hmm do i do this here or in constructor HM idts cause start does that and its in const
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    if (frontier.size() == 0){
      return true;
    }
    return false;
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){ //i assume done runs first, if not add if size is 0 j dont do anything;
    int numOfFires = frontier.size();
    for (int i = 0; i < numOfFires; i++){
      int[] getfirst = new int[]{frontier.element()[0], frontier.element()[1]};
      //if we aint outta bounds
      if (getfirst[0] < map.length-1){
        if (map[getfirst[0]+1][getfirst[1]] == TREE){
          frontier.add(new int[]{getfirst[0]+1, getfirst[1]});
          map[getfirst[0]+1][getfirst[1]] = FIRE;
        }
      }
      if (getfirst[0] > 0){
        if (map[getfirst[0]-1][getfirst[1]] == TREE){
          frontier.add(new int[]{getfirst[0]-1, getfirst[1]});
          map[getfirst[0]-1][getfirst[1]] = FIRE;
        }
      }
      if (getfirst[1] < map[0].length-1){ //assumes at least 1 col
        if (map[getfirst[0]][getfirst[1]+1] == TREE){
          frontier.add(new int[]{getfirst[0], getfirst[1]+1});
          map[getfirst[0]][getfirst[1]+1] = FIRE;
        }
      }
      if (getfirst[1] > 0){ //assumes square
        if (map[getfirst[0]][getfirst[1]-1] == TREE){
          frontier.add(new int[]{getfirst[0], getfirst[1]-1});
          map[getfirst[0]][getfirst[1]-1] = FIRE;
        }
      }
      map[(frontier.element())[0]][(frontier.element())[1]] = ASH;
      frontier.remove();
      //if r, c+1 is tree make fire etc 4 times and add it to frontier
      //add new fires
    }

    //leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    ticks++;
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        frontier.add(new int[]{i, 0});
      }
    }
  }

  public static double averageTicks(int runs, int squareSize, double density){
    double totalTicks = 0;
    for (int i = 1; i <= runs; i++){
      BurnTrees b = new BurnTrees(squareSize, squareSize, density);
      int current = b.run();
      totalTicks += current;
      //System.out.println(current);
    }
    return ((totalTicks) / runs);
  }

    public static void main(String[]args){
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .7;
      if (args.length == 0){
        System.out.println("TABLE 1: Size 100x100 Board, 100 Repetitions Averaged per Density (5% to 95% with increments of 5%)");
        System.out.println("Density (%) | Avg Ticks");
        System.out.println("------------------------");
        System.out.println("   " + "5" + "%       |   " + averageTicks(100, 100, .05));
        for (double i = .10; i < .97; i += .05){
          System.out.println("   " + Math.round(i*100) + "%      |   " + averageTicks(100, 100, i));
        }
        System.out.println("");
        System.out.println("TABLE 2: Size 100x100 Board, 100 Repetitions Averaged per Density (60% to 65% with increments of 1%)");
        System.out.println("Density (%) | Avg Ticks");
        System.out.println("------------------------");
        for (double i = .6; i <= .655; i += .01){
          System.out.println("   " + Math.round(i*100) + "%      |   " + averageTicks(100, 100, i));
        }
      }
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


      int ans = b.animate(DELAY);//animate all screens
      System.out.println(ans);//print the final answer

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
