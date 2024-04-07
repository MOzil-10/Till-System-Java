package service;

import models.TillModel;

//this class communicates with all services to make calculations, read a file and write to a file
public class DriverClass {
     int tillBalance;
    public  DriverClass(){
         tillBalance = 500;
    }
    public void TillManager() {
        TillService  tillService = new TillService();
        FileReaderHandler fileProcessor = new FileReaderHandler();
        FileWriterHandler fileWriterHandler = new FileWriterHandler();
        String line = fileProcessor.readLine();
        while(line != null) {
            //separate transaction and the total paid
            String[] transactionsAndPayment = line.split(",");
            //separate transactions
            String[] transactions = transactionsAndPayment[0]
                    .split(";");
            //separate amount paid
            String[] amountsStr = transactionsAndPayment[transactionsAndPayment.length - 1]
                    .split("-");
            //get values from Till services
            int change = tillService.processPaidAmount(amountsStr) - tillService.processTotalTransaction(transactions);

            int amountPaid =  tillService.processPaidAmount(amountsStr);
            int totalTransactions =  tillService.processTotalTransaction(transactions);
            String changeBreakDown =  tillService.changeBreakDown(change);
            TillModel  tillModel = new TillModel(
                    tillBalance,
                    amountPaid,
                    change,
                    totalTransactions,
                    changeBreakDown
            );
            tillBalance += totalTransactions;
            System.out.println(tillModel);
            line = fileProcessor.readLine();
            fileWriterHandler.saveLineToFile(tillModel);
        }

    }
}