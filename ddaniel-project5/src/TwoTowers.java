import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class representing two block towers of roughly equal height with a combined total n blocks.
 *
 * @author Darvensky Daniel
 * @version 1.0 Build 2024.04.10
 */
public class TwoTowers {
    /**
     * Main function demonstrating the use of the TwoTowers class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args){
        Scanner fileInput = new Scanner(System.in);
        System.out.print("Enter number of blocks: ");
        int file = fileInput.nextInt();
        solve(file);
    }

    /**
     * Number of blocks to make two towers of.
     */
    public static int numBlocks = -1;
    /**
     * The optimal height if the two towers were equal in height.
     */
    public static double targetHeight = -1;
    /**
     * The optimal subset in which the shorter tower is as close to the optimal height as possible.
     */
    public static String bestSubset = "";
    /**
     * The best height that can be achieved with the given blocks.
     */
    public static double bestHeight = -1;
    /**
     * The distance of the shorter tower from the most optimal height of the towers.
     */
    public static double distanceFromOptimal = -1;
    /**
     * Duration for code to run
     */
    public static long duration = -1;

    /**
     * Creates a list of heights of the blocks and finds the target height.
     *
     * @param numberOBlocks The number of blocks to be used.
     * @return The list of heights of the blocks.
     */
    public static ArrayList<Double> heightList(int numberOBlocks) {
        ArrayList<Double> allHeights = new ArrayList<>();
        double heights = 0;

        for (int i = 1; i <= numberOBlocks; i++) {
            heights += Math.sqrt(i);
            allHeights.add((double) i);
        }
        targetHeight = heights/2;
        return allHeights;
    }

    /**
     * Find the height that's as close to optimal as possible and the associated subset.
     *
     * @param numberOBlocks The number of blocks to be used.
     * @return The subset that makes up the shorter tower which is as close optimal as possible
     */
    public static ArrayList<Long> bestHeightAndSub(int numberOBlocks) {
        SubsetIterator heightsIter = new SubsetIterator<>(heightList(numberOBlocks));
        double currBestHeight = 0;
        ArrayList<Long> currBestSub = new ArrayList<>();

        while (heightsIter.hasNext()) {
            ArrayList<Long> tempSub = new ArrayList<>();
            double subSum = 0;

            for (Object numb : heightsIter.next()) {
                subSum += Math.sqrt((double)numb);
                tempSub.add(Math.round((double)numb));
                if (subSum > currBestHeight && subSum <= targetHeight) {
                    currBestHeight = subSum;
                    currBestSub = tempSub;
                }
            }
        }

        bestHeight = currBestHeight;
        return currBestSub;
    }

    /**
     * Solves the optimal height, the best achieved height, the associated height, and the time
     * to run the code.
     *
     * @param numberOBlocks The blocks to be used.
     */
    public static void solve(int numberOBlocks) {
        long startTime = System.currentTimeMillis();

        for (Object numb : bestHeightAndSub(numberOBlocks)) {
            bestSubset += numb + " ";
        }

        numBlocks = numberOBlocks;
        distanceFromOptimal = targetHeight - bestHeight;
        duration = System.currentTimeMillis() - startTime;

        System.out.println("Target (optimal) height: " + targetHeight);
        System.out.println("Best subset: " + bestSubset);
        System.out.println("Best height: " + bestHeight);
        System.out.println("Distance from optimal: " + distanceFromOptimal);
        System.out.println("Solve duration: " + duration + " ms");
    }
}
