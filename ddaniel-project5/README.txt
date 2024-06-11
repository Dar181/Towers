What is the best solution to the 15-block problem?

Best subset: 4 5 6 10 11 12 13

Solve the 20-block, 21-block, and 22-block problems and list the times taken to solve each problem. You might want to
run each test two or three times and average the results to get better measurements. What do you notice about the
runtimes? Why does this result make sense given the design of the program?

20 block: time - 220ms, solution - 1 2 3 4 8 9 10 12 15 16 19
21 block: time - 402.667, - solution - 1 2 4 6 7 10 14 15 17 18 20 23
23 block: time - time 1545.67, solution 2 3 4 5 8 11 12 13 15 18 19 23

Runtimes increase because the worst case time scenario dependent on n and n increases.

Based on your empirical results from the previous question and your understanding of the time complexity of the
program, estimate how long it would take to solve the 50-block problem (you won’t want to actually run this). Specify
your answer in some reasonable time unit (hint: it shouldn’t be milliseconds for this scenario)!

At least 3x the time for 23 blocks...4.635 seconds
