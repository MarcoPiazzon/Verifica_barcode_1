package Verifica_Barcode_1;

/**
 * Hello world!
 *
 */
    import java.util.Arrays;

    public class App {

        public static String[] lcode = {"0001101", "0011001", "0010011", "0111101", "0100011",
                "0110001", "0101111", "0111011", "0110111", "0001011"};

        public static String[] gcode = {"0100111", "0110011", "0011011", "0100001", "0011101",
                "0111001", "0000101", "0010001", "0001001", "0010111"};

        public static String[] rcode = {"1110010", "1100110", "1101100", "1000010", "1011100",
                "1001110", "1010000", "1000100", "1001000", "1110100"};

        public static void main(String[] args) {
            int first = 6;
            String barcode = "10101111010000101010011101110010010011001001101010101110011011001001000111001010000101000100101";
            System.out.println(readBarcode(first, barcode));
        }//end main

        public static String readBarcode(int first, String barcode) {
            String ris = "";

            String[] area = split(barcode);
            String[] group1 = fill(area[1]);
            String[] group2 = fill(area[3]);

            for (int i = 0; i < group1.length; i++) {
                ris += LGR(group1[i]);
            }
            for (int i = 0; i < group2.length; i++) {
                ris += LGR(group2[i]);
            }
            return first + ris;

        }//end readBarccode

        public static String[] split(String barcode) {
            StringBuilder sb = new StringBuilder();
            sb.append(barcode);
            sb.insert(3, ".");
            sb.insert(46, ".");
            sb.insert(52, ".");
            sb.insert(95, ".");
            String[] area = sb.toString().split("\\.");
            return area;
        }//end split

        public static String[] fill(String str) {
            String[] group = new String[6];
            int num1 = 0;
            int num2 = 7;
            for (int i = 0; i < 6; i++) {
                String string = str.substring(num1, num2);
                group[i] = string;
                num1 = num2;
                num2 += 7;
            }
            return group;
        }//end fill

        public static String LGR(String str) {
            String ris = "";
            if (str.charAt(0) == '1') {
                ris += Arrays.asList(rcode).indexOf(str);
            } else if (Arrays.asList(lcode).indexOf(str) >= 0) {
                ris += Arrays.asList(lcode).indexOf(str);
            } else {
                ris += Arrays.asList(gcode).indexOf(str);
            }
            return ris;
        }//end LGR

    }//end class

