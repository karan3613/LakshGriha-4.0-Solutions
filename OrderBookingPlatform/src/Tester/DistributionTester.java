package Tester;

import Service.DistributionService;

public class DistributionTester {
    private final DistributionService distributionService;

    public DistributionTester(DistributionService distributionService) {
        this.distributionService = distributionService;
    }
    public void readDistributionListInfo() {
        String date = ReadData.acceptString("Date Of Distribution (DD-MMM-YYYY): ");
        distributionService.generateDispatchList(date);
    }
}
