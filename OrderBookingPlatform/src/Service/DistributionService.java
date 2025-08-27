package Service;
import Dao.DAO;
import Util.AsyncUtil;

public class DistributionService {
    private final DAO DAO;

    public DistributionService(DAO DAO) {
        this.DAO = DAO;
    }

    public void generateDispatchList(String date) {
        AsyncUtil.runAsync(() -> DAO.saveDistribution(date));
    }
}
