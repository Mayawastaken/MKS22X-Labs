1. Why did you choose the board size for your finalized table?
  * I chose to use a 100 by 100 board for my finalized table as it is not too large such that it takes a while to finish and is inefficient to test many trials with, but also not too small so that trials where the trees immediately burn out or become disconnected do not often occur (of course, I could have chosen a 99x99 or 101x101 etc. without much of a difference, but 100 is a nice number).
2. Why did you choose the number of repetitions size for your finalized table?
  * I chose to use 100 repetitions for similar reasons as my 100 by 100 board: 100 is a nice number, 100 repetitions will probably help to eliminate a big effect that outlier repetitions/trials could have on smaller boards, and 100 repetitions won't take too long to finish as opposed to larger amounts of repetitions.
3. What did your testing show about changing the board size?
  * Smaller board sizes yielded more inconsistent average burn time (ticks), as there are less spots for trees to be, thus not being as accurate for a given density. Also, of course, smaller board sizes yielded overall lower average burn time than larger board sizes.
4. Knowing that there were differences based on board size, what was the relationship between the board size and the maximum burn time? How did you test this?
  * The relationship between the board size and maximum burn time is a positive/direct correlation, which I've tested by using board sizes from 5x5 up to 100x100 (with increments in each dimension by 5). The results showed positive growth in burn time as the boards became larger.
5. What density of trees yields the maximum burn time?
  * For my 100 by 100 board with 100 repetitions/trials, the density I found to yield the maximum burn time (or ticks) was around a 62% density.
***
Two tables include a header that tells the number of repetitions and board size chosen. The size/repetitions can be different
One table from 5% to 95% density in 5% intervals.
The other table from x% to y% density in 1% intervals, where x and y are around the maximum.


## TABLE 1: Size 100x100 Board, 100 Repetitions Averaged per Density (5% to 95% with increments of 5%)

| Density (%)     | Avg Ticks    |
| :------------- | :------------- |
   5%       |   32.63
   10%      |   2.0
   15%      |   2.77
   20%      |   3.64
   25%      |   5.41
   30%      |   6.27
   35%      |   8.64
   40%      |   11.74
   45%      |   18.7
   50%      |   29.41
   55%      |   64.47
   60%      |   179.67
   65%      |   175.58
   70%      |   145.48
   75%      |   131.01
   80%      |   122.34
   85%      |   115.62
   90%      |   110.49
   95%      |   106.29




## TABLE 2: Size 100x100 Board, 100 Repetitions Averaged per Density (60% to 65% with increments of 1%)

| Density (%)     | Avg Ticks    |
| :------------- | :------------- |
   60%      |   175.86
   61%      |   205.45
   62%      |   209.54
   63%      |   195.69
   64%      |   186.37
   65%      |   172.89

(Note: As I am not using seeds/storing each trial, the 60% and 65% averages are slightly different between tables, as a new 100 repetitions/trials are ran. Of course, when BurnTrees is run, in my main, the percentages will also be slightly different.)
