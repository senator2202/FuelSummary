package test.kharitonov.fuel_summary.parser;

import com.kharitonov.fuel_summary.parser.Report52Parser;
import org.testng.annotations.Test;
import test.kharitonov.fuel_summary.data_provider.StaticDataProvider;

import static org.testng.Assert.*;

public class Report52ParserTest {
    Report52Parser parser = new Report52Parser();

    @Test
    public void testParseReport52() {
        StaticDataProvider.setReport52(parser.parseReport52(""));
    }
}