/* 
User: Urmi
Date: 12/19/2019 
Time: 2:01 PM
*/

/**
 * Given a sorted array of strings that is interspersed with empty strings, write a
 * method to find the location of a given string.
 * Algorithm:
 * If it weren't for the empty strings, we could simply use binary search. We would compare the string to be
 * found, s t r , with the midpoint of the array, and go from there.
 * With empty strings interspersed, we can implement a simple modification of binary search. All we need to
 * do is fix the comparison against mid, in case mid is an empty string. We simply move mid to the closest
 * non-empty string
 */
package crackingcodeinterview;

//The worst-case runtime for this algorithm is 0 ( n ) .
public class SparseSearch {
    public int search(String[] arr, String key) {
        if (arr == null || key.isEmpty()) {
            return -1;
        }
        return searchIter(arr, 0, arr.length - 1, key);
    }

    private int searchIter(String[] arr, int start, int end, String key) {
        while (start <= end) {
            int mid = (start + end) / 2;
            //adjust mid
            if (arr[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left < start && right > end) {
                        return -1;
                    } else if (left >= start && !arr[left].isEmpty()) {//new mid
                        mid = left;
                        break;
                    }else if (right <= end && !arr[right].isEmpty()) {
                        mid = right;//new mid found
                        break;
                    }
                    left--;
                    right++;
                }
            }

            int res = arr[mid].compareTo(key);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }

    private int searchRecur(String[] arr, int start, int end, String key) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid].isEmpty()) {
            while (true) {
                int left = mid - 1;
                int right = mid + 1;
                if (left < start && right > end) {
                    return -1;
                } else if (right <= end && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= start && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                left--;
                right++;
            }
        }

        int res = arr[mid].compareTo(key);
        if (res == 0) {
            return mid;
        } else if (res < 0) {
            return searchRecur(arr, mid + 1, end, key);
        } else {
            return searchRecur(arr, start, mid - 1, key);
        }
    }
}
