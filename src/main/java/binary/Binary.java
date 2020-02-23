package binary;

public class Binary {

    public int giveResult(int a) {
        return countZeroBetweenOnes(binary(a));
    }

    public int timeOutTest() throws InterruptedException {
        for (int a = 0; a < 2000; a++) {
//            try {
                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return 36;
    }

    public int countZeroBetweenOnes(String binary) {
        char[] binaryChar = binary.toCharArray();
        int maxRep = 0;
        int counter = 0;

        for (int i = 0; i < binaryChar.length; i++) {
            if (binaryChar[i] == '1') {
                if (maxRep < counter) {
                    maxRep = counter;
                    counter = 0;
                }
            } else {
                counter++;
            }
        }
        return maxRep;
    }

    public int method(String z) {
        z = z.substring(0, z.lastIndexOf('1'));
        String[] zeroTab = z.split("1");
        int max = 0;
        for (String s : zeroTab) {
            int size = s.length();
            if (size > max) {
                max = size;
            }
        }
        return max;
    }

    public String binary(int a) {
        if (a == 0) {
            return "0";
        }
        if (a > 0) {
            StringBuilder b = new StringBuilder();
            while (a > 0) {
                b.append(a % 2);
                a /= 2;
            }
            return b.reverse().toString();
        } else {
            int b = Math.abs(a) - 1;
            StringBuilder reversePositiveBinaryNumber = new StringBuilder();
            while (b > 0) {
                reversePositiveBinaryNumber.append(b % 2 == 1 ? 0 : 1);
                b /= 2;
            }
            String positiveBinaryNumber = reversePositiveBinaryNumber.reverse().toString();
            int length = positiveBinaryNumber.length();
            StringBuilder adding1 = new StringBuilder();
            for (int i = 0; i < 32 - length; i++) {
                adding1.append("1");
            }
            return adding1.append(positiveBinaryNumber).toString();
        }
    }

}
