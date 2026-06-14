public class Solution {
    private long pow(long x, long e, long m) { // O(log e)
        if (e == 0) return 1;
        if ((e & 1) == 1) return (x * pow(x, e - 1, m)) % m;
        return pow((x * x) % m, e >> 1, m);
    }

    private boolean isStrong(int n, int a) { // O(log log n)
        int e = n - 1;
        int p = (int) pow(a, e, n);
        if (p != 1) return false;

        while (true) {
            e >>= 1;
            p = (int) pow(a, e, n);
            if (p == n - 1)
                return true;
            if ((e & 1) == 1) {
                if (p == 1)
                    return true;
                break;
            }
        }

        return false;
    }

    // Miller test
    public boolean isPrime(int n) {
        return isStrong(n, 2) && (n < 2047 || isStrong(n, 3));
    }

    public int[] closestPrimes(int i, int j) {
        int x = -1;
        int y = -1;

        if (i < 3) {
            x = 2;
            i = 3;
        } else {
            if ((i & 1) == 0) i++;
            for (; i <= j; i += 2) {
                if (isPrime(i)) {
                    x = i;
                    i += 2;
                    break;
                }
            }
        }

        for (; i <= j; i += 2) {
            if (isPrime(i)) {
                y = i;
                i += 2;
                break;
            }
        }

        for (int t = y; i <= j && y - x > 2; i += 2) {
            if (isPrime(i)) {
                if ((y - x) > (i - t)) {
                    x = t;
                    y = i;
                }
                t = i;
            }
        }

        if (y > 0) return new int[] { x, y };
        return new int[] { -1, -1 };
    }
}