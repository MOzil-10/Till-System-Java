package service;

public class TillService {
    public  String changeBreakDown(int change) {
        int[] note = {50, 20, 10, 5, 2, 1};
        int[] count = new int[note.length];
        StringBuilder changeBreakDownStr = new StringBuilder();

        for (int i = 0; i < note.length; i++) {
            while (change >= note[i]) {
                change -= note[i];
                count[i]++;
            }
        }

        boolean first = true;
        for (int i = 0; i < note.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (!first) {
                    changeBreakDownStr.append("-");
                } else {
                    first = false;
                }
                changeBreakDownStr.append("R").append(note[i]);
            }
        }
        return changeBreakDownStr.toString();
    }
    public int processPaidAmount(String[] amountsStr){
        int paid = 0;
        for (int i = 0; i < amountsStr.length; i++) {
            String paidString;
            if (amountsStr[i].length() == 2) {
                paidString = amountsStr[i].trim().substring(1);

            } else if (amountsStr[i].length() == 3) {
                paidString = amountsStr[i].trim().substring(1, 3);

            } else {
                paidString = amountsStr[i].trim().substring(1, 4);
            }
            paid += Integer.parseInt(paidString);
        }
        return  paid;
    }
    public  int processTotalTransaction(String[]transactions){
        int totalTransaction = 0;
        for (int i = 0; i < transactions.length; i++) {
            String [] parts = transactions[i].split(" ");
            totalTransaction  += Integer.parseInt(parts[parts.length - 1].trim().substring(1));
        }
        return  totalTransaction;
    }


}
