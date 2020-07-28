package com.kharitonov.text_editor.file.writer;

import com.kharitonov.text_editor.entity.TruckDriver;
import com.kharitonov.text_editor.entity.TruckSummary;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ProjectFileWriter {
    public void write(List<TruckSummary> list, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            LocalDateTime now = LocalDateTime.now();
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\tПерерасход\\экономия топлива на ")
                    .append(now.getDayOfMonth())
                    .append(".")
                    .append(now.getMonth().getValue())
                    .append(".")
                    .append(now.getYear())
                    .append("\n");
            sb.append("Гаражный номер а/м\t\t").append("Водитель\t\t")
                    .append("Экономия\\перерасход\t\t")
                    .append("Дата последней путевки\n");
            for (TruckSummary truckSummary : list) {
                for (Map.Entry<TruckDriver, Double> entry :
                        truckSummary.getFuelEconomy().entrySet()) {
                    sb.append(truckSummary.getTruck().getGarageNumber());
                    sb.append("\t\t\t\t")
                            .append(entry.getKey().getName())
                            .append("\t\t\t\t")
                            .append(entry.getValue())
                            .append("\t\t\t\t\t\t")
                            .append(truckSummary.getDayLast());
                    sb.append("\n");
                }
            }
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
