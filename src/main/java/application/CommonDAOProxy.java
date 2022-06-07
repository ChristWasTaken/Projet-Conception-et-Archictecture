package application;

import accesPersistence.CommonDAO;

public class CommonDAOProxy {

    private static CommonDAOProxy instance = new CommonDAOProxy();

    public CommonDAOProxy() {
    }

    public static CommonDAOProxy getInstance() {
        return instance;
    }

    public CommonDAO connectionCommonDAO(){

        CommonDAO commonDAO = null;

        return commonDAO;
    }
}
