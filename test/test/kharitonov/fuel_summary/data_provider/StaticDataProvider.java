package test.kharitonov.fuel_summary.data_provider;

import com.kharitonov.fuel_summary.entity.report.Report52;

public class StaticDataProvider {
    private static Report52 report52;

    public static Report52 getReport52() {
        return report52;
    }

    public static void setReport52(Report52 report52) {
        StaticDataProvider.report52 = report52;
    }
}
