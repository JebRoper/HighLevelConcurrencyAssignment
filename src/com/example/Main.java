package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    static ArrayList<String> stockNames = new ArrayList<>();
    static ArrayList<String> traderNames = new ArrayList<>();
    static Random random = new Random();

    static {
        stockNames.add("ABC");
        stockNames.add("IBM");
        stockNames.add("TIY");

        traderNames.add("Steve Johnson");
        traderNames.add("Abby Aberson");
        traderNames.add("Joe Jarrett");
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TraderServiceImpl traderService = new TraderServiceImpl();

        List<Callable> callables = new ArrayList<>();


        for (int i = 0; i < 100; i++) {

            AddShares addShares = new AddShares(traderService,
                    stockNames.get(random.nextInt(3)),
                    random.nextInt(100),
                    random.nextInt(50));
            callables.add(addShares);

            BuyShares buyShares = new BuyShares(traderService, traderNames.get(random.nextInt(3)),
                    stockNames.get(random.nextInt(3)),
                    random.nextInt(25),
                    random.nextInt(50));
            callables.add(buyShares);

            GetShares getShares = new GetShares(stockNames.get(random.nextInt(3)), traderService);
            callables.add(getShares);

            ExecutorService executorService = Executors.newFixedThreadPool(5);
            List<Future> futures = new ArrayList<>();
            for (Callable callable : callables) {
                Future future = executorService.submit(callable);
                futures.add(future);
            }

            for (Future future : futures) {
                System.out.println(future.get());
            }
            executorService.shutdown();
            System.out.println(traderService.getTrades());
        }
    }
}
