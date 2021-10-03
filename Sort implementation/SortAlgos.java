import java.util.*;
// implementation fo selection, insertion, tree and heap sort
// compare their running time for ascending, random, and descending data.
// each group of data's size range from 2 ** 0 to 2 ** 16
public class SortAlgos {
    
    public static void main(String[] args) {
        
        long[][] times = new long[3][17];
        SortAlgos sort = new SortAlgos();
        
        // generate testing data.
        // 1. ascending from 2 ** 0 to 2 ** 16
        // 2. random from 2 ** 0 to 2 ** 16
        // 3. descending 2 ** 0 to 2 ** 16
        for (int p = 0; p < 17; p++) {
            double size = Math.pow((double)2, (double)p);
            
            // ascending data
            int[] curr_ascending = new int[(int)size];
            for (int i = 0; i < (int)size; i++) {
                curr_ascending[i] = i;
            }
            
            // random data
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < (int)size; i++) {
                list.add(i);
            }
            int[] curr_random = new int[(int)size];
            Collections.shuffle(list);
            int idx = 0;
            for (int num : list) {
                curr_random[idx] = num;
                idx++;
            }
            
            // descending data
            int[] curr_decending = new int[(int)size];
            for (int i = (int)size - 1; i >= 0; i--) {
                curr_decending[i] = i;
            }
            
            
            // Test algorithms
            // 1. selection sort
            long startTime = System.currentTimeMillis();
            sort.selectionSort(curr_ascending);
            long endTime = System.currentTimeMillis();
            times[0][p] = endTime - startTime;
            
            // 2. insert sort
            startTime = System.currentTimeMillis();
            
            endTime = System.currentTimeMillis();            
            
            
            // 3. tree sort
            startTime = System.currentTimeMillis();
            
            endTime = System.currentTimeMillis();            
            
            
            // 4. heap sort
            startTime = System.currentTimeMillis();
            
            endTime = System.currentTimeMillis();           
        }
        
        
        //SortAlgos sort = new SortAlgos();
        //sort.heapSort(nums);
        //System.out.println(Arrays.toString(nums));
        
    }
    
    public void selectionSort(int[] nums) {
        // visit the first n-1 elements in the array.
        for (int i = 0; i < nums.length - 1; i++) {
            // for each index, find the minimum element and swap their values
            int index_min = i; // initiate the index of the minimum element
            // find the minimum element
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index_min] > nums[j]) index_min = j;
            }
            // swap the minimum element with ith element
            int tmp = nums[i];
            nums[i] = nums[index_min];
            nums[index_min] = tmp;
        }
    }
    
    public void insertionSort(int[] nums) {
        //start from the 2nd element in the array.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j = i - 1;
            // shift all elements that > num in range [0, i-1] one position right
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = num; // put num in the insertion position
        }
    }
    
    // implement tree sort using TreeSet
    public void treeSort(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num: nums) set.add(num);
        int i = 0;
        for (int num: set) {
            nums[i] = num;
            i++;
        }
    }
    
    // implement heap sort using PQ
    public void heapSort(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) minHeap.add(num);
        int i = 0;
        while (!minHeap.isEmpty()) {
            nums[i] = minHeap.poll();
            i++;
        }
    }
}
