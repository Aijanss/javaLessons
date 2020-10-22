package com.company;


public class Runner extends Thread {
    private Runner nextRunner;

    public Runner(String name, Runner nextRunner) {
        this.nextRunner = nextRunner;
        this.setName(name);
    }

    public Runner(String name) {
        this.setName(name);
    }


    @Override
    public void run() {
        try{
            Thread.sleep(3000);
        }catch (Exception ae){}
        if (nextRunner != null){
            nextRunner.start();
        }
        System.out.printf("\n%s takes a stick and runs to ",this.getName());
        if (nextRunner != null){
            System.out.println(nextRunner.getName() + "\n");
            try {
                nextRunner.join();
                this.sleep(3000);
                System.out.printf("\n%s takes a stick and runs to ",nextRunner.getName());
                System.out.println(this.getName() + "\n");
            }catch (Exception ae){}
        }else {
            System.out.println("finish\n");
        }
        if (this.getName().equals("Runner 1")){
            System.out.println("\n"+ this.getName() +" takes a stick");
        }







    }
}


