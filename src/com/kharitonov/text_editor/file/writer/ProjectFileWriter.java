package com.kharitonov.text_editor.file.writer;

import com.kharitonov.text_editor.entity.FuelSummary;
import com.kharitonov.text_editor.entity.TruckDriver;
import com.kharitonov.text_editor.entity.TruckSummary;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class ProjectFileWriter {
    private static final String SPACE = " ";
    private static final int NAME_FORMAT_LENGTH = 15;
    private static final int ECONOMY_DAY_LENGTH = 4;

    public void write(FuelSummary fuelSummary, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\tЭкономия\\перерасход топлива на ")
                    .append(fuelSummary.getHeader()
                            .getDateCreation().get(Calendar.DAY_OF_MONTH))
                    .append(".")
                    .append(fuelSummary.getHeader()
                            .getDateCreation().get(Calendar.MONTH))
                    .append(".")
                    .append(fuelSummary.getHeader()
                            .getDateCreation().get(Calendar.YEAR))
                    .append("\n");
            sb.append("Гар. №\t\t").append("Водитель\t\t")
                    .append("Экономия\\перерасход\t\t")
                    .append("Последняя путевка\n");
            for (TruckSummary truckSummary :
                    fuelSummary.getTruckSummaryList()) {
                for (Map.Entry<TruckDriver, Double> entry :
                        truckSummary.getFuelEconomy().entrySet()) {
                    sb.append(truckSummary.getTruck().getGarageNumber());
                    sb.append("\t\t")
                            .append(formatName(entry.getKey().getName()))
                            .append("\t\t\t")
                            .append(formatDay(entry.getValue()))
                            .append("\t\t\t\t")
                            .append(truckSummary.getDayLast())
                            .append(".")
                            .append(fuelSummary.getHeader()
                                    .getMonth().getIndex())
                            .append(".")
                            .append(fuelSummary.getHeader().getYear());
                    sb.append("\n");
                }
            }
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String formatName(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.append(SPACE.repeat(Math.max(0,
                NAME_FORMAT_LENGTH - text.length())));
        return sb.toString();
    }

    private String formatDay(double day) {
        String stringDay = String.valueOf(day);
        StringBuilder sb = new StringBuilder(stringDay);
        sb.append(SPACE.repeat(Math.max(0,
                ECONOMY_DAY_LENGTH - stringDay.length())));
        return sb.toString();
    }
}
