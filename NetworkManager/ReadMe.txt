This is the network manager you'll use to connect to the vantage backend, hook your vantage backend event inside the while loop

Code to login to the vantage backend

        Client.INSTANCE.getNetworkManager().email = email;
        Client.INSTANCE.getNetworkManager().password = password;

        threadPool.execute(() -> Client.INSTANCE.getNetworkManager().init());

